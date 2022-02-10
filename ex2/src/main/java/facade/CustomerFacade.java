package facade;

import entities.Customer;

import javax.persistence.*;
import java.util.List;

public class CustomerFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public CustomerFacade() {
    }

    public Customer findById(long id){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.id ='"+id+"'");
        Customer c = (Customer) query.getSingleResult();
        em.close();
        return c;
    }

    public List<Customer> findByLastName(String name){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.lastName ='"+name+"'");
        List<Customer> customerList = query.getResultList();
        em.close();
        return customerList;
    }

    public int getNumberOfCustomers(){
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT COUNT(c) FROM Customer c");
        long count = (long) q1.getSingleResult();
        em.close();
        return (int) count;
    }

    public List<Customer> allCustomers(){
        // Retrieve all the Customer objects from the database:
        EntityManager em = emf.createEntityManager();
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> results = query.getResultList();
        em.close();
        return results;
    }

    public Customer addCustomer(String fName, String lName){
        EntityManager em = emf.createEntityManager();
        Customer c = new Customer(fName,lName);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        return c;
    }

}
