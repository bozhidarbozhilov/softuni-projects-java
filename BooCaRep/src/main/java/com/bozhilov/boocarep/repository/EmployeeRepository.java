package com.bozhilov.boocarep.repository;

import com.bozhilov.boocarep.domain.entities.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByUsername(String username);
    Employee findByEmail(String email);
}
