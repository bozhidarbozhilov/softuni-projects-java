package thymeleafcontrollers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thymeleafcontrollers.domain.entities.Capital;

@Repository
public interface CapitalRepository extends JpaRepository<Capital, Long> {

    Capital findByName(String name);
}
