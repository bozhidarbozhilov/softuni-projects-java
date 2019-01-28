package app.services.interfaces;

import app.models.dtos.binding.CreatePartsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartService {
    void createPart(CreatePartsDto createPartsDto);
    void createAllParts(List<CreatePartsDto> createPartsDtos);
}
