package link.attech.orderpaymentgateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @RequestMapping("/orderfallback")
    public Mono<String> orderServiceFallback(){
        return Mono.just("Order service is temporary not available");
    }

    @RequestMapping("/paymentfallback")
    public Mono<String> paymentServiceFallback(){
        return Mono.just("Payment service is temporary not available");
    }
}
