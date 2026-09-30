package com.spring.jpa.mapping.service;

import com.spring.jpa.mapping.domain.*;
import com.spring.jpa.mapping.dto.*;
import com.spring.jpa.mapping.mapper.EmployeeMapper;
import com.spring.jpa.mapping.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    private final HospitalRepository hospitalRepository;

    private final DoctorRepository doctorRepository;

    private final AddressRepository addressRepository;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final EmployeeRepository employeeRepository;

    public UserService(AddressRepository addressRepository, StudentRepository studentRepository,CourseRepository courseRepository,
                       EmployeeRepository employeeRepository,HospitalRepository hospitalRepository,
                       DoctorRepository doctorRepository) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.employeeRepository = employeeRepository;
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
    }

    public String saveUser(UserDTO userDTO) {
        Student student = new Student(userDTO);
        Student student1 = studentRepository.save(student);
        return "Student saved Successfullu id is:"+student1.getId();
    }

    public UserDTO getUser(Long userId) {
        Student student = (Student) studentRepository.findById(userId).orElseThrow(() -> new RuntimeException("Student not found"));
        UserDTO userDTO = new UserDTO(student);
        return userDTO;
    }

    public List<UserDTO> getUsers() {
        List<Student> students = studentRepository.findAll();
        List<UserDTO> userDTOS= students.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());

        return userDTOS;
    }

    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
       return employeeRepository.save(employee);
    }

    public EmployeeDTO getEmployee(Long empId) {

        //Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Student not found"));

        //EmployeeDTO employee = employeeRepository.findByEmployId(empId);
        //EmployeeDTO employeeDTO =modelMapper.map(employee,EmployeeDTO.class);
        Employee employee =employeeRepository.findAnythingById(empId);
        EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);
        EmployeeProjection employeeProjection = employeeRepository.findProjectedById(empId);
        return employeeDTO;
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }

    public Doctor saveDoctor(DoctorDTO doctorDTO) {
        List<Hospital> hospitals = hospitalRepository.findAllById(doctorDTO.getHospitalIds());
        Doctor doctor = new Doctor(doctorDTO);
        doctor.setHospitals(hospitals);
        Doctor doctor1 =doctorRepository.save(doctor);
        return  doctor1;
    }

    public Hospital addHospital(HospitalDTO hospitalDTO) {

        Address address = addressRepository.findById(hospitalDTO.getAddressId()).orElseThrow(() -> new RuntimeException("Address not found"));
        Hospital hospital = new Hospital(hospitalDTO,address);
        return hospitalRepository.save(hospital);
    }

    public Doctor getDoctor(Long doctorId) {
       return doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctors Not Found"));
    }

    public List<Doctor> getDoctors() {
       return doctorRepository.findAll();
    }

    public Hospital getHospital(Long hospitalId) {
        Hospital hospital= hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException("Hospital not found"));
        return hospital;
    }

    public List<HospitalDTOResponse> getHospitals() {
        List<Hospital> hospitals= hospitalRepository.findAll();
        List<HospitalDTOResponse> list = hospitals.stream().map(HospitalDTOResponse::new).toList();
        return list;

    }

    public OrganizationDTO addOrganization(OrganizationDTO organizationDTO) {

        Organization organization = modelMapper.map(organizationDTO,Organization.class);

        organization = organizationRepository.save(organization);
        OrganizationDTO organizationDTO1 = modelMapper.map(organization,OrganizationDTO.class);
        return organizationDTO1;
    }



}
