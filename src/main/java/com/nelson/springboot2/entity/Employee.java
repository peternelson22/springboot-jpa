package com.nelson.springboot2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private Long age = 0L;

    private String location;

    @Email
    private String email;

    @NotBlank
    private String department;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
