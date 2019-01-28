package app.services.implementations;

import app.models.Category;
import app.repositories.CategoryRepository;
import app.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return this.categoryRepository.findById(id);
    }
}
