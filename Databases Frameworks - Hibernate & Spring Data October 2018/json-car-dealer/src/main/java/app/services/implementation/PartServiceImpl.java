package app.services.implementation;

import app.models.dtos.binding.CreatePartsDto;
import app.models.entities.Part;
import app.models.entities.Supplier;
import app.repositories.PartRepository;
import app.repositories.SupplierRepository;
import app.services.interfaces.PartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository partRepository;
    private SupplierRepository supplierRepository;
    private ModelMapper mapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository,
                           SupplierRepository supplierRepository,
                           ModelMapper mapper) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.mapper = mapper;
    }


    @Override
    public void createPart(CreatePartsDto createPartsDto) {
        List<Supplier> allSuppliers = this.supplierRepository.findAll();
        Part part = mapper.map(createPartsDto, Part.class);
        part.setSupplier(allSuppliers.get(new Random().nextInt(allSuppliers.size())));
        this.partRepository.save(part);
    }

    @Override
    public void createAllParts(List<CreatePartsDto> createPartsDtos) {
        for (CreatePartsDto createPartsDto : createPartsDtos) {
            this.createPart(createPartsDto);
        }
    }
}
