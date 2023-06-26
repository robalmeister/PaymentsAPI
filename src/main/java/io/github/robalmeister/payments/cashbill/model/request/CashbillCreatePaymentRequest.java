package io.github.robalmeister.payments.cashbill.model.request;


import io.github.robalmeister.payments.cashbill.model.AmountData;
import io.github.robalmeister.payments.cashbill.model.Personal;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

@Builder
@Getter
public class CashbillCreatePaymentRequest {

    /**
     * Title of the transaction
     */
    @NonNull
    private String title;

    /**
     * Amount with currency code of the transaction
     */
    @NonNull
    private AmountData amount;

    /**
     * Description of the transaction
     */
    private String description;

    /**
     * Additional transaction data, hidden from customer
     */
    private String additionalData;

    /**
     * URL of landing page after successful transaction
     */
    private String returnUrl;

    /**
     * URL of landing page after unsuccessful transaction. If committed, customer will be redirected to returnUrl
     */
    private String negativeReturnUrl;
    /**
     * ID of payment channel obtained from GET paymentChannels, request. If committed, customer will be prompted with default CashBill payment channel selection screen.
     */
    private String paymentChannel;

    /**
     * Language
     */
    private Language languageCode;

    /**
     * Data object of person
     */
    private Personal personalData;


    /**
     * Shopping platform identifier
     */
    private String referer;
    /**
     * Options
     */
    private Map<String, String> options;



    public enum Language {
        PL, EN
    }


}
