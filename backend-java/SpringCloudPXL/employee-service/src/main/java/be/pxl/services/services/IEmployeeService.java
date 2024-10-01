package be.pxl.services.services;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getAllEmployees();

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getAllEmployeesById(Long id) throws ChangeSetPersister.NotFoundException;

    List<EmployeeResponse> getAllEmployeesByDepartment(Long id);

    List<EmployeeResponse> getAllEmployeesByOrganization(Long id);
}
