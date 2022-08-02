package com.ibs.springboot.CrudOperation.controller;

import com.ibs.springboot.CrudOperation.Service.EmployeeService;
import com.ibs.springboot.CrudOperation.Service.EmployeeServiceImp;
import com.ibs.springboot.CrudOperation.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/employees")
    public List<Employee> addEmployees( @RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateProduct(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.updateProduct(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "Employee " + id + " Deleted Successfully";
    }

}
