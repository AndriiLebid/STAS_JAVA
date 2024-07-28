package alebid.stasjavademo.controllers;

import alebid.stasjavademo.entities.Shift;
import alebid.stasjavademo.repositories.ScanRepository;
import alebid.stasjavademo.service.ShiftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShiftController {

    private final ShiftService shiftService;
    List<Shift> shifts = new ArrayList<>();

    public ShiftController(ShiftService shiftService) {

        this.shiftService = shiftService;
    }

    @GetMapping(value = {"/shift", "/shifts"})
    public String getAll(Model model){
        shifts = shiftService.populateALLShiftList();
        model.addAttribute("shifts", shifts);
        return "shift/index";
    }

    @GetMapping(value = "/shift/{id}")
    public String details(@PathVariable String id, Model model){

        Shift shift = shifts.stream().filter(sh -> sh.getId().equals(id)).findFirst().get();
        if(shift.getId() != null)
            model.addAttribute("shift", shift);
        return "shift/details";
    }




}
