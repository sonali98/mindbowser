package com.app.signup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.signup.model.Employee;
import com.app.signup.model.User;
import com.app.signup.repository.EmployeeRepository;
import com.app.signup.repository.SignupRepository;


@Service
public class SignupService {
	
	@Autowired
	private SignupRepository repo;
	
	@Autowired
	private EmployeeRepository repos;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		return repo.findByEmailAndPassword(email,password);
	}
	
	public List<Employee> fetchEmployeeList(){
		return repos.findAll();
	}
	
	public Employee saveEmployeeToDB(Employee employee) {
		return repos.save(employee);
	}

	public Optional<Employee> fetchEmployeeById(int id) {
		return repos.findById(id);
	}
	
	public void deleteEmployeeById(int id) {

			 repos.deleteById(id);

	}
}
