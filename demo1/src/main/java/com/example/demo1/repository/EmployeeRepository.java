package com.example.demo1.repository;
import com.example.demo1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// crud operationları için repository olusturduk
// jpa repository iki parametre istiyor
// employee ve primary keyi veriyoruz(Long)
// jpa repository, @Repository annotationu içerdiğinden bizim @Repository yazmamıza gerek yok
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
// hibernate özelliklerini kullandırıyor
    // farklı bir interfacei extend ediceksen interface kullan
}