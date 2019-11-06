package com.soretrak.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soretrak.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
