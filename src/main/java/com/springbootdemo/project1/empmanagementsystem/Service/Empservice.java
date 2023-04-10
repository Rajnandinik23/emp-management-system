package com.springbootdemo.project1.empmanagementsystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.project1.empmanagementsystem.Entity.Employee;
import com.springbootdemo.project1.empmanagementsystem.Repository.Emprepo;

import jakarta.persistence.IdClass;
@Service
public class Empservice {
    @Autowired
    private Emprepo emprepo;
    public void addEmp(Employee e)
    {
        emprepo.save(e);
    }
    public List<Employee> getAllEmp()
    {
       return emprepo.findAll();
    }
    public Employee getEmpByID(int id)
    {
       Optional<Employee> e= emprepo.findById(id);
       if(e.isPresent())
       {
         return e.get();
       }
       return null;
    }
    public void deleteByEmp(int id)
    {
         emprepo.deleteById(id);
    }
}

