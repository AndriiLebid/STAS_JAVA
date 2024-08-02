package alebid.stasrestapidemo.services;


import alebid.stasjavademo.repositories.EmployeeRepository;
import alebid.stasjavademo.repositories.ScanRepository;
import alebid.stasjavademo.repositories.ScanTypeRepository;
import alebid.stasrestapidemo.dtos.ScanDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import alebid.stasjavademo.entities.RawScan;


@Service
public class ScanService {

    private final ScanRepository scanRepository;
    private final EmployeeRepository employeeRepository;
    private final ScanTypeRepository scanTypeRepository;

    public ScanService(ScanRepository scanRepository, EmployeeRepository employeeRepository, ScanTypeRepository scanTypeRepository) {
        this.scanRepository = scanRepository;
        this.employeeRepository = employeeRepository;
        this.scanTypeRepository = scanTypeRepository;
    }

    public RawScan addRawScan(ScanDTO scanDTO) {
        return convertFromScanDTO(scanDTO);
    }


    public ScanDTO getLastScanByUserId(int id) {
        try{
            RawScan scan = scanRepository.findTopByEmployee_IdOrderByIdDesc(id);
            return convertToScanDTO(scan);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Scan is not found");
        }
    }


    private ScanDTO convertToScanDTO(RawScan scan) {
        ScanDTO scanDTO = new ScanDTO();
        scanDTO.setScanType(scan.getScanType().getTypeName());
        scanDTO.setScanDate(scan.getScanDate());
        scanDTO.setEmployeeCode(scan.getEmployee().getEmployeeCardNumber());
        return scanDTO;
    }

    private RawScan convertFromScanDTO(ScanDTO scanDTO) {
        RawScan scan = new RawScan();
        scan.setScanDate(scanDTO.getScanDate());
        scan.setEmployee(employeeRepository.findByEmployeeCardNumber(scanDTO.getEmployeeCode()));
        scan.setScanType(scanTypeRepository.findByTypeName(scanDTO.getScanType()));
        return scan;
    }

}
