package io.github.robalmeister.payments.cashbill.model.response;

import io.github.robalmeister.payments.cashbill.model.AmountData;
import io.github.robalmeister.payments.cashbill.model.Personal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CashbillGetPaymentResponse {
    private String id;
    private String paymentChannel;
    private AmountData amount;
    private AmountData requestedAmount;
    private String title;
    private String description;
    private Personal personalData;
    private String additionalData;
    private String status;



}
