package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.beans.Employee;
import com.nit.repositry.Crudrepositry;
@Component
public class EmpService implements EmpInterface {
	@Autowired
 private Crudrepositry crudrepositry;
	@Override
	public String addEmployee(Employee emp) {
		Employee emp1 =crudrepositry.save(emp);
		return emp1+"Employee is Saved";
	}
	@Override
	public Iterable<Employee> addMultipleEmp(List<Employee> list) {
		return crudrepositry.saveAll(list);
	}
	@Override
	public Object viewEmployee(int id) {
		if(crudrepositry.findById(id).isPresent()) {
			Optional<Employee> e= crudrepositry.findById(id);
			Employee emp=e.get();
			return emp;
		}else {
		return "Not found";}
	}
	@Override
	public Iterable<Employee> viewAllEmp() {
		return crudrepositry.findAll();
	}
	@Override
	public String cheakEmp(int id) {
		if(crudrepositry.findById(id).isPresent()) {
			return "Emp details Available";
		}else {
		return "Emp Not found";}
	}
	@Override
	public long countEmp() {
		long i=crudrepositry.count();
		return i;
	}
	@Override
	public Employee updateEmp(Employee emp) {
		return crudrepositry.save(emp);
	}
	@Override
	public String deletebyId(int id) {
		if(crudrepositry.findById(id).isPresent()) {
			crudrepositry.deleteById(id);
			return "Emp is Deleted";
		}else {
		return "not  Founded";}
	}
	@Override
	public String deleteAll() {
		crudrepositry.deleteAll();
		return "Deleted All records";
	}
	@Override
	public String deleteAllIds(List<Integer> ids) {
		Iterable<Employee> allById = crudrepositry.findAllById(ids);
			if(!allById.iterator().hasNext()) {
				return " emp not Found";
			}
		crudrepositry.deleteAllById(ids);
		return "Employee all deleted ";
	}

}
