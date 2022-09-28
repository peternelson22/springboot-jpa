package com.nelson.springboot2.service;

import com.nelson.springboot2.entity.Employee;
import com.nelson.springboot2.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");
        return employeeRepository.findAll(pages).getContent();
    }


    @Override
    public Employee saveEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeeLike(String name) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return employeeRepository.findByNameContaining(name, sort);
    }

    @Override
    public Integer deleteEmployeeByName(String name) {
        return employeeRepository.deleteEmployeeByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
        return employeeRepository.getEmployeeByNameOrLocation(name, location);
    }
}
