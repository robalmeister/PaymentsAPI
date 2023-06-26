package io.github.robalmeister.payments.cashbill.model.request;

import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

@Getter
public class CashbillGetPaymentRequest {
    /**
     * Order ID
     */
    @NonNull
    private final String orderId;


    public CashbillGetPaymentRequest(@NotNull String orderId) {
        this.orderId = orderId;
    }
}
