package alebid.stasjavademo.repositories;


import alebid.stasjavademo.entities.Employee;
import alebid.stasjavademo.entities.EmployeeType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByEmployeeType_Id(int typeId);

}
