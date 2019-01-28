package alararestaurant.service;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    String exportCategoriesByCountOfItems();
}
