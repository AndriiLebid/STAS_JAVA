package alebid.stasjavademo.repositories;

import alebid.stasjavademo.entities.Employee;
import alebid.stasjavademo.entities.RawScan;
import alebid.stasjavademo.entities.ScanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScanRepository extends JpaRepository<RawScan, Integer> {

    List<RawScan> findAllByScanType(ScanType scanType);
    List<RawScan> findAllByEmployee_Id(int EmpId);

}
