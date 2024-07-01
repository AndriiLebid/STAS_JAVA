package alebid.stasjavademo.controllers;

import alebid.stasjavademo.entities.Employee;
import alebid.stasjavademo.entities.RawScan;
import alebid.stasjavademo.repositories.EmployeeRepository;
import alebid.stasjavademo.repositories.ScanRepository;
import alebid.stasjavademo.repositories.ScanTypeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScanController {

    private final ScanRepository scanRepository;
    private final ScanTypeRepository scanTypeRepository;
    private final EmployeeRepository employeeRepository;

    public ScanController(ScanRepository scanRepository, ScanTypeRepository scanTypeRepository, EmployeeRepository employeeRepository) {
        this.scanRepository = scanRepository;
        this.scanTypeRepository = scanTypeRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = {"/scans", "/scan"})
    public String getAll(Model model){
        var scans = scanRepository.findAll();
        model.addAttribute("scans", scans);
        return "scans/index";
    }

    @GetMapping(value = "/scans/{id}")
    public String details(@PathVariable int id, Model model){
        var scan = scanRepository.findById(id);
        if(scan.isPresent())
            model.addAttribute("scan", scan.get());
        return "scans/details";
    }


    //Create methods
    @GetMapping(value = "/scans/create")
    public String create(Model model) {
        model.addAttribute("scan", new RawScan());
        model.addAttribute("types", scanRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        return "scans/create";
    }

    @PostMapping(value = "/scans/create")
    public String create(@Valid RawScan scan, BindingResult br, Model model) {
        //Save
        if (!br.hasErrors()) {
            scanRepository.save(scan);
            return "redirect:/scans";
        } else {
            model.addAttribute("types", scanTypeRepository.findAll());
            model.addAttribute("employees", employeeRepository.findAll());
            return "scans/create";
        }
    }

    //Edit methods
    @GetMapping(value = "/scans/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        var employee = scanRepository.findById(id);
        if (employee.isPresent()){
            model.addAttribute("scan", employee.get());
            model.addAttribute("types", scanTypeRepository.findAll());
            model.addAttribute("employees", employeeRepository.findAll());
        }
        return "scans/edit";
    }


    @PostMapping(value = "/scans/edit/{id}")
    public String edit(@Valid RawScan scan, BindingResult br, Model model) {

        if (!br.hasErrors()) {
            scanRepository.save(scan);
            return "redirect:/scans";
        } else {
            model.addAttribute("types", scanTypeRepository.findAll());
            model.addAttribute("employees", employeeRepository.findAll());
            return "/scans/edit";
        }

    }

    // Delete methods
    @GetMapping(value = "/scans/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        var scan = scanRepository.findById(id);
        if (scan.isPresent())
            model.addAttribute("scans", scan.get());
        return "scans/delete";
    }

    @PostMapping(value = "/scans/delete/{id}")
    public String deleteConfirm(@PathVariable int id, Model model) {
        var scan = scanRepository.findById(id);
        if(scan.isPresent()) {
            scanRepository.deleteById(id);
            return "redirect:/scans";
        }else{
            return "redirect:/scans";
        }
    }


}
