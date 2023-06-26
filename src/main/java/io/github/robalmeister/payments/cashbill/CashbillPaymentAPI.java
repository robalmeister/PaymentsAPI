package io.github.robalmeister.payments.cashbill;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.github.robalmeister.payments.api.PaymentAPI;
import io.github.robalmeister.payments.api.exceptions.JsonException;
import io.github.robalmeister.payments.api.exceptions.NetworkException;
import io.github.robalmeister.payments.api.exceptions.NotSuccessfulException;
import io.github.robalmeister.payments.cashbill.model.CashbillInformation;
import io.github.robalmeister.payments.cashbill.model.request.CashbillCreatePaymentRequest;
import io.github.robalmeister.payments.cashbill.model.request.CashbillGetPaymentRequest;
import io.github.robalmeister.payments.cashbill.model.response.CashbillCreatePaymentResponse;
import io.github.robalmeister.payments.cashbill.model.response.CashbillGetPaymentResponse;
import io.github.robalmeister.payments.cashbill.util.SignUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import static io.github.robalmeister.payments.api.util.Json.GSON;
import static io.github.robalmeister.payments.api.util.Json.TYPE_JSON;

public class CashbillPaymentAPI implements PaymentAPI<
        CashbillCreatePaymentRequest,
        CashbillCreatePaymentResponse,
        CashbillGetPaymentRequest,
        CashbillGetPaymentResponse
        > {
    @NotNull
    private final CashbillInformation information;

    @NotNull
    private final OkHttpClient client;

    public CashbillPaymentAPI(@NotNull CashbillInformation information, @NotNull OkHttpClient client) {
        Objects.requireNonNull(information, "CashbillInformation cannot be null");
        Objects.requireNonNull(information, "OkHttpClient cannot be null");
        this.client = client;
        this.information = information;
    }

    public CashbillPaymentAPI(@NotNull CashbillInformation information) {
        this(information, new OkHttpClient());
    }
    @Override
    @NotNull
    public CashbillCreatePaymentResponse createPayment(CashbillCreatePaymentRequest payment) {
        try {
            JsonObject object = GSON.toJsonTree(payment).getAsJsonObject();
            object.addProperty("sign", SignUtil.sign(payment, information));
            String json = GSON.toJson(object);
            RequestBody requestBody = RequestBody.create(json, TYPE_JSON);
            Request request = new Request.Builder()
                    .url("https://pay.cashbill.pl/:ws/rest/payment/:shopId"
                            .replace(":ws", information.isTestMode() ? "testws" : "ws")
                            .replace(":shopId", information.getShopId()))
                    .post(requestBody)
                    .build();
            Response res = client.newCall(request).execute();
            String body = res.body().string();
            if (!res.isSuccessful())
                throw new NotSuccessfulException("Cannot create payment (code: " + res.code() + ")", body);
            return GSON.fromJson(body, CashbillCreatePaymentResponse.class);
        } catch (IOException e) {
            throw new NetworkException("Cannot execute response for create payment", e);
        } catch (JsonParseException e) {
            throw new JsonException("Cannot parse response for create payment", e);
        }
    }

    @Override
    @NotNull
    public CashbillGetPaymentResponse getPayment(CashbillGetPaymentRequest payment) {
        try {
            Request request = new Request.Builder()
                    .url("https://pay.cashbill.pl/:ws/rest/payment/:shopId/:orderId?sign=:sign"
                            .replace(":ws", information.isTestMode() ? "testws" : "ws")
                            .replace(":shopId", information.getShopId())
                            .replace(":orderId", payment.getOrderId())
                            .replace(":sign", DigestUtils.sha1Hex(payment.getOrderId() + information.getShopKey()))
                    )
                    .get()
                    .build();
            Response res = client.newCall(request).execute();
            String body = res.body().string();
            if (!res.isSuccessful())
                throw new NotSuccessfulException("Cannot get payment (code: " + res.code() + ")", body);
            return GSON.fromJson(body, CashbillGetPaymentResponse.class);
        } catch (IOException e) {
            throw new NetworkException("Cannot execute response for get payment", e);
        } catch (JsonParseException e) {
            throw new JsonException("Cannot parse response for get payment", e);
        }
    }


}
