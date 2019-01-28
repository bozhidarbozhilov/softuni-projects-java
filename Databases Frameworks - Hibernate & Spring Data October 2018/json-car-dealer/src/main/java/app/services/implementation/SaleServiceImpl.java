package app.services.implementation;

import app.models.dtos.binding.CreateCarDto;
import app.models.dtos.view.SalesDiscountDto;
import app.models.entities.Car;
import app.models.entities.Customer;
import app.models.entities.Part;
import app.models.entities.Sale;
import app.repositories.CarRepository;
import app.repositories.CustomerRepository;
import app.repositories.SaleRepository;
import app.services.interfaces.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {
    private SaleRepository saleRepository;
    private CarRepository carRepository;
    private CustomerRepository customerRepository;
    private ModelMapper mapper;

    public SaleServiceImpl(SaleRepository saleRepository,
                           CarRepository carRepository,
                           CustomerRepository customerRepository,
                           ModelMapper mapper) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public void createSale() {
        int discount = getRandomDiscount();
        List<Car> cars = this.carRepository.findAll();
        List<Customer> customers = this.customerRepository.findAll();
        Sale sale = new Sale();
        sale.setDiscount(discount);
        sale.setCar(cars.get(new Random().nextInt(cars.size())));
        sale.setCustomer(customers.get(new Random().nextInt(customers.size())));
        this.saleRepository.save(sale);
    }

    @Override
    public List<SalesDiscountDto> getSalesWithCalcDiscount() {
        List<Sale> sales = this.saleRepository.findAll();
        List<SalesDiscountDto> salesDiscountDtos =
        sales.stream().map(sale -> {
            SalesDiscountDto discountDto = new SalesDiscountDto();
            discountDto.setCar(mapper.map(sale.getCar(), CreateCarDto.class));
            discountDto.setCustomerName(sale.getCustomer().getName());
            discountDto.setPrice(sale.getCar().getParts().stream().
                    map(Part::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
            discountDto.setDiscount(sale.getDiscount());
            discountDto.setPriceWithDiscount(discountDto.getPrice().subtract(discountDto.getPrice()
                    .multiply(new BigDecimal(discountDto.getDiscount()/100.0))));
            return discountDto;
        }).collect(Collectors.toList());

        return salesDiscountDtos;
    }

    //0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).
    private int getRandomDiscount() {
        List<Integer> defaultDiscounts = new ArrayList<>(){{
            add(0);add(5);add(10);add(15);add(20);add(30);add(40);add(50);
        }};
        return defaultDiscounts.get(new Random().nextInt(defaultDiscounts.size()));
    }
}
