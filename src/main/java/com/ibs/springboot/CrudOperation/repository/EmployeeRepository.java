package com.ibs.springboot.CrudOperation.repository;

import com.ibs.springboot.CrudOperation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
