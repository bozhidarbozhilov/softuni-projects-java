package app.controllers;

import app.models.dtos.binding.CreateCarDto;
import app.models.dtos.binding.CreateCustomerDto;
import app.models.dtos.binding.CreatePartsDto;
import app.models.dtos.binding.CreateSupplierDto;
import app.models.dtos.view.FindByMakerCarDto;
import app.models.dtos.view.OrderedCustomersDto;
import app.services.interfaces.*;
import app.utils.FileUtils;
import app.utils.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class AppController implements CommandLineRunner {
    private FileUtils fileUtils;
    private Parser jsonParser;
    private SupplierService supplierService;
    private CarService carService;
    private PartService partService;
    private SaleService saleService;
    private CustomerService customerService;

    @Autowired
    public AppController(FileUtils fileUtils, Parser  jsonParser,
                SupplierService supplierService,
                CarService carService,
                PartService partService,
                SaleService saleService,
                CustomerService customerService) {
        this.fileUtils = fileUtils;
        this.jsonParser = jsonParser;
        this.supplierService = supplierService;
        this.carService =carService;
        this.partService =partService;
        this.saleService= saleService;
        this.customerService= customerService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedSuppliers();
        //seedParts();
        //seedCars();
        //seedCustomers();
        //seedSales();

/*        List<OrderedCustomersDto> orderedCustomersDtos = this.customerService.getOrderedCustomers();
        String orderedCustomersToJson = this.jsonParser.exportToFile(orderedCustomersDtos);

        File orderedCustomersFile = createFileToWrite("ordered-customers.json");
        this.fileUtils.writeToFile(orderedCustomersToJson, orderedCustomersFile);*/

/*        String findByMaker = this.jsonParser.exportToFile(this.carService.findCarsByMaker("Toyota"));
        File findByMakerFile = createFileToWrite("toyota-cars.json");
        this.fileUtils.writeToFile(findByMaker, findByMakerFile);*/

/*        String localSuppliersContent = this.jsonParser.exportToFile(this.supplierService
                .getLocalSuppliers(false));
        File localSuppliersFile = createFileToWrite("local-suppliers.json");
        this.fileUtils.writeToFile(localSuppliersContent, localSuppliersFile);*/

/*        String carsPartsContent = this.jsonParser.exportToFile(this.carService
        .getCarsAndTheirParts());
        File carsPartsFile = createFileToWrite("cars-and-parts.json");
        this.fileUtils.writeToFile(carsPartsContent,carsPartsFile);*/
/*        String customerSales = this.jsonParser.exportToFile(this.customerService.getCustomersWithSales());
        File customerSalesFile = createFileToWrite("customers-total-sales.json");
        this.fileUtils.writeToFile(customerSales, customerSalesFile);*/

        String discountSalesContent = this.jsonParser.exportToFile(this.saleService.getSalesWithCalcDiscount());
        File discountSalesFile = createFileToWrite("sales-discounts.json");
        this.fileUtils.writeToFile(discountSalesContent, discountSalesFile);
    }

    private File createFileToWrite(String fileName) throws IOException {
        String pathName = "F:\\SoftUni Main\\Databases\\Databases Advanced - Hibernate" +
                "\\10. JSON Processing\\Exercises" +
                "\\json-car-dealer\\src\\main\\resources\\files\\output\\"+fileName;
        return new File(pathName);
    }

    private void seedSales() {
        int randNumberOfSales = 0;
        while(randNumberOfSales<7){
            randNumberOfSales = new Random().nextInt(15);
        }
        for (int i = 0; i < randNumberOfSales; i++) {
            this.saleService.createSale();
        }
    }

    private void seedCustomers() throws FileNotFoundException {
        String customerFile = fileUtils.readFromFile("/files/customers.json");
        List<CreateCustomerDto> createCustomerDtos =
                Arrays.asList(jsonParser.importFromFile(CreateCustomerDto[].class, customerFile));
        this.customerService.createAllCustomers(createCustomerDtos);
    }

    private void seedParts() throws FileNotFoundException {
        String partFile = fileUtils.readFromFile("/files/parts.json");
        List<CreatePartsDto> createPartDtos =
                Arrays.asList(jsonParser.importFromFile(CreatePartsDto[].class, partFile));
        this.partService.createAllParts(createPartDtos);
    }

    private void seedSuppliers() throws FileNotFoundException {
        String supplierFile = fileUtils.readFromFile("/files/suppliers.json");
        List<CreateSupplierDto> createSupplierDtos =
                Arrays.asList(jsonParser.importFromFile(CreateSupplierDto[].class, supplierFile));
        this.supplierService.createAllSuppliers(createSupplierDtos);
    }

    private void seedCars() throws FileNotFoundException {
        String carFile = fileUtils.readFromFile("/files/cars.json");
        List<CreateCarDto> CreateCarDtos =
                Arrays.asList(jsonParser.importFromFile(CreateCarDto[].class, carFile));
        this.carService.createAllCars(CreateCarDtos);
    }
}
