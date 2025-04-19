package ngduc.orderservice.dto;

import lombok.*;
import ngduc.orderservice.model.OrderItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private CustomerDTO customer;
    private List<OrderItem> items;
}