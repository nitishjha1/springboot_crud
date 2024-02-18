package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public List<Employee> findByName(String name);
	public List<Employee> findByNameAndRole(String name,String role);
	public List<Employee> findByNameOrRole(String name,String role);
	public List<Employee> findByNameContains(String prefix);
	@Query("Select emp from Employee emp")
	public List<Employee> getAllEmployee();
	@Query("select emp from Employee emp where emp.role=:r")
	public List<Employee> findByRole(@Param("r") String role);
	@Query(value = "select * from Employee",nativeQuery = true)
	public List<Employee> getEmps();

}
