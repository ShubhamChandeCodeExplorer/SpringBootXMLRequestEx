package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeREpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeREpo employeeREpoImpl;

    public Employee signup(Employee employee){
        return employeeREpoImpl.save(employee);
    }

    public List<Employee> findall(){
        return employeeREpoImpl.findAll();
    }

    public Optional<Employee> findbyid(int empId){
        return employeeREpoImpl.findById(empId);
    }

    public boolean signin(String empEmailId,String empPassword){
        boolean flag=false;
        for(Employee employee:findall()){
            if(employee.getEmpEmailId.equals(empEmailId) && employee.getEmpPassword.equals(empPassword)){
                flag=true;
            }
        }
        return flag;
    }
}
