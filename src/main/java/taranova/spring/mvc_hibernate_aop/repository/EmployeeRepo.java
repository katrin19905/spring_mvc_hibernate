package taranova.spring.mvc_hibernate_aop.repository;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import taranova.spring.mvc_hibernate_aop.entity.Employee;
import java.util.List;

@Repository
@Setter
@Getter
public class EmployeeRepo implements Repo<Employee> {
    private SessionFactory sessionFactory;

    public EmployeeRepo() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "dhtvtyf");
        configuration.addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("success configured session factory in repo"+sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEntities() {
        Session session = sessionFactory.openSession();
        Query<Employee> query = session.createQuery("from Employee"
                , Employee.class);
        List<Employee> allEmp = query.getResultList();

        return allEmp;
    }

    @Override
    public void saveEntity(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        System.out.println("saved employee in repo");

    }

    @Override
    public Employee findEntityById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        return employee;
    }

    @Override
    public void deleteEntity(Employee entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }
}