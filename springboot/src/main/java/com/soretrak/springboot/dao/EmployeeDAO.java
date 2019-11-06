package com.soretrak.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soretrak.springboot.Repository.EmployeeRepository;
import com.soretrak.springboot.model.Employee;





@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
    //save epmloyee
	public Employee save(Employee emp) {
		return (employeeRepository.save(emp));
	}
	
	//search all employees
	public List<Employee> findAll(){
		return (employeeRepository.findAll());
	}
	
	//get an employee by id
	public  Optional<Employee> findOne(Long empId) {
		return (employeeRepository.findById(empId));
	}
	
	//delete an employee
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	
	
}
