package com.example.demo1.service;

import com.example.demo1.entity.Employee;
import com.example.demo1.exception.ResourceNotFoundException;
import com.example.demo1.repository.EmployeeRepository;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
// autowired kullanmaya gerek yok cunku spring, tek constructorlar icin autowired olusturuyor


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeebyId(long id){
       /* Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new ResourceNotFoundException("Employee","Id","Id ");
        } */
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
    }
    public Employee updateEmployee(Employee employee, long id){
        // id numarasına sahip employee databasede mi degil mi
        Employee existingEmployee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id) );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
    public void deleteEmployee(long id){
        Employee existingEmployee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id) );
        employeeRepository.deleteById(id);
    }

}
