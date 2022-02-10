package facades;

import entities.Child;
import entities.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Facade {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public void create(Parent p){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            p.getChildren().forEach(child ->{
                if(child.getId() ==null) {
                    em.persist(child);
                }
                if(em.find(Child.class,child.getId())==null) {
                    em.persist((child));
                }
            });
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public static void main(String[] args) {
        Facade facade = new Facade();

        Parent p = new Parent("Vincent", 22);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Child>  typedQuery = em.createQuery("SELECT c FROM Child c WHERE c.name=:name", Child.class);
        typedQuery.setParameter("name","Åse");
        List<Child> children =typedQuery.getResultList();
      //  Child c = new Child("Åse",2);
        p.addChild(children.get(0));

        facade.create(p);
    }
}
