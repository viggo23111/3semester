package facades;

import entities.Department;
import entities.Employee;
import org.eclipse.persistence.jpa.jpql.parser.EncapsulatedIdentificationVariableExpression;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Facade implements IFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try{
          TypedQuery<Employee> tq =  em.createQuery("SELECT e FROM Employee e", Employee.class);
         return tq.getResultList();

        }finally {
            em.close();
        }
    }

    @Override
    public Employee getHighestPaid() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e ORDER BY e.salery DESC", Employee.class);
            tq.setMaxResults(1);
            return tq.getSingleResult();
        }finally {
            em.close();
        }
    }

    @Override
    public Double getAverageSalery() {
        return null;
    }

    @Override
    public List<Employee> getAllBelowAverage() {
        return null;
    }

    @Override
    public Department getWithMostEmployees() {
        return null;
    }

    @Override
    public Department getMostExpensiveSalarySum() {
        return null;
    }

    @Override
    public List<Department> getDepartmentsWithEmpNamed(String name) {
        return null;
    }

    public Employee updateEmployee(Employee e){
        EntityManager em = emf.createEntityManager();
        Employee found = em.find(Employee.class,e.getId());
        String name = e.getName();
        if(name !=null)
            found.setName(name);
        try{
            em.getTransaction().begin();
            em.merge(found);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }
}
