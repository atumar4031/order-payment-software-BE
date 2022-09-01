package link.attech.paymentservice.service;

import link.attech.paymentservice.entity.Payment;

public interface PaymentService {
    Payment makePayment(Payment payment);
    Payment findPaymentHistoryByOrderId(String orderId);
}
