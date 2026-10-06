package com.nit.repositry;

import org.springframework.data.repository.CrudRepository;

import com.nit.beans.Employee;

public interface Crudrepositry extends CrudRepository<Employee, Integer> {

}
