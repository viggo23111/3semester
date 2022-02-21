/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.Employee;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            Employee e1 = new Employee("Hans hansen","lyngby test",30000);
            Employee e2 = new Employee("Jens jensen","Kastrup test",40000);
            em.persist(e1);
            em.persist(e2);
            em.getTransaction().commit();

        } finally {
            em.close();
            emf.close();
        }
    }
    
    public static void main(String[] args) {
        populate();
    }
}
