package com.springbootdemo.project1.empmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.springbootdemo.project1.empmanagementsystem.Entity.Employee;
@Repository
public interface Emprepo extends JpaRepository<Employee,Integer>{
    
}
