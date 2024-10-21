package com.org.sbr.service;

import com.org.sbr.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee,Long id);

    List<Employee> getEmployees();

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);

}
