package facades;

import entites.Customer;
import entites.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    Facade facade = new Facade();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createEmployee() {
        facade.createEmployee("Hans","Johansen","x999","hans.johansen@gmail.com","1",1401,"Sales Rep");

    }

    @Test
    void findCustomerTest() {
        Customer actual = facade.findCustomer(496);
        assertEquals("Kelly's Gift Shop",actual.getCustomerName());

    }

    @Test
    void updateCustomerTest() {
        Customer c = facade.findCustomer(496);
        c.setCustomerName("Hans's Gift Shop");
        facade.updateCustomer(c);
        assertEquals("Hans's Gift Shop", facade.findCustomer(496).getCustomerName());
    }

    @Test
    void getEmployeeCountTest() {
        System.out.println("Gets employee count");
        assertEquals(24,facade.getEmployeeCount());
    }

    @Test
    void getAllEmployeesTest() {
        System.out.println("Gets all employees");
        assertEquals(24,facade.getAllEmployees().size());
    }

    @Test
    void getCustomerInCityTest() {
        System.out.println("Gets customer in city");
        assertEquals(1,facade.getCustomerInCity("Barcelona").size());
    }
}