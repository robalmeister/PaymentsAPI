package io.github.robalmeister.payments.cashbill.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CashbillInformation {
    @NotNull
    private String shopId;

    @NotNull
    private String shopKey;

    private boolean testMode;

    public CashbillInformation(@NotNull String shopId, @NotNull String shopKey, boolean testMode) {
        Objects.requireNonNull(shopId, "shopId cannot be null");
        Objects.requireNonNull(shopKey, "shopKey cannot be null");
        this.shopId = shopId;
        this.shopKey = shopKey;
        this.testMode = testMode;
    }

    @NotNull
    public String getShopId() {
        return shopId;
    }

    public void setShopId(@NotNull String shopId) {
        Objects.requireNonNull(shopId, "shopId cannot be null");
        this.shopId = shopId;
    }

    @NotNull
    public String getShopKey() {
        return shopKey;
    }

    public void setShopKey(@NotNull String shopKey) {
        Objects.requireNonNull(shopKey, "shopToken cannot be null");
        this.shopKey = shopKey;
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashbillInformation that = (CashbillInformation) o;
        return testMode == that.testMode && Objects.equals(shopId, that.shopId) && Objects.equals(shopKey, that.shopKey);
    }

    @Override
    public String toString() {
        return "CashbillInformation{" +
                "shopId='" + shopId + '\'' +
                ", shopKey='" + shopKey + '\'' +
                ", testMode=" + testMode +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, shopKey, testMode);
    }
}
