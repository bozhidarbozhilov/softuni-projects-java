package app.services.interfaces;

import app.models.dto.bindingModels.CreateProductDto;
import app.models.dto.NoBuyerProductsDto;
import app.models.dto.xmlProcessing.query1.ProductsInRangeRootDto;
import app.models.dto.xmlProcessing.query2.SoldProductRootDto;
import app.models.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ProductService {

    void createProduct(CreateProductDto productDto);

    void createAll(List<CreateProductDto> createProductDtos);

    List<NoBuyerProductsDto> productsWithNoBuyersByPriceRange();

    ProductsInRangeRootDto exportProductsInRangeToXml(List<NoBuyerProductsDto> noBuyerProductsDtos);

    SoldProductRootDto createSoldProductRootDto(Set<Product> products);
}
