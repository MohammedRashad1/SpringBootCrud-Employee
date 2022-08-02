package com.ibs.springboot.CrudOperation.Service;

import com.ibs.springboot.CrudOperation.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);

    public  List<Employee> createEmployees(List<Employee> employees);

    public List<Employee> getAllEmployee();

    public Employee getEmployee(long id);

    public Employee updateProduct(long id, Employee employee);

    public void deleteEmployee(long id);
}
