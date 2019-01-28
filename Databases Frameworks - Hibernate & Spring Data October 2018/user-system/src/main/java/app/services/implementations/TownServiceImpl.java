package app.services.implementations;

import app.models.Town;
import app.repositories.TownRepository;
import app.services.api.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {
    private TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void saveTown(Town town) {

    }

    @Override
    public Town getTownById(Long id) {
        return null;
    }
}
