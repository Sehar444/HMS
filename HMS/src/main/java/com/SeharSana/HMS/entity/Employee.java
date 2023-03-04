package com.SeharSana.HMS.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
    private int empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_job_description")
    private String jobDescription;
    @Column(name = "emp_address")
    private String address;
    @Column(name = "emp_phone_no")
    private int phoneNo;

}
