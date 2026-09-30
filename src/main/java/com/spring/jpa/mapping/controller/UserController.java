package com.spring.jpa.mapping.controller;

import com.spring.jpa.mapping.domain.Doctor;
import com.spring.jpa.mapping.domain.Employee;
import com.spring.jpa.mapping.domain.Hospital;
import com.spring.jpa.mapping.dto.*;
import com.spring.jpa.mapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }
    @GetMapping()
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return userService.saveEmployee(employeeDTO);
    }
    @GetMapping("/employee/{empId}")
    public EmployeeDTO getEmployee(@PathVariable Long empId){
        return userService.getEmployee(empId);
    }

    @PostMapping("/organization")
    public OrganizationDTO addOrganization(@RequestBody OrganizationDTO organizationDTO){
        return userService.addOrganization(organizationDTO);
    }

    @GetMapping("/all/employee")
    public List<Employee> getAllEmployee(){
        return userService.getEmployees();
    }
    @PostMapping("/hospital")
    public Hospital saveHospital(@RequestBody HospitalDTO hospitalDTO){
        return userService.addHospital(hospitalDTO);
    }

    @PostMapping("/doctor")
    public Doctor saveDoctor(@RequestBody DoctorDTO doctorDTO){
        return userService.saveDoctor(doctorDTO);
    }
    @GetMapping("/doctors/{doctorId}")
    public Doctor getdoctorById(@PathVariable Long doctorId){
        return userService.getDoctor(doctorId);
    }

    @GetMapping("/all/doctors")
    public List<Doctor> getAllDoctor(){
        return userService.getDoctors();
    }

    @GetMapping("/hospital/{hospitalId}")
    public Hospital getHospitalById(@PathVariable Long hospitalId){
        return userService.getHospital(hospitalId);
    }

    @GetMapping("/all/hospital")
    public List<HospitalDTOResponse> getAllHospital(){
        return userService.getHospitals();
    }

}
