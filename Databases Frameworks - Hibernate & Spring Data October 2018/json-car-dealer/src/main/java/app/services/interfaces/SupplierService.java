package app.services.interfaces;

import app.models.dtos.binding.CreateSupplierDto;
import app.models.dtos.view.LocalSupplierDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    void createSupplier(CreateSupplierDto supplier);
    void createAllSuppliers(List<CreateSupplierDto> suppliers);
    List<LocalSupplierDto> getLocalSuppliers(boolean isImporter);
}
