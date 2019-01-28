package app.repositories;

import app.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select p from Product p where p.buyer = null " +
            "and p.price between 500 and 1000")
    List<Product> getProductsWithNoBuyer();
}
