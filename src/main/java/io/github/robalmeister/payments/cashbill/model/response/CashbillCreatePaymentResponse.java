package io.github.robalmeister.payments.cashbill.model.response;

import lombok.Getter;

@Getter
public class CashbillCreatePaymentResponse {
    /**
     * Payment Id
     */
    private final String id;

    /**
     * The address to which the browser should redirect customer to start payment
     */
    private final String redirectUrl;

    public CashbillCreatePaymentResponse(String id, String redirectUrl) {
        this.id = id;
        this.redirectUrl = redirectUrl;
    }
}
