package alebid.stasjavademo.controllers;

import alebid.stasjavademo.entities.Employee;
import alebid.stasjavademo.entities.User;
import alebid.stasjavademo.repositories.EmployeeRepository;
import alebid.stasjavademo.repositories.EmployeeTypeRepository;
import alebid.stasjavademo.repositories.ScanRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeTypeRepository employeeTypeRepository;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeTypeRepository employeeTypeRepository) {

        this.employeeRepository = employeeRepository;
        this.employeeTypeRepository = employeeTypeRepository;
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

    //Create methods
    @GetMapping(value = "/employee/create")
    public String create(Model model) {

        Employee employee  = new Employee();
        model.addAttribute("employee", employee);
        employee.setEmployeeType(employeeTypeRepository.getById(2));
        return "employee/create";
    }

    @PostMapping(value = "/employee/create")
    public String create(@Valid Employee employee, BindingResult br, Model model) {
        //Save

        if (!br.hasErrors()) {
            employeeRepository.save(employee);
            return "redirect:/employee";
        } else {
            model.addAttribute("roles", employeeTypeRepository.findAll());
            return "employee/create";
        }
    }

    //Edit methods
    @GetMapping(value = "/employee/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        var employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            model.addAttribute("employee", employee.get());
            model.addAttribute("roles", employeeTypeRepository.findAll());
        }
        return "employee/edit";
    }


    @PostMapping(value = "/employee/edit/{id}")
    public String edit(@Valid Employee employee, BindingResult br, Model model) {

        if (!br.hasErrors()) {
            employeeRepository.save(employee);
            return "redirect:/employee";
        } else {
            model.addAttribute("roles", employeeTypeRepository.findAll());
            return "/employee/edit";
        }

    }

    // Delete methods
    @GetMapping(value = "/employee/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        var employee = employeeRepository.findById(id);
        if (employee.isPresent())
            model.addAttribute("employee", employee.get());
        return "employee/delete";
    }

    @PostMapping(value = "/employee/delete/{id}")
    public String deleteConfirm(@PathVariable int id, Model model) {
        var employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.deleteById(id);
            return "redirect:/employee";
        }else{
            return "redirect:/employee";
        }
    }


}
