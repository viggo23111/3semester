package facades;

import entities.Semester;
import entities.Student;
import entities.Teacher;
import mappers.StudentInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");


    public List<Student> findAllStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> tq = em.createQuery("SELECT s FROM Student s", Student.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Teacher> findAllTeachers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Teacher> tq = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Student> findStudentsByFirstName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> tq = em.createQuery("SELECT s FROM Student s WHERE s.firstname=:name", Student.class);
            tq.setParameter("name",name);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    public void insertNewStudent(String fName, String lName, int semester) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student s = new Student(fName,lName,semester);
            em.persist(s);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public void updateStudentSemester(int id, int semester) {
        EntityManager em = emf.createEntityManager();
        try{
            Student s = findStudent(id);
            s.setCurrentSemesterId(semester);
            em.getTransaction().begin();
            em.merge(s);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public Student findStudent(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Student> tq = em.createQuery("SELECT s FROM Student s WHERE s.id=:id",Student.class);
            tq.setParameter("id",id);
            Student s = tq.getSingleResult();
            return s;

        }finally {
            em.close();
        }
    }

    public List<Student> findAllStudentsWithLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> tq = em.createQuery("SELECT s FROM Student s WHERE s.lastname=:name", Student.class);
            tq.setParameter("name",name);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    public int findAmountOfStudentInSemester(String semesterName) {
        EntityManager em = emf.createEntityManager();
        try{
            Query q1 = em.createQuery("SELECT count(s) FROM Student s LEFT JOIN Semester c WHERE s.currentSemesterId = c.id and c.name=:semesterName");
            q1.setParameter("semesterName",semesterName);
            long count = (long) q1.getSingleResult();
            return (int) count;
        }finally {
            em.close();
        }
    }

    public int getStudentCount() {
        EntityManager em = emf.createEntityManager();
        try{
            Query q1 = em.createQuery("SELECT count(s) FROM Student s");
            long count = (long) q1.getSingleResult();
            return (int) count;
        }finally {
            em.close();
        }
    }

    public Teacher getTeacherWithMostSemesters() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Teacher> tq = em.createQuery("SELECT t FROM Teacher t join TeacherSemester ts WHERE t.id =ts.teachersId group by ts.teachersId order by COUNT(ts.teachingId) desc", Teacher.class);
            tq.setMaxResults(1);
            Teacher t = tq.getSingleResult();
            return t;

        } finally {
            em.close();
        }
    }

    public List<StudentInfo> getStudentInfo(){
        EntityManager em = emf.createEntityManager();
        List<StudentInfo> studentInfoList = new ArrayList<>();

        try{
            TypedQuery<Object[]> tq = em.createQuery("SELECT s, e FROM Student s join Semester e where s.currentSemesterId = e.id",Object[].class);
            for (Object[] o: tq.getResultList()) {
                Student s = (Student) o[0];
                Semester sem = (Semester) o[1];
                StudentInfo si = new StudentInfo(s.getFirstname()+" "+s.getLastname(),s.getId(),sem.getName(),sem.getDescription());
                studentInfoList.add(si);
            }
            return studentInfoList;
        } finally {
            em.close();
        }
    }

    public StudentInfo getStudentInfoById(int id) {
        EntityManager em = emf.createEntityManager();

        try{
            TypedQuery<Object[]> tq = em.createQuery("SELECT s, e FROM Student s join Semester e where s.currentSemesterId = e.id and s.id=:id",Object[].class);
            tq.setParameter("id",id);
            tq.getSingleResult();
            Student s = (Student) tq.getSingleResult()[0];
            Semester sem = (Semester) tq.getSingleResult()[1];
            StudentInfo studentinfo = new StudentInfo(s.getFirstname()+" "+s.getLastname(),s.getId(),sem.getName(),sem.getDescription());
            return studentinfo;
        } finally {
            em.close();
        }
    }

    /*

    public Employee createEmployee(String firstName, String lastName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) {
        Employee e = new Employee(firstName, lastName, extension, email, officeCode, reportsTo, jobTitle);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return e;
    }

    public Customer findCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> tq = em.createQuery("SELECT c FROM Customer c WHERE c.customerNumber=:id", Customer.class);
            tq.setParameter("id", id);
            Customer c = tq.getSingleResult();
            return c;

        } finally {
            em.close();
        }

    }

    public void updateCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public int getEmployeeCount() {
        EntityManager em = emf.createEntityManager();

        try {
            Query q1 = em.createQuery("SELECT COUNT(e) FROM Employee e");
            long count = (long) q1.getSingleResult();
            return (int) count;
        } finally {
            em.close();
        }
    }*/

}
