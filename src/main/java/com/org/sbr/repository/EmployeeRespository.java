package com.org.sbr.repository;

import com.org.sbr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
}
