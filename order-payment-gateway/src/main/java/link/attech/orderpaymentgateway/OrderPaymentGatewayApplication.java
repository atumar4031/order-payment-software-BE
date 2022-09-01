package link.attech.orderpaymentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderPaymentGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderPaymentGatewayApplication.class, args);
    }

}
