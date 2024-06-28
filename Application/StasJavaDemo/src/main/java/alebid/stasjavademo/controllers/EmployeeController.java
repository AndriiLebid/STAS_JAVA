package alebid.stasjavademo.controllers;

import alebid.stasjavademo.repositories.EmployeeRepository;
import alebid.stasjavademo.repositories.ScanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final ScanRepository scanRepository;

    public EmployeeController(ScanRepository scanRepository, EmployeeRepository employeeRepository) {
        this.scanRepository = scanRepository;
        this.employeeRepository = employeeRepository;
    }


    @GetMapping(value = "employee")
    public String getAllEmployee(Model model){
        var employee = employeeRepository.findAll();
        model.addAttribute("employee", employee);
        return "employee/index";
    }

    @GetMapping(value = "/employee/{id}")
    public String details(@PathVariable int id, Model model){
        var employee = employeeRepository.findById(id);
        if(employee.isPresent())
            model.addAttribute("employee", employee.get());
        return "employee/details";
    }


}
