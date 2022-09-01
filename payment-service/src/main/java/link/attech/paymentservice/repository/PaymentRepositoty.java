package link.attech.paymentservice.repository;

import link.attech.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoty extends JpaRepository<Payment, Long> {
    Payment findByOrderId(String orderId);
}
