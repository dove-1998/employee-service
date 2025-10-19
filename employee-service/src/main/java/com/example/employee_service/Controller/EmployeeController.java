package com.example.employee_service.Controller;


import com.example.employee_service.DTO.EmployeeDTO;
import com.example.employee_service.Model.Employee;
import com.example.employee_service.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    // get All Employees
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployee(){
        return employeeService.findAllEmployee();
    }
    //Add an employee
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    //filter by department
    @GetMapping("/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept){
        return employeeService.getByDepartment(dept);
    }
    //top 3 earners
    @GetMapping("/topearners")
    public List<Employee> getTopEarners(){
        return employeeService.getTop3Earners();
    }
    //get department count
    @GetMapping("/countdepartmentwise")
    public Map<String,Long> countByDepartment(){
        return employeeService.getDepartmentCount();
    }
    //get department average
    @GetMapping("/average-salary")
    public Map<String, Double> getDepartmentAvg(){
        return employeeService.getDepartmentAverageSalary();
    }
    // get employees age>40
    @GetMapping("/seniors")
    public List<EmployeeDTO> getSeniorEmployee(){
        return employeeService.getSeniorEmployees();
    }
    //get total salary
    @GetMapping("/total-salary")
    public Double getTotalSalary(){
        return employeeService.getTotalSalary();
    }
    //department with max average salary
    @GetMapping("/average-dept-salary")
    public Optional<Map.Entry<String, Double>> maxDeptAvgSalary(){
        return employeeService.getDeptWithHighestAvgSalary();
    }
}
