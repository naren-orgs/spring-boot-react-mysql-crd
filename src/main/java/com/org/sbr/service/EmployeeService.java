package com.org.sbr.service;

import com.org.sbr.exception.EmployeeAlreadyExists;
import com.org.sbr.exception.EmployeeNotFoundException;
import com.org.sbr.model.Employee;
import com.org.sbr.repository.EmployeeRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRespository employeeRespository;

    @Override
    public Employee addEmployee(Employee employee) {
        if(employeeAlreadyExists(employee))
            throw new EmployeeAlreadyExists("Employee with email "+employee.getEmail()+" already exists");
        return employeeRespository.save(employee);
    }

    private boolean employeeAlreadyExists(Employee employee) {
        return employeeRespository.findByEmail(employee.getEmail()).isPresent();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        return employeeRespository.findById(id).map(emp->{
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setEmail(employee.getEmail());
            emp.setDepartment(employee.getDepartment());
            return employeeRespository.save(emp);
        }).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found with id "+id));
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRespository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee Not Found with id "+id));
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRespository.existsById(id)){
            throw new EmployeeNotFoundException("Employee Not Found with id "+id);
        }
        employeeRespository.deleteById(id);

    }
}
