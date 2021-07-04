package com.ds.springmvcthymeleaf_crud.repository;

import com.ds.springmvcthymeleaf_crud.bean.EmployeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeBean, Integer> {

}
