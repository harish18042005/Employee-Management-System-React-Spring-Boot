package FullStack.EMS.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FullStack.EMS.Dto.EmployeeDto;
import FullStack.EMS.Entity.Employee;
import FullStack.EMS.Exception.ResourceNotFoundException;
import FullStack.EMS.Mapper.EmployeeMapper;
import FullStack.EMS.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
      Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(()-> 
                new ResourceNotFoundException("Employee not found for the given id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
            .map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(()-> 
                new ResourceNotFoundException("Employee not found with the given id: "+employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(()-> 
                new ResourceNotFoundException("Employee not found with the given id: "+employeeId));

        employeeRepository.delete(employee);
        

    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
    
}
