package io.github.robalmeister.payments.api;

public interface PaymentAPI<CreatePaymentRequest, CreatePaymentResponse, GetPaymentRequest, GetPaymentResponse> {

    CreatePaymentResponse createPayment(CreatePaymentRequest payment);

    GetPaymentResponse getPayment(GetPaymentRequest payment);
}
