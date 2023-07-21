package com.mudgal.ems.service;

import com.mudgal.ems.model.Employee;
import com.mudgal.ems.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee, int id) {
        Optional<Employee> byId = employeeRepo.findById(id);
        if (byId.isEmpty()) {
            System.out.println("No Data Found!!");
        }
        else {
            Employee existingEmployee = byId.get();
            existingEmployee.setTitle(employee.getTitle());
            existingEmployee.setDescription(employee.getDescription());
            employeeRepo.save(existingEmployee);
            return existingEmployee;
        }
        return null;
    }

    public Employee deleteEmployee(int id) {
        Optional<Employee> byId = employeeRepo.findById(id);
        if (byId.isEmpty()) {
            System.out.println("Id Not Found!!");
        } else {
            Employee existingEmployee = byId.get();
            employeeRepo.delete(existingEmployee);
            return existingEmployee;
        }
        return null;
    }
}
