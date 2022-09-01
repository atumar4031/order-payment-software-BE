package link.attech.orderservice.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    private Long paymentId;
    private String paymentStatus;
    private String transactionId;
    private Double amount;
    private Long orderId;
}
