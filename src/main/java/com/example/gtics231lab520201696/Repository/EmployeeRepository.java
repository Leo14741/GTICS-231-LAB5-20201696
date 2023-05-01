package com.example.gtics231lab520201696.Repository;

import com.example.gtics231lab520201696.Entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Override
    void deleteById(Integer integer);
}