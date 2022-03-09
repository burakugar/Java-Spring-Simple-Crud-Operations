package com.example.demo1.controller;


import com.example.demo1.entity.Employee;
import com.example.demo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// disardaki clientla iletisim kuruyoruz
// streotype -> sınıfın ne işlem yaptığını ifade eder

@RestController // rest api oldugunu ifade eder
// @Rest Controller = @Controller + @ ResponseBody
@RequestMapping(value = "/api/employees")
//Application Context içinde tutuluyor
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
        return;
    }
    // employee rest API
    @PostMapping() // post http requestleri handle ediyor
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){ // Request body request bodysini java objesine donusturur
        return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
    }
    // tüm calisanları alma icin get methodu
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    // build getEmployee by id rest api
    // localhost:8080/api/employees/id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeebyId(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id,@RequestBody Employee employee ){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee is deleted successfully",HttpStatus.OK);
    }
}
