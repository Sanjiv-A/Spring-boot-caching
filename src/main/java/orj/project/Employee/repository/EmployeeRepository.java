package orj.project.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orj.project.Employee.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

}
