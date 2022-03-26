package com.csi.dao;

import com.csi.model.Employee;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    Employee saveData(Employee employee);

    List<Employee> saveBulkOfData(List<Employee> employees);

    List<Employee> getAllData();

    Optional<Employee> getDataById(int employeeId);

    Employee getDataByEmployeeName(String employeeName);

    Employee getDataByEmployeeDOB(String employeeDOB);

    Employee updateData(int employeeId, Employee employee);

    List<Employee> getFilteredRecords(double employeeSalary);

    long countEmployees();

    void deleteDataById(int employeeId);

    void deleteAllData();
}
