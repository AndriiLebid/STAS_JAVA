package alebid.stasjavademo.service;

import alebid.stasjavademo.entities.Employee;
import alebid.stasjavademo.entities.RawScan;
import alebid.stasjavademo.entities.Shift;
import alebid.stasjavademo.repositories.EmployeeRepository;
import alebid.stasjavademo.repositories.ScanRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShiftService {

    private final ScanRepository scanRepository;
    private final EmployeeRepository employeeRepository;

    public ShiftService(ScanRepository scanRepository, EmployeeRepository employeeRepository) {
        this.scanRepository = scanRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Shift> populateALLShiftList(){

        List<Shift> shiftList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();

        for (Employee emp : employeeList) {
            Shift shift = new Shift();
            List<RawScan> scans = scanRepository.findAllByEmployee_Id(emp.getId());

            for (RawScan scan : scans) {

                if(shift.getLOG_IN() != null){

                    if(scan.getScanType().getTypeName().equals("IN")){
                        shiftList.add(shift);

                        shift.setEmployee(emp);
                        shift.setId(UUID.randomUUID().toString());
                        shift.setLOG_IN(scan.getScanDate());
                    }

                    switch (scan.getScanType().getTypeName()) {
                        case "OUT":
                            shift.setLOG_OUT(scan.getScanDate());
                            shiftList.add(shift);

                            break;
                        case "BREAKSTART":
                            if (shift.getBREAK_IN_1() == null) {
                                shift.setBREAK_IN_1(scan.getScanDate());
                            } else {
                                shift.setBREAK_IN_2(scan.getScanDate());
                            }
                            break;
                        case "BREAKEND":
                            if (shift.getBREAK_OUT_1() == null) {
                                shift.setBREAK_OUT_1(scan.getScanDate());
                            } else {
                                shift.setBREAK_OUT_2(scan.getScanDate());
                            }
                            break;
                        case "LUNCHSTART":
                            shift.setLUNCH_IN(scan.getScanDate());
                            break;
                        case "LUNCHEND":
                            shift.setLUNCH_OUT(scan.getScanDate());
                            break;
                        default:

                            break;
                    }

                }else{
                    if(scan.getScanType().getTypeName().equals("IN")){
                        shift.setId(UUID.randomUUID().toString());
                        shift.setEmployee(emp);
                        shift.setLOG_IN(scan.getScanDate());
                    }
                }

            }

        }

        return shiftList;
    }

}
