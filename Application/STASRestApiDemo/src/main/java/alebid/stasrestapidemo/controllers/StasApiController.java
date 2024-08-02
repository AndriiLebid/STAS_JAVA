package alebid.stasrestapidemo.controllers;

import alebid.stasjavademo.entities.RawScan;
import alebid.stasrestapidemo.dtos.ScanDTO;
import alebid.stasrestapidemo.dtos.ValidationErrorDTO;
import alebid.stasrestapidemo.services.ScanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StasApiController {
    private final ScanService scanService;

    public StasApiController(ScanService scanService) {
        this.scanService = scanService;
    }

    @GetMapping("/api/getLastScanByEmployeeId/{id}")
    public ResponseEntity<ScanDTO> getLastScanByUserID(@PathVariable int id){
        ScanDTO scan = scanService.getLastScanByUserId(id);
        return ResponseEntity.ok(scan);
    }

    @PostMapping("/api/scan")
    public ResponseEntity<RawScan> setRawScan(@RequestBody ScanDTO scanDTO){

        RawScan scan = scanService.addRawScan(scanDTO);
        return ResponseEntity.ok(scan);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDTO>> validationExceptionHandler(MethodArgumentNotValidException ex) {
        List<ValidationErrorDTO> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ValidationErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }



}
