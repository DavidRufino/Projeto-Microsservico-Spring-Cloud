package one.digitalinnovation.productcatalog.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.productcatalog.dto.response.MessageResponseDTO;
import one.digitalinnovation.productcatalog.exception.ProductNotFoundException;
import one.digitalinnovation.productcatalog.model.Product;
import one.digitalinnovation.productcatalog.repository.ProductRepository;
import one.digitalinnovation.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/{IdProduct}")
    public MessageResponseDTO findById(@PathVariable Long IdProduct) throws ProductNotFoundException {
        return productService.findById(IdProduct);
    }
}
