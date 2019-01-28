package app.services.implementations;

import app.models.dto.CategoryByProductsDto;
import app.models.dto.Query4Dto;
import app.models.dto.bindingModels.CreateCategoryDto;
import app.models.dto.xmlProcessing.query3.CategoryByProductsRootDto;
import app.models.entities.Category;
import app.repositories.CategoryRepository;
import app.services.interfaces.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public void createCategory(CreateCategoryDto categoryDto) {

        Category category=mapper.map(categoryDto, Category.class);
        this.categoryRepository.save(category);

    }

    @Override
    public void createAllCategories(List<CreateCategoryDto> createCategoryDtos) {
        for (CreateCategoryDto createCategoryDto : createCategoryDtos) {
            createCategory(createCategoryDto);
        }
    }

    @Override
    public List<CategoryByProductsDto> getCategoriesByProductsCount() {
        return this.categoryRepository.getCategoriesByProductsCount();
    }

    @Override
    public CategoryByProductsRootDto exportCategoriesProducts() {
        CategoryByProductsRootDto category = new CategoryByProductsRootDto();
        category.setCategories(this.categoryRepository.getCategoriesByProductsCount());
        return category;
    }




}
