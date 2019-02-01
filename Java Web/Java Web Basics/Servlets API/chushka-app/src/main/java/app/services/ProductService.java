package app.services;

import app.domain.models.service.ProductServiceModel;
import app.domain.models.views.ProductViewModel;

import java.util.List;

public interface ProductService {
    List<ProductServiceModel> getAllProducts();
    ProductServiceModel getProductById(Long id);
    ProductViewModel getProductByName(String name);
    void saveProduct(ProductServiceModel productServiceModel);
}
