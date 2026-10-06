package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.beans.Employee;

public interface EmpInterface  {
   public String addEmployee(Employee emp);
   public Iterable<Employee> addMultipleEmp(List<Employee> emp);
   public Object viewEmployee(int id);
   public Iterable<Employee> viewAllEmp();
   public String cheakEmp(int id);
   public long countEmp();
   public Employee updateEmp(Employee emp);
   public String deletebyId(int id);
   public String deleteAll();
   public  String deleteAllIds(List<Integer> ids);
   
}
