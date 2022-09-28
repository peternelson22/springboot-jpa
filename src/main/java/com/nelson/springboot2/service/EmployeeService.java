package com.nelson.springboot2.service;

import com.nelson.springboot2.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployees(Employee employee);

    Optional<Employee> getEmployeeById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeeByNameAndLocation(String name, String location);

    List<Employee> getEmployeeLike(String name);

    List<Employee> getEmployeeByNameOrLocation(String name, String Location);

    Integer deleteEmployeeByName(String name);
}
