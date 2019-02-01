package app.services;

import app.domain.entities.Product;
import app.domain.enums.ProductType;
import app.domain.models.service.ProductServiceModel;
import app.domain.models.views.ProductViewModel;
import app.repositories.ProductRepository;
import app.utils.ModelMapper;


import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;


    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper){
        this.productRepository = productRepository;
        this.mapper = mapper;
    }
    @Override
    public List<ProductServiceModel> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        List<ProductServiceModel> productServiceModels = products.stream()
                .map(product -> this.mapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
        return productServiceModels;
    }

    @Override
    public ProductServiceModel getProductById(Long id) {
        Product product = this.productRepository.findById(id);
        ProductServiceModel productServiceModel = this.mapper.map(product, ProductServiceModel.class);
        return productServiceModel;
    }

    @Override
    public ProductViewModel getProductByName(String name) {
        Product product = this.productRepository.findByName(name);
        ProductViewModel productViewModel = this.mapper.map(product, ProductViewModel.class);
        return productViewModel;
    }

    @Override
    public void saveProduct(ProductServiceModel productServiceModel) {
        Product product = this.mapper.map(productServiceModel, Product.class);
        product.setProductType(ProductType.valueOf(productServiceModel.getProductType()));
        this.productRepository.save(product);
    }
}
