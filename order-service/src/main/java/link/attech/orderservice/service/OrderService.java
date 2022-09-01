package link.attech.orderservice.service;

import link.attech.orderservice.entity.Order;
import link.attech.orderservice.request.TransactionRequest;
import link.attech.orderservice.response.TransactionResponse;

public interface OrderService {
    TransactionResponse saveOrder(TransactionRequest transactionRequest);
}
