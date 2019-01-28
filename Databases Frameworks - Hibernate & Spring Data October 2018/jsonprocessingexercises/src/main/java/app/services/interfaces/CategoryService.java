package app.services.interfaces;

import app.models.dto.CategoryByProductsDto;
import app.models.dto.Query4Dto;
import app.models.dto.bindingModels.CreateCategoryDto;
import app.models.dto.xmlProcessing.query3.CategoryByProductsRootDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void createCategory(CreateCategoryDto categoryDto);
    void createAllCategories(List<CreateCategoryDto> createCategoryDtos);
    List<CategoryByProductsDto> getCategoriesByProductsCount();
    CategoryByProductsRootDto exportCategoriesProducts();

}
