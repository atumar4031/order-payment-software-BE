package link.attech.paymentservice.service.impl;

import link.attech.paymentservice.entity.Payment;
import link.attech.paymentservice.repository.PaymentRepositoty;
import link.attech.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepositoty paymentRepository;
    @Override
    public Payment makePayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentStatus());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findPaymentHistoryByOrderId(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    private String paymentStatus() {
        return new Random().nextBoolean() ? "success" : "failed";
    }
}
