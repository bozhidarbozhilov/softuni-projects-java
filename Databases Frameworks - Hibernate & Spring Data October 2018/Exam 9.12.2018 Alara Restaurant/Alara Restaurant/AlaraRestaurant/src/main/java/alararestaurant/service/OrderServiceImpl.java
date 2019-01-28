package alararestaurant.service;

import alararestaurant.domain.OrderType;
import alararestaurant.domain.dtos.OrderImportDto;
import alararestaurant.domain.dtos.OrderImportRootDto;
import alararestaurant.domain.dtos.XmlItemImportDto;
import alararestaurant.domain.entities.*;
import alararestaurant.repository.*;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import alararestaurant.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    private static final String ERROR_MESSAGE = "Invalid data format.";

    private static final String ORDERS_XML_FILE_PATH = "C:\\Users\\Bozhidar Bozhilov\\Desktop" +
            "\\Alara Restaurant_Skeleton\\AlaraRestaurant" +
            "\\src\\main\\resources\\files\\orders.xml";

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final EmployeeRepository employeeRepository;
    private final ItemRepository itemRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemRepository orderItemRepository,
                            EmployeeRepository employeeRepository, ItemRepository itemRepository, FileUtil fileUtil,
                            XmlParser xmlParser,
                            ModelMapper mapper, ValidationUtil validator) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
        return this.fileUtil.readFile(ORDERS_XML_FILE_PATH);
    }

    @Override
    public String importOrders() throws JAXBException {
        StringBuilder importOrders = new StringBuilder();
        OrderImportRootDto orderImportRootDto = this.xmlParser
                .parseXml(OrderImportRootDto.class, ORDERS_XML_FILE_PATH);

        for (OrderImportDto order : orderImportRootDto.getOrders()) {
            if (!validator.isValid(order)) {
                importOrders.append(ERROR_MESSAGE).append(System.lineSeparator());
                continue;
            }
            Employee employeeOrder = this.employeeRepository.findByName(order.getEmployee()).orElse(null);
            if (employeeOrder == null) {
                importOrders.append(ERROR_MESSAGE).append(System.lineSeparator());
                continue;
            }
            Set<OrderItem> orderItems = new HashSet<>();

            Order orderEntity = mapper.map(order, Order.class);
            orderEntity.setCustomer(order.getCustomer());
            orderEntity.setEmployee(employeeOrder);
            orderEntity.setType(OrderType.valueOf(order.getType().trim()));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            orderEntity.setDateTime(LocalDateTime.parse(order.getDateTime(), dtf));
            orderEntity.setOrderItems(null);
            boolean isNonExistingItem = checkForNonExistingItems(order.getItems().items);

            if (isNonExistingItem) {
                importOrders.append(ERROR_MESSAGE).append(System.lineSeparator());
                continue;
            }


            Order savedOrder = this.orderRepository.saveAndFlush(orderEntity);

            for (XmlItemImportDto orderItemDto : order.getItems().items) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(savedOrder);
                orderItem.setQuantity(orderItemDto.getQuantity());

                orderItem.setItem(this.itemRepository.findByName(orderItemDto.getName()).orElse(null));
                this.orderItemRepository.saveAndFlush(orderItem);
            }

            importOrders.append(String.format("Order for %s on %s added",
                    savedOrder.getCustomer(), savedOrder.getDateTime())).append(System.lineSeparator());
        }

        return importOrders.toString();
    }

    private boolean checkForNonExistingItems(XmlItemImportDto[] items) {
        for (XmlItemImportDto item : items) {
            Item searchItem = this.itemRepository.findByName(item.getName()).orElse(null);
            if (searchItem == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        StringBuilder exportOrders = new StringBuilder();
        List<Order> ordersFromBurgerFlippers = this.orderRepository.ordersFinishedByBurgerFlippers();

        for (Order orderFromBurgerFlipper : ordersFromBurgerFlippers) {
            exportOrders.append(String.format("Name: %s", orderFromBurgerFlipper.getEmployee().getName()))
                    .append(System.lineSeparator())
                    .append("Orders: ").append(System.lineSeparator());
            orderFromBurgerFlipper.getEmployee().getOrders()
                    .forEach(order -> {
                        exportOrders.append(String.format("Customer: %s", order.getCustomer()))
                                    .append(System.lineSeparator()).append("Items: ")
                                    .append(System.lineSeparator());
                        order.getOrderItems().forEach(item->{
                            exportOrders.append(String.format("Name: %s", item.getItem().getName()))
                                    .append(System.lineSeparator())
                                    .append(String.format("Price: %.2f", item.getItem().getPrice()))
                                    .append(System.lineSeparator())
                                    .append(String.format("Quantity: %d", item.getQuantity()))
                                    .append(System.lineSeparator());
                        });
                    });
        }

        return exportOrders.toString();
    }
}
