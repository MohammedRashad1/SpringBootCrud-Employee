package com.ibs.springboot.CrudOperation.Service;

import com.ibs.springboot.CrudOperation.exception.ResourceNotFoundException;
import com.ibs.springboot.CrudOperation.model.Employee;
import com.ibs.springboot.CrudOperation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //For saving or creating or adding single employee
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //For saving or creating or adding multiple employees
    @Override
    public List<Employee> createEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    //For getting all employees from database
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    //For getting specific employee based on id from database
    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + id));
    }

    //For updating employee in database
    @Override
    public Employee updateProduct(long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    //For deleting an employee in database
    @Override
    public void deleteEmployee(long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + id));
        employeeRepository.delete(existingEmployee);
    }
}
