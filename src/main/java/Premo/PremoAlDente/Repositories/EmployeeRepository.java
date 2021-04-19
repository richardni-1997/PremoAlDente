package Premo.PremoAlDente.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Premo.PremoAlDente.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByActive(boolean active);
}
