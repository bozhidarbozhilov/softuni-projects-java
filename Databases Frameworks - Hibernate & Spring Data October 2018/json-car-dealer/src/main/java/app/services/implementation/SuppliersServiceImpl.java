package app.services.implementation;

import app.models.dtos.binding.CreateSupplierDto;
import app.models.dtos.view.LocalSupplierDto;
import app.models.entities.Supplier;
import app.repositories.SupplierRepository;
import app.services.interfaces.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuppliersServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    private ModelMapper mapper;

    @Autowired
    public SuppliersServiceImpl(SupplierRepository supplierRepository, ModelMapper mapper) {
        this.supplierRepository = supplierRepository;
        this.mapper = mapper;
    }

    @Override
    public void createSupplier(CreateSupplierDto supplier) {
        Supplier supplier1 = mapper.map(supplier, Supplier.class);
        this.supplierRepository.save(supplier1);
    }

    @Override
    public void createAllSuppliers(List<CreateSupplierDto> suppliers) {
        for (CreateSupplierDto supplier : suppliers) {
            this.createSupplier(supplier);
        }
    }

    @Override
    public List<LocalSupplierDto> getLocalSuppliers(boolean isImporter) {
        List<Supplier> list = this.supplierRepository.findAllByImporterIs(isImporter);
        return list
                .stream().map(supplier -> mapper.map(supplier,LocalSupplierDto.class))
                .collect(Collectors.toList());
    }
}
