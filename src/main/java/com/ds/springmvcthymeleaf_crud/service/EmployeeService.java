package com.ds.springmvcthymeleaf_crud.service;

import com.ds.springmvcthymeleaf_crud.bean.EmployeeBean;
import com.ds.springmvcthymeleaf_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public List<EmployeeBean> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void addEmployee(EmployeeBean employeeBean) {

        try {
            employeeRepository.save(employeeBean);
        } catch (Exception ignored) {
        }
    }

    @Transactional
    public EmployeeBean findByEmployeeId(int id) {
        Optional<EmployeeBean> optional = employeeRepository.findById(id);
        return optional.orElse(null);
    }

    @Transactional
    public void deleteEmployeeById(int id) {
         employeeRepository.deleteById(id);
    }
}
