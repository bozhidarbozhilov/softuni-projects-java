package alararestaurant.service;

import alararestaurant.domain.dtos.ImportItemDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ItemServiceImpl implements ItemService {
    private static final String ERROR_MESSAGE = "Invalid data format.";

    private static final String ITEMS_JSON_FILE_PATH = "C:\\Users\\Bozhidar Bozhilov\\Desktop" +
            "\\Alara Restaurant_Skeleton\\AlaraRestaurant" +
            "\\src\\main\\resources\\files\\items.json";

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository,
                           CategoryRepository categoryRepository,
                           FileUtil fileUtil, ValidationUtil validator, ModelMapper mapper, Gson gson) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
        this.validator = validator;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public Boolean itemsAreImported() {
        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() throws IOException {
        return this.fileUtil.readFile(ITEMS_JSON_FILE_PATH);
    }

    @Override
    public String importItems(String items) {
        StringBuilder importItem = new StringBuilder();
        ImportItemDto[] importItemDtos = gson.fromJson(items, ImportItemDto[].class);

        for (ImportItemDto importItemDto : importItemDtos) {
            if(!validator.isValid(importItemDto) || !validator.isValid(importItemDto.getCategoryName())){
                 importItem.append(ERROR_MESSAGE).append(System.lineSeparator());
                continue;
            }
            Item itemEntity = this.itemRepository.findByName(importItemDto.getName()).orElse(null);
            if(itemEntity != null){
                importItem.append(ERROR_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Category category = this.categoryRepository
                    .findByName(importItemDto.getCategoryName()).orElse(null);
            if(category == null){
                category = new Category(importItemDto.getCategoryName());
                this.categoryRepository.save(category);
            }
            itemEntity = mapper.map(importItemDto, Item.class);
            itemEntity.setCategory(category);

            this.itemRepository.saveAndFlush(itemEntity);

            importItem.append(String.format("Record %s successfully imported.", itemEntity.getName()))
                    .append(System.lineSeparator());
        }
        return importItem.toString();
    }
}
