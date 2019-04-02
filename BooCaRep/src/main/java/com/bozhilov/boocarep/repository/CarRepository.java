package com.bozhilov.boocarep.repository;

import com.bozhilov.boocarep.domain.entities.tech.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
