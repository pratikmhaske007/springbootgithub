package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;


    @Override
    public Employee saveData(Employee employee) {
        return employeeDaoImpl.saveData(employee);
    }

    @Override
    public List<Employee> saveBulkOfData(List<Employee> employees) {
        return employeeDaoImpl.saveBulkOfData(employees);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    @Override
    public Optional<Employee> getDataById(int employeeId) {
        return employeeDaoImpl.getDataById(employeeId);
    }

    @Override
    public Employee getDataByEmployeeName(String employeeName) {
        return employeeDaoImpl.getDataByEmployeeName(employeeName);
    }

    @Override
    public Employee getDataByEmployeeDOB(String employeeDOB) {
        return employeeDaoImpl.getDataByEmployeeDOB(employeeDOB);
    }

    @Override
    public Employee updateData(int employeeId, Employee employee) {
        return employeeDaoImpl.updateData(employeeId,employee);
    }

    @Override
    public List<Employee> getFilteredRecords(double employeeSalary) {
        return employeeDaoImpl.getFilteredRecords(employeeSalary);
    }

    @Override
    public long countEmployees() {
        return employeeDaoImpl.countEmployees();
    }

    @Override
    public void deleteDataById(int employeeId) {
        employeeDaoImpl.deleteDataById(employeeId);
    }

    @Override
    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();
    }
}
