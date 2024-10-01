package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentResponse> getAllDepartment() {
        List<Department> depatments = departmentRepository.findAll();
        return depatments.stream().map(this::mapToDepartmentresponse).toList();

    }



    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .employees(departmentRequest.getEmployees())
                .name(departmentRequest.getName())
                .organizationId(departmentRequest.getOrganizationId())
                .position(departmentRequest.getPosition())
                .build();
        departmentRepository.save(department);
    }

    @Override
    public DepartmentResponse getAllDepartmentById(Long id) throws ChangeSetPersister.NotFoundException {
        Department department = departmentRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);;
        return mapToDepartmentresponse(department);
    }

    @Override
    public List<DepartmentResponse> getAllDepartmentByOrganization(Long id) {
        List<Department> department = departmentRepository.findByOrganizationId(id);
        return department.stream().map(this::mapToDepartmentresponse).toList();
    }

    @Override
    public List<DepartmentResponse> getAllDepartmentByOrganizationWithEmployees(Long id) {
        return null;
    }

    private DepartmentResponse mapToDepartmentresponse(Department department) {
        return DepartmentResponse.builder()
                .employees(department.getEmployees())
                .name(department.getName())
                .organizationId(department.getOrganizationId())
                .position(department.getPosition())
                .build();
    }
}
