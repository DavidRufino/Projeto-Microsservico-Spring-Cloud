package one.digitalinnovation.productcatalog.dto.response;

import lombok.Builder;
import lombok.Data;
import one.digitalinnovation.productcatalog.model.Product;

@Data
@Builder
public class MessageResponseDTO {
    private String message;
    private Product object;
}
