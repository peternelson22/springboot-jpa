package com.nelson.springboot2.controller;

import com.nelson.springboot2.entity.Employee;
import com.nelson.springboot2.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class EmployeeController {

    private EmployeeService  employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployees(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/findByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/findByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<>(employeeService.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/findByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<>(employeeService.getEmployeeLike(name), HttpStatus.OK);
    }

    @GetMapping("/employees/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location){
        return new ResponseEntity<>(employeeService.getEmployeeByNameOrLocation(name,location), HttpStatus.OK);
    }

    @DeleteMapping("/employees/delete/{name}")
    public ResponseEntity<Integer> deleteEmployeeByName(@PathVariable String name){
        return new ResponseEntity<>(employeeService.deleteEmployeeByName(name), HttpStatus.NO_CONTENT);
    }

}
