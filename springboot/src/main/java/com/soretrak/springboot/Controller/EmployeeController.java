package com.soretrak.springboot.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soretrak.springboot.dao.EmployeeDAO;
import com.soretrak.springboot.model.Employee;

@RestController
@RequestMapping("/soretrak")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	//save an employee
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return (employeeDAO.save(emp));
	}
	
	//get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	
	//get employee by empId
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional <Employee>> getEmployeeById(@PathVariable(value="id") Long empId){
		Optional<Employee>  emp=employeeDAO.findOne(empId);
		
		if (emp== null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	//update employee by empId
	@PutMapping("/employees/{id}")
	public ResponseEntity<Optional <Employee>> updateEmployee(@PathVariable(value="id") Long empId , @Valid @RequestBody Employee empDetails){
		Optional<Employee> emp=employeeDAO.findOne(empId);
		if (emp== null) {
			return ResponseEntity.notFound().build();
		}
		
		
		/*emp.(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		
		Employee updateEmployee =employeeDAO.save(emp) ;
		
		return  ResponseEntity.ok().body(updateEmployee);*/
		return  ResponseEntity.ok().body(emp);
		
	}
	
	//delete an employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empId){
		
		Employee emp=employeeDAO.findOne(empId);
		if (emp== null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
	
	
	
}
