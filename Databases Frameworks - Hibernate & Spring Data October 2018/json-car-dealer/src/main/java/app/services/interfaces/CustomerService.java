package app.services.interfaces;

import app.models.dtos.binding.CreateCustomerDto;
import app.models.dtos.view.OrderedCustomersDto;
import app.models.dtos.view.TotalSaleDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    void createCustomer(CreateCustomerDto createCustomerDto);
    void createAllCustomers(List<CreateCustomerDto> createCustomerDtos);
    List<OrderedCustomersDto> getOrderedCustomers();
    List<TotalSaleDto> getCustomersWithSales();
}
