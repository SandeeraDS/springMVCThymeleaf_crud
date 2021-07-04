package com.ds.springmvcthymeleaf_crud;

import com.ds.springmvcthymeleaf_crud.bean.EmployeeBean;
import com.ds.springmvcthymeleaf_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringMvcThymeleafCrudApplication {


    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void initEmployee() {
        List<EmployeeBean> users = Stream.of(
                new EmployeeBean(0, "employee1", "employee1@gmail.com"),
                new EmployeeBean(0, "employee2", "employee2@gmail.com"),
                new EmployeeBean(0, "employee3", "employee3@gmail.com"),
                new EmployeeBean(0, "employee4", "employee4@gmail.com"),
                new EmployeeBean(0, "employee5", "employee5@gmail.com")
        ).collect(Collectors.toList());
        employeeRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThymeleafCrudApplication.class, args);
    }

}
