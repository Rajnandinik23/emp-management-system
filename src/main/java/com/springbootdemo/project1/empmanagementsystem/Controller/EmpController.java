package com.springbootdemo.project1.empmanagementsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootdemo.project1.empmanagementsystem.Entity.Employee;
import com.springbootdemo.project1.empmanagementsystem.Service.Empservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
   @Autowired
   Empservice empservice;
    @GetMapping("/")
    public String home(Model m)
    {
      List<Employee> emp=empservice.getAllEmp();
      m.addAttribute("emp",emp);
       return "index";
    }
    @GetMapping("/addemp")
    public String getEmpForm()
    {
       return "add_Emp";
    }
    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e,HttpSession session)
    {
      session.setAttribute("msg", "Employee Added Sucessfully");
      empservice.addEmp(e);
      System.out.println(e);
     
      return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m)
    {
      Employee e=empservice.getEmpByID(id);
      m.addAttribute("emp", e);
       return "edit";
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e,HttpSession session)
    {
       empservice.addEmp(e);
       session.setAttribute("msg", "Employee Data Update Successfully");
       return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id,HttpSession session)
    {
      session.setAttribute("msg", "Employee Deleted Sucessfully");
      empservice.deleteByEmp(id);
       return "redirect:/";
    }
}
