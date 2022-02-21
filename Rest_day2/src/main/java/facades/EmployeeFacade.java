package facades;

import dtos.EmployeeDTO;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public EmployeeDTO getEmployeeById(long id) {
        EntityManager em = emf.createEntityManager();
        return new EmployeeDTO(em.find(Employee.class, id));
    }

    public List<EmployeeDTO> getEmployeeByName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery query = em.createQuery("select e from Employee e WHERE e.name=:name", Employee.class);
            query.setParameter("name",name);
            return EmployeeDTO.getDTOs(query.getResultList());
        } finally {
            em.close();
            emf.close();
        }
    }
    public List<EmployeeDTO> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery query = em.createQuery("select e from Employee e", Employee.class);
            return EmployeeDTO.getDTOs(query.getResultList());
        } finally {
            em.close();
            emf.close();
        }
    }

    public long addEmployee(Employee employeeDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employeeDTO);
            em.getTransaction().commit();
            return employeeDTO.getId();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        EmployeeFacade facade = new EmployeeFacade();
        System.out.println(facade.getAllEmployees());
      //  System.out.println(facade.getEmployeeById(1));
    }
}
