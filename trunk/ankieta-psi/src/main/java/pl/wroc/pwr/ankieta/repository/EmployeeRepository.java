package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
