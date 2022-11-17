package com.pringweb.cassandra.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        Iterator<Employee> iterator = employeeRepository.findAll().iterator();
        List<Employee> employeeList = new ArrayList<>();
        iterator.forEachRemaining(employeeList::add);
        return employeeList;
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id) {
        return employeeRepository.findById(id);
    }

    @PutMapping("/employees/{id}")
    public Optional<Employee> updateEmployee(@RequestBody Employee employeeReferenceWithUpdates,
                                             @PathVariable String id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee emp = optionalEmployee.get();
            emp.setFirstName(employeeReferenceWithUpdates.getFirstName());
            emp.setLastName(employeeReferenceWithUpdates.getLastName());
            emp.setEmail(employeeReferenceWithUpdates.getEmail());
            employeeRepository.save(emp);
        }

        return optionalEmployee;

    }

    @DeleteMapping(value = "/employee/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeRepository.deleteById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        String id = UUID.randomUUID().toString();
        Employee emp = new Employee(id, newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getEmail());
        employeeRepository.save(emp);
        return emp;
    }

}
