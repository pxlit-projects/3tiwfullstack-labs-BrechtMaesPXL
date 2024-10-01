package be.pxl.services.services;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.OrganizationResponse;
import be.pxl.services.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServices implements IOrganizationServices{

    private OrganizationRepository organizationRepository;

    private OrganizationResponse mapToOrganizationResponse(Organization organization) {
        return OrganizationResponse.builder()

                .name(organization.getName())
                .address(organization.getAddress())
                .departments(organization.getDepartments())
                .employees(organization.getEmployees())
                .build();
    }

    @Override
    public OrganizationResponse getOrganizaitonById(Long id) throws NotActiveException {
       Organization organzation =  organizationRepository.findById(id).orElseThrow(NotActiveException::new);
        return mapToOrganizationResponse(organzation);
    }

    @Override
    public List<Organization> getAllOrganizationByIdWithDepartments(Long id) {
        return null;
    }

    @Override
    public List<Organization> getAllOrganizationByIdWithDepartmentsAndEmployees(Long id) {
        return null;
    }

    @Override
    public List<Organization> getAllOrganizationByIdWithEmployees(Long id) {
        return null;
    }
}
