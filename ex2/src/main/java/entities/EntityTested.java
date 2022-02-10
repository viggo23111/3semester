package entities;

import facade.CustomerFacade;

import javax.persistence.*;
import java.util.List;

public class EntityTested {

    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        em.persist(new Customer("Viktor","Nymand"));
        em.persist(new Customer("Vincent","Buchholz"));
        em.persist(new Customer("Karl","Larsen"));
        em.getTransaction().commit();

        // Close the database connection:
        em.close();
        emf.close();*/
        CustomerFacade customerFacade = new CustomerFacade();
       // System.out.println(customerFacade.findById(1).toString());
        //System.out.println(customerFacade.findById(2).toString());
       /* for (Customer customer : customerFacade.findByLastName("Nymand")) {
            System.out.println(customer.toString());
        }*/
       // System.out.println(customerFacade.getNumberOfCustomers());
      /*  for (Customer customer : customerFacade.allCustomers()) {
            System.out.println(customer.toString());

        }*/
        System.out.println(customerFacade.addCustomer("Johan", "Buller").toString());

    }
}
