package link.attech.orderservice.response;

import link.attech.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionResponse {
    private HttpStatus status;
    private String message;
    private Order order;
    private String transactionId;
    private Double amount;

}
