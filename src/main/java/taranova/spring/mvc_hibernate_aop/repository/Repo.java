package taranova.spring.mvc_hibernate_aop.repository;

import taranova.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface Repo<E> {
    List<E> getAllEntities();
    void saveEntity(E e);
    Employee findEntityById(int id);
    void deleteEntity(E entity);
}
