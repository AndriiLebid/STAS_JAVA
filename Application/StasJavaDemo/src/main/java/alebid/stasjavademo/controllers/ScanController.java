package alebid.stasjavademo.controllers;

import alebid.stasjavademo.repositories.ScanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ScanController {

    private final ScanRepository scanRepository;

    public ScanController(ScanRepository scanRepository) {
        this.scanRepository = scanRepository;
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



}
