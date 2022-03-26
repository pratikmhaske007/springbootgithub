package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    @Override
    public Employee saveData(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    @Override
    public List<Employee> saveBulkOfData(List<Employee> employees) {
        return employeeRepositoryImpl.saveAll(employees);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeRepositoryImpl.findAll();
    }

    @Override
    public Optional<Employee> getDataById(int employeeId) {
        return employeeRepositoryImpl.findById(employeeId);
    }

    @Override
    public Employee getDataByEmployeeName(String employeeName) {
        return employeeRepositoryImpl.findByEmployeeName(employeeName);
    }

    @Override
    public Employee getDataByEmployeeDOB(String employeeDOB) {
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        Date dob= null;
        try {
            dob=sdf.parse(employeeDOB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employeeRepositoryImpl.findByEmployeeDOB(dob);
    }

    @Override
    public Employee updateData(int employeeId, Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    @Override
    public List<Employee> getFilteredRecords(double employeeSalary) {
        return employeeRepositoryImpl.findAll().stream().filter(emp->emp.getEmployeeSalary()>=employeeSalary).collect(Collectors.toList());
    }

    @Override
    public long countEmployees() {
        return employeeRepositoryImpl.findAll().stream().collect(Collectors.counting());
    }

    @Override
    public void deleteDataById(int employeeId) {
        employeeRepositoryImpl.deleteById(employeeId);
    }

    @Override
    public void deleteAllData() {
        employeeRepositoryImpl.deleteAll();
    }
}
