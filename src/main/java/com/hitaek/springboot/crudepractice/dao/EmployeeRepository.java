package com.hitaek.springboot.crudepractice.dao;


import com.hitaek.springboot.crudepractice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    public List<Employee> findAllByOrderByLastNameAsc();



}











