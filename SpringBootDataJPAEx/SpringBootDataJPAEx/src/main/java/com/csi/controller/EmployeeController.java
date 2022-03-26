package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee)
    {
        log.info("*********** Trying to save data of "+employee.getEmployeeName());
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @PostMapping("/savebulkofdata")
    public ResponseEntity<List<Employee>> saveBulkOfData(@RequestBody List<Employee> employees)
    {
        log.info("*********** Trying to save bulk data of "+employeeServiceImpl.saveBulkOfData(employees).size()+" employees");
        return ResponseEntity.ok(employeeServiceImpl.saveBulkOfData(employees));
    }


    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData()
    {
        log.info("*********** Total Number of employees: "+employeeServiceImpl.getAllData().size());
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyid/{employeeId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int employeeId)
    {
        log.info("*********** Trying to get data of employee ID: "+employeeId);
        return ResponseEntity.ok(employeeServiceImpl.getDataById(employeeId));
    }

    @GetMapping("/getdatabyname/{employeeName}")
    public ResponseEntity<Employee> getDataByEmployeeName(@PathVariable String employeeName)
    {
        log.info("********** Trying to get data of "+employeeName);
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmployeeName(employeeName));
    }

    @GetMapping("/getdatabydob/{employeeDOB}")
    public ResponseEntity<Employee> getDataByEmployeeDOB(@PathVariable String employeeDOB)
    {
        log.info("*************** Trying to get data of employees on basis of their Date of Birth: "+employeeDOB);
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmployeeDOB(employeeDOB));
    }

    @GetMapping("/getfilteredrecords/{employeeSalary}")
    public ResponseEntity<List<Employee>> getFilteredRecords(@PathVariable double employeeSalary)
    {
        log.info("************* Total number of employees whose salary is equals or greater than "+employeeSalary+" are "+employeeServiceImpl.getFilteredRecords(employeeSalary).size());
        return ResponseEntity.ok(employeeServiceImpl.getFilteredRecords(employeeSalary));
    }

    @GetMapping("/getcount")
    public ResponseEntity<Long> countEmployees()
    {
        log.info("*********** Total number of employees working in this company: "+employeeServiceImpl.countEmployees());
        return ResponseEntity.ok(employeeServiceImpl.countEmployees());
    }


    @PutMapping("/updatedata/{employeeId}")
    public ResponseEntity<Employee> updateData(@PathVariable int employeeId, @RequestBody Employee employee) throws RecordNotFoundException {

        log.info("********** Trying to update data of "+employee.getEmployeeName());
        Employee employee1=employeeRepositoryImpl.findById(employeeId).orElseThrow(()-> new RecordNotFoundException("Employee Data Not Found"));
        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setEmployeeDOB(employee.getEmployeeDOB());
        employee1.setEmployeeSalary(employee.getEmployeeSalary());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employeeId,employee1));
    }

    @DeleteMapping("/deletedatabyid/{employeeId}")
    public ResponseEntity<String> deleteData(@PathVariable int employeeId)
    {
        log.info("************ Trying to delete data of Employee ID: "+employeeId);
        employeeServiceImpl.deleteDataById(employeeId);
        return ResponseEntity.ok("Employee Data Deleted Successfully");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData()
    {
        log.info("************** Trying to delete all data");
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All data deleted successfully");
    }
}
