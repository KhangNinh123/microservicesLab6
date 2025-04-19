package ngduc.orderservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
}