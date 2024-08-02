package alebid.stasjavademo.repositories;

import alebid.stasjavademo.entities.ScanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanTypeRepository extends JpaRepository<ScanType, Integer> {
    ScanType findByTypeName(String name);
}

