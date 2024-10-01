package be.pxl.services.controller;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity getEmployee(){
        return new ResponseEntity(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(employeeService.getAllEmployeesById(id), HttpStatus.OK);
    }
    @GetMapping("/department/{departmentId}")
    public ResponseEntity getEmployeeByDepartment
            (@PathVariable("departmentId") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(employeeService.getAllEmployeesByDepartment(id), HttpStatus.OK);
    }
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity getEmployeeByOrganization(@PathVariable("organizationId") Long id) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity(employeeService.getAllEmployeesByOrganization(id), HttpStatus.OK);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
    }

}
