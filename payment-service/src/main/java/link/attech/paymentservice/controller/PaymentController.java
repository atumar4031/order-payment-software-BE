package link.attech.paymentservice.controller;

import link.attech.paymentservice.entity.Payment;
import link.attech.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/makePayment")
    public Payment makePayment(@RequestBody Payment payment){
        return paymentService.makePayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable String orderId){
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }
}
