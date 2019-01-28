package app.repositories;

import app.models.dtos.view.OrderedCustomersDto;
import app.models.dtos.view.TotalSaleDto;
import app.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select c " +
            "from Customer c " +
            "order by c.birthDate asc, c.youngDriver asc ")
    List<Customer> getOrderedCustomers();

    @Query(value = "select new " +
            "app.models.dtos.view.TotalSaleDto(c.name, c.sales.size, sum(p.price)) " +
            "from Customer c join c.sales s " +
            "join s.car car " +
            "join car.parts p " +
            "where c.sales.size > 0 " +
            "group by s.id " +
            "order by sum(p.price) desc , c.sales.size desc ")
    List<TotalSaleDto> getCustomersWithSales();
}
