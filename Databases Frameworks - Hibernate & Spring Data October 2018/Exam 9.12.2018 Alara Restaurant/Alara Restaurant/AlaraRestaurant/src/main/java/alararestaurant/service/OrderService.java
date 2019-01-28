package alararestaurant.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public interface OrderService {

    Boolean ordersAreImported();

    String readOrdersXmlFile() throws IOException;

    String importOrders() throws JAXBException;

    String exportOrdersFinishedByTheBurgerFlippers();
}
