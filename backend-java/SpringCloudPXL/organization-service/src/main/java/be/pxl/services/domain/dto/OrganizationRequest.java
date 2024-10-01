package be.pxl.services.domain.dto;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationRequest {
    private String name;
    private String address;
    private List<Employee> employees;
    private List<Department> departments;
}
