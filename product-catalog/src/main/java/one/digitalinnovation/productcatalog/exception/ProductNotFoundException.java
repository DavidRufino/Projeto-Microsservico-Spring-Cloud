package one.digitalinnovation.productcatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(Long IdProduct) {
        super("Product ID: " + IdProduct + " Not Found");
    }
}
