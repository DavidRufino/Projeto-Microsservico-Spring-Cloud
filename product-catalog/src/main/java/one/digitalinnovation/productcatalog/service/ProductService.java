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

        return createMessageResponse(("Created Product Name: " + result.getName()), result);
    }

    public MessageResponseDTO findById(Long idProduct) throws ProductNotFoundException {
        var result = verifyIfExists(idProduct);

        return createMessageResponse(("Found Product ID: " + idProduct), result);
    }

    private Product verifyIfExists(Long idProduct) throws ProductNotFoundException {
        return productRepository.findById(idProduct)
                .orElseThrow(() -> new ProductNotFoundException(idProduct));
    }

    private MessageResponseDTO createMessageResponse(String msg, Product product) {
        return MessageResponseDTO
                .builder()
                .message(msg)
                .object(product)
                .build();
    }
}
