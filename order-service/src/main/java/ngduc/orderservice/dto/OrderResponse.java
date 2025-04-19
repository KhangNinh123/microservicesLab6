package ngduc.orderservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long orderId;
    private CustomerDTO customer;
    private List<OrderItemDTO> products;
    private double totalAmount;
    private LocalDateTime createdAt;
}