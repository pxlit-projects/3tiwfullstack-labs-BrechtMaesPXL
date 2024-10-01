package be.pxl.services.controller;

import be.pxl.services.services.IOrganizationServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.NotActiveException;

@RestController
@RequestMapping({"/api/Organization"})
@RequiredArgsConstructor
public class OrganizationController {
    private IOrganizationServices organizationServices;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) throws NotActiveException {
        return new ResponseEntity(organizationServices.getOrganizaitonById(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/with-departments")
    public ResponseEntity getOrganizationByIdWithDepartments
            (@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(organizationServices.getAllOrganizationByIdWithDepartments(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity getOrganizationByIdWithDepartmentsAndEmployees
            (@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(organizationServices.getAllOrganizationByIdWithDepartmentsAndEmployees(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/with-employees")
    public ResponseEntity getOrganizationByIdWithEmployees
            (@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(organizationServices.getAllOrganizationByIdWithEmployees(id), HttpStatus.OK);
    }
}
