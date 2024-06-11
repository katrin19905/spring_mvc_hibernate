package taranova.spring.mvc_hibernate_aop.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import taranova.spring.mvc_hibernate_aop.entity.Employee;
import taranova.spring.mvc_hibernate_aop.repository.EmployeeRepo;
import java.util.List;

@org.springframework.stereotype.Service
@Setter
@Getter
public class EmployeeService
        implements taranova.spring.mvc_hibernate_aop.services.Service<Employee> {

    private EmployeeRepo employeeRepo;

    public EmployeeService() {
        this.employeeRepo = new EmployeeRepo();
    }

    @Transactional //open and close transaction
    @Override
    public List<Employee> getAllEntities() {
        return employeeRepo.getAllEntities();
    }

    @Override
    public void saveEntity(Employee employee) {
        employeeRepo.saveEntity(employee);
        System.out.println("saved employee in service");
    }

    @Override
    public Employee findEntityById(int id) {
        return employeeRepo.findEntityById(id);
    }

    @Override
    public void deleteEntity(Employee entity) {
        employeeRepo.deleteEntity(entity);
    }
}