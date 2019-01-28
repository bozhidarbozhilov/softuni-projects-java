package alararestaurant.repository;

import alararestaurant.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select o from alararestaurant.domain.entities.Order o join " +
            "o.employee e join e.position p where p.name = 'Burger Flipper' " +
            "order by e.name asc , o.id asc ")
    List<Order> ordersFinishedByBurgerFlippers();
}
