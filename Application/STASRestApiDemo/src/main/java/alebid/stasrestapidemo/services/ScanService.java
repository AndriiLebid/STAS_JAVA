package alebid.stasrestapidemo.services;


import alebid.stasjavademo.repositories.ScanRepository;
import alebid.stasrestapidemo.dtos.ScanDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import alebid.stasjavademo.entities.RawScan;


@Service
public class ScanService {

    private final ScanRepository scanRepository;


    public ScanService(ScanRepository scanRepository) {
        this.scanRepository = scanRepository;
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

}
