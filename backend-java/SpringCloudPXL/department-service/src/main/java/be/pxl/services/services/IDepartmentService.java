package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponse> getAllDepartment();

    void addDepartment(DepartmentRequest departmentRequest);

    DepartmentResponse getAllDepartmentById(Long id) throws ChangeSetPersister.NotFoundException;

    List<DepartmentResponse> getAllDepartmentByOrganization(Long id);

    List<DepartmentResponse> getAllDepartmentByOrganizationWithEmployees(Long id);
}
