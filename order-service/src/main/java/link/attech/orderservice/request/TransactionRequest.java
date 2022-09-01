package link.attech.orderservice.request;

import link.attech.orderservice.commons.Payment;
import link.attech.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionRequest {
    private Order order;
    private Payment payment;
}
