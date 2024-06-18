package com.csi.controller;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Employee> signup(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImpl.signup(employee), HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findall(){
        return ResponseEntity.ok(employeeServiceImpl.findall());
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findbyid(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.findbyid(empId));
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }
}
