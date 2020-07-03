package com.app.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.signup.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
