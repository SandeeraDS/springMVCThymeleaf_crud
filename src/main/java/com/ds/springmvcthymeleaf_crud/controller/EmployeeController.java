package com.ds.springmvcthymeleaf_crud.controller;

import com.ds.springmvcthymeleaf_crud.bean.EmployeeBean;
import com.ds.springmvcthymeleaf_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployee(Model model) {
        EmployeeBean employeeBean = new EmployeeBean();
        model.addAttribute("employee", employeeBean);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") EmployeeBean employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(Model model, @PathVariable("id") int id){
        model.addAttribute("employee",employeeService.findByEmployeeId(id));
        return "updateEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(Model model, @PathVariable("id") int id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
