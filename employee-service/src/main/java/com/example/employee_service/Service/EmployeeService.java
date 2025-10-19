package com.example.employee_service.Service;

import com.example.employee_service.DTO.EmployeeDTO;
import com.example.employee_service.Model.Employee;
import com.example.employee_service.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //Add new people
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //Get All people
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    // Stream example - filter by department
    public List<Employee> getByDepartment(String Department){
        return employeeRepository.findAll().stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(Department))
                .collect(Collectors.toList());
    }

    //top 3 earners
    public List<Employee> getTop3Earners(){
        return employeeRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }
    //count based on department
    public Map<String,Long> getDepartmentCount(){
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
    }
    // average salary by department
    public Map<String,Double> getDepartmentAverageSalary(){
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
    }
    //find employees older than 40
    public List<EmployeeDTO>  getSeniorEmployees(){
        return employeeRepository.findAll().stream()
                .filter(emp->emp.getAge()>40)
                .map(emp-> EmployeeDTO.builder()
                        .name(emp.getName())
                        .Department(emp.getDepartment())
                        .Salary(emp.getSalary())
                        .build())
                .collect(Collectors.toList());
    }

    //total salary expenditure
    public Double getTotalSalary() {
        return employeeRepository.findAll().stream()
                .mapToDouble(Employee::getSalary).sum();
    }

    //department with max average salary
    public Optional<Map.Entry<String, Double>> getDeptWithHighestAvgSalary(){
        return getDepartmentAverageSalary().entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

}
