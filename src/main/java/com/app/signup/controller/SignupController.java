package com.app.signup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.signup.model.Employee;
import com.app.signup.model.User;
import com.app.signup.service.SignupService;

@RestController
public class SignupController {
	
	@Autowired
	private SignupService service;
	
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		if(tempEmailId != null && !"".equals(tempEmailId)){
			User userobj = service.fetchUserByEmail(tempEmailId);
			if(userobj != null) {
				throw new Exception("User with "+tempEmailId+ " is already exist.");
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		String tempPass = user.getPassword();
		
		User userobj = null;
		if(tempEmailId != null && tempPass != null) {
			 userobj = service.fetchUserByEmailAndPassword(tempEmailId, tempPass);
		}
		if(userobj == null) {
			throw new Exception("Invalid Credentials.");
		}
		return userobj;
	}
	
	@GetMapping("/getemployeelist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> fetchEmployeeList(){
		List<Employee> employees = new ArrayList<Employee>();
		employees = service.fetchEmployeeList();
		return employees;
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee AddEmployee(@RequestBody Employee employee) {
		return service.saveEmployeeToDB(employee);
	}
	
	@GetMapping("/update/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee fetchEmployeeById(@PathVariable int id){
		return service.fetchEmployeeById(id).get();
	}
	
	@DeleteMapping(value ="/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteEmployeeById(@PathVariable int id){
		service.deleteEmployeeById(id) ;
	}

}
