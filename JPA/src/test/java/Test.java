import entities.Address;
import entities.Child;
import entities.Customer;
import entities.Parent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Test {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    @BeforeEach
    void setUp() {
        Map<String, Object> properties = new HashMap();
        Persistence.generateSchema("pu", properties);
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void test() {
        Customer customer1 = new Customer("Karl", "Emil");
        Customer customer2 = new Customer("Børge", "Larsen");
        Address address1 = new Address("Street 1", "City 1");
        Address address2 = new Address("Street 2", "City 2");
        customer1.addAddress(address1);
        customer2.addAddress(address2);

        create(customer1);
        create(customer2);


    }
    void create(Customer c){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            c.getAddresses().forEach(address ->{
                if(address.getId() == 0) {
                    em.persist(address);
                }
                if(em.find(Address.class,address.getId())==null) {
                    em.persist((address));
                }
            });
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }
}