package alararestaurant.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ItemService {

    Boolean itemsAreImported();

    String readItemsJsonFile() throws IOException;

    String importItems(String items);
}
