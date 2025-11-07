package orj.project.Employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import orj.project.Employee.entity.Employee;
import orj.project.Employee.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @CachePut(value = "employees", key = "#result.id")
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }



    @Cacheable(value = "employees", key = "#id")
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @CachePut(value = "employees", key = "#id")
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setRole(employeeDetails.getRole());
            // add other fields
            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    @CacheEvict(value = "employees", key = "#id")
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
