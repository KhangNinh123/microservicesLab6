package ngduc.orderservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private ProductDTO product;
    private int quantity;
    private double itemTotal;
}