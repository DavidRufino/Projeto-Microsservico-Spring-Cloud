package one.digitalinnovation.productcatalog.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.productcatalog.dto.response.MessageResponseDTO;
import one.digitalinnovation.productcatalog.exception.ProductNotFoundException;
import one.digitalinnovation.productcatalog.model.Product;
import one.digitalinnovation.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    ProductRepository productRepository;

    public MessageResponseDTO create(Product product) {
        var result = productRepository.save(product);
        return createMessageResponse(("Created " + result));
    }

    public MessageResponseDTO findById(Long IdProduct) throws ProductNotFoundException {
        var result = verifyIfExists(IdProduct);

        return createMessageResponse(("Found " + result));
    }

    private Product verifyIfExists(Long IdProduct) throws ProductNotFoundException {
        return productRepository.findById(IdProduct)
                .orElseThrow(() -> new ProductNotFoundException(IdProduct));
    }

    private MessageResponseDTO createMessageResponse(String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg)
                .build();
    }
}
