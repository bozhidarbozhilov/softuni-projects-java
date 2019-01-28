package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public String exportCategoriesByCountOfItems() {
        StringBuilder ouputCategoryItems = new StringBuilder();
        List<Category> categories = this.categoryRepository.categoryItems();
        for (Category category : categories) {
            ouputCategoryItems.append(String.format("Category: %s", category.getName()))
                    .append(System.lineSeparator());
            category.getItems().forEach(item ->
                    ouputCategoryItems.append(String.format("---Item Name: %s",item.getName()))
                            .append(System.lineSeparator())
                            .append(String.format("---Item Price: %s",item.getPrice()))
                            .append(System.lineSeparator()));
        }
        return ouputCategoryItems.toString();
    }
}
