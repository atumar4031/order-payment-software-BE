package link.attech.orderservice.service.impl;

import link.attech.orderservice.commons.Payment;
import link.attech.orderservice.entity.Order;
import link.attech.orderservice.repository.OrderRepository;
import link.attech.orderservice.request.TransactionRequest;
import link.attech.orderservice.response.TransactionResponse;
import link.attech.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@RefreshScope
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Lazy
    private final RestTemplate restTemplate;
    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String PAYMENT_URI;

    @Transactional
    @Override
    public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
        String message = "";
        Order order =orderRepository.save(transactionRequest.getOrder());
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setAmount(order.getPrice());

        // Rest Call hear
        Payment paymentResponse = restTemplate.postForObject(PAYMENT_URI, payment, Payment.class);
        message = paymentResponse.getPaymentStatus().equals("success") ? "Payment succeed" : "payment failed and order added to cart";
        return new TransactionResponse(HttpStatus.OK, message, order, paymentResponse.getTransactionId(), paymentResponse.getAmount());
    }
}
