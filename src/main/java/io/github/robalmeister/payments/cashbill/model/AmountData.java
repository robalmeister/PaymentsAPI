package io.github.robalmeister.payments.cashbill.model;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class AmountData {
    /**
     * Amount of the transaction
     */
    private final double amount;

    /**
     * ISO 4217 currency code
     */
    @NonNull
    private final String currencyCode;

    public AmountData(double amount, @NonNull String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }
}
