package app.repositories;

import app.models.dto.CategoryByProductsDto;
import app.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select new app.models.dto.CategoryByProductsDto(c.name, c.products.size, avg(p.price)," +
            " sum(p.price)) " +
            "from Category c join c.products p " +
            "group by c.id " +
            "order by c.products.size desc ")
    List<CategoryByProductsDto> getCategoriesByProductsCount();
}
