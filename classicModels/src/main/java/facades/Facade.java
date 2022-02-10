package facades;

import entites.Customer;
import entites.Employee;
import org.eclipse.persistence.jpa.jpql.parser.EncapsulatedIdentificationVariableExpression;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class Facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public Employee createEmployee(String firstName, String lastName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle){
        Employee e = new Employee(firstName,lastName,extension,email,officeCode,reportsTo,jobTitle);
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return e;
    }

    public Customer findCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> tq = em.createQuery("SELECT c FROM Customer c WHERE c.customerNumber=:id",Customer.class);
            tq.setParameter("id",id);
            Customer c = tq.getSingleResult();
            return c;

        }finally {
            em.close();
        }

    }

    public void updateCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public int getEmployeeCount() {
        EntityManager em = emf.createEntityManager();

        try{
            Query q1 = em.createQuery("SELECT COUNT(e) FROM Employee e");
            long count = (long) q1.getSingleResult();
            return (int) count;
        }finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> tq =  em.createQuery("SELECT e FROM Employee e", Employee.class);
            return tq.getResultList();

        }finally {
            em.close();
        }


    }

    public List<Customer> getCustomerInCity(String s) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> tq =  em.createQuery("SELECT c FROM Customer c WHERE c.city=:s", Customer.class);
            tq.setParameter("s",s);
            return tq.getResultList();

        }finally {
            em.close();
        }
    }
}
