package app.services.api;

import app.models.Town;
import org.springframework.stereotype.Service;

@Service
public interface TownService {
    void saveTown(Town town);
    Town getTownById(Long id);
}
