package com.nelson.springboot2.repository;

import com.nelson.springboot2.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee>findByNameIgnoreCase(String name);

    //SELECT * FROM tbl_employees WHERE name=? AND location=? --- Equivalent SQL query converted by Spring Data JPA
    List<Employee> findByNameAndLocation(String name, String location);

    List<Employee> findByNameContaining(String name, Sort sort);

    //Using JPQL query
    @Query("FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeeByNameOrLocation(String name, String location);

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee WHERE name = :name") //JPQL query
    Integer deleteEmployeeByName(String name);
}
