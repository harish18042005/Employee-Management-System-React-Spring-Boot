package FullStack.EMS.Service;

import java.util.List;

import FullStack.EMS.Dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployeeById(Long employeeId);

    void deleteAllEmployees();
}
