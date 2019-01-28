package app.services.interfaces;

import app.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    void save(Category category);
    Optional<Category> getCategoryById(Long id);
}
