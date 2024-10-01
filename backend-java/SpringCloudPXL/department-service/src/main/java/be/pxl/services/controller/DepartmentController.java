package be.pxl.services.controller;

import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/Department")
@RequiredArgsConstructor
public class DepartmentController {
    public IDepartmentService departmentService;
    @GetMapping
    public ResponseEntity getDepartment(){
        return new  ResponseEntity(departmentService.getAllDepartment(), HttpStatus.OK );
    }
    @GetMapping("/{id}")
    public ResponseEntity getDepartmentById(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return new  ResponseEntity(departmentService.getAllDepartmentById(id), HttpStatus.OK );
    }
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity getDepartmentByOrganization
            (@PathVariable("organizationId") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(departmentService.getAllDepartmentByOrganization(id), HttpStatus.OK);
    }
    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity getDepartmentByOrganizationWithEmployees
            (@PathVariable("organizationId") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(departmentService.getAllDepartmentByOrganizationWithEmployees(id), HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@RequestBody DepartmentRequest departmentRequest){
        departmentService.addDepartment(departmentRequest);
    }

}
