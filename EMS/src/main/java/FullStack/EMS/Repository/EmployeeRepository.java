package FullStack.EMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FullStack.EMS.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
