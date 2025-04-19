package ngduc.orderservice.external;

import ngduc.orderservice.dto.CustomerDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public CustomerDTO getCustomerById(Long id) {
        try {
            return restTemplate.getForObject("http://localhost:8083/customers/" + id, CustomerDTO.class);
        } catch (Exception e) {
            System.err.println("Failed to fetch customer with ID " + id + ": " + e.getMessage());
            return null;
        }
    }
}