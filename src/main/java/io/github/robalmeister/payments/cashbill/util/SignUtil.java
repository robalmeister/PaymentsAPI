package io.github.robalmeister.payments.cashbill.util;

import io.github.robalmeister.payments.cashbill.model.CashbillInformation;
import io.github.robalmeister.payments.cashbill.model.request.CashbillCreatePaymentRequest;
import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.DigestUtils;

@UtilityClass
public class SignUtil {
    public String sign(CashbillCreatePaymentRequest req, CashbillInformation information) {
        StringBuilder sb = new StringBuilder();
        sb.append(req.getTitle());
        sb.append(req.getAmount().getAmount());
        sb.append(req.getAmount().getCurrencyCode());
        sb.append(req.getReturnUrl() != null ? req.getReturnUrl() : "");
        sb.append(req.getDescription() != null ? req.getDescription() : "");
        sb.append(req.getNegativeReturnUrl() != null ? req.getNegativeReturnUrl() : "");
        sb.append(req.getAdditionalData() != null ? req.getAdditionalData() : "");
        sb.append(req.getPaymentChannel() != null ? req.getPaymentChannel() : "");
        sb.append(req.getLanguageCode() != null ? req.getLanguageCode().name() : "");
        sb.append(req.getReferer() != null ? req.getReferer() : "");
        if (req.getPersonalData() != null) {
            sb.append(req.getPersonalData().getFirstName() != null ? req.getPersonalData().getFirstName() : "");
            sb.append(req.getPersonalData().getSurname() != null ? req.getPersonalData().getSurname() : "");
            sb.append(req.getPersonalData().getEmail() != null ? req.getPersonalData().getEmail() : "");
            sb.append(req.getPersonalData().getCountry() != null ? req.getPersonalData().getCountry() : "");
            sb.append(req.getPersonalData().getCity() != null ? req.getPersonalData().getCity() : "");
            sb.append(req.getPersonalData().getPostcode() != null ? req.getPersonalData().getPostcode() : "");
            sb.append(req.getPersonalData().getStreet() != null ? req.getPersonalData().getStreet() : "");
            sb.append(req.getPersonalData().getHouse() != null ? req.getPersonalData().getHouse() : "");
            sb.append(req.getPersonalData().getFlat() != null ? req.getPersonalData().getFlat() : "");
            sb.append(req.getPersonalData().getIp() != null ? req.getPersonalData().getIp() : "");
        }
        if (req.getOptions() != null) {
            StringBuilder mapBuilder = new StringBuilder();
            req.getOptions().forEach((s, s2) -> mapBuilder.append(s).append(s2));
            sb.append(mapBuilder);
        }
        sb.append(information.getShopKey());
        return DigestUtils.sha1Hex(sb.toString());
    }
}
