package app.services.implementation;

import app.models.dtos.binding.CreateCustomerDto;
import app.models.dtos.view.OrderedCustomersDto;
import app.models.dtos.view.TotalSaleDto;
import app.models.entities.Customer;
import app.repositories.CustomerRepository;
import app.services.interfaces.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public void createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = mapper.map(createCustomerDto, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public void createAllCustomers(List<CreateCustomerDto> createCustomerDtos) {
        for (CreateCustomerDto createCustomerDto : createCustomerDtos) {
            this.createCustomer(createCustomerDto);
        }
    }

    @Override
    public List<OrderedCustomersDto> getOrderedCustomers() {
        List<Customer> list = this.customerRepository.getOrderedCustomers();
        return list.stream()
                .map(c->mapper.map(c, OrderedCustomersDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TotalSaleDto> getCustomersWithSales() {
        return this.customerRepository.getCustomersWithSales();
    }
}
