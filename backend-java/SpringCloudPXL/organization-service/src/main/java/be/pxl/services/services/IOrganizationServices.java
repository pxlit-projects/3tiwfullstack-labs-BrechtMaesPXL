package be.pxl.services.services;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.domain.dto.OrganizationResponse;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;

public interface IOrganizationServices {
    public OrganizationResponse getOrganizaitonById(Long id) throws NotActiveException;

    List<Organization> getAllOrganizationByIdWithDepartments(Long id);

    List<Organization> getAllOrganizationByIdWithDepartmentsAndEmployees(Long id);

    List<Organization> getAllOrganizationByIdWithEmployees(Long id);
}
