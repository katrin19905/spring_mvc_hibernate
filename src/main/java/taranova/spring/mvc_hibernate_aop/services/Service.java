package taranova.spring.mvc_hibernate_aop.services;

import taranova.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface Service<E> {

    List<E> getAllEntities();
    void saveEntity(Employee employee);
    Employee findEntityById(int id);
    void deleteEntity(E entity);
}
