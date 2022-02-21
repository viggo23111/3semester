package facades;

import entities.Student;
import entities.Teacher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class facadeTest {
    Facade facade = new Facade();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllStudentsTest() {
        List<Student> actual = facade.findAllStudents();
        for (Student student : actual) {
            System.out.println(student.getFirstname());
        }
       assertEquals(6,actual.size());
    }

    @Test
    void findStudentsByFirstNameTest() {
        List<Student> actual = facade.findStudentsByFirstName("Anders");
        assertEquals(1,actual.size());
    }

    @Test
    void InsertNewStudentTest() {
        facade.insertNewStudent("Viggo","Larsen",1);
        List<Student> actual = facade.findStudentsByFirstName("Viggo");
        assertEquals(2,actual.size());
    }

    @Test
    void updateStudentSemesterTest() {
        facade.updateStudentSemester(8,2);
        List<Student> actual = facade.findStudentsByFirstName("Viggo");
        assertEquals(2,actual.get(0).getCurrentSemesterId());
    }

    @Test
    void findAllStudentsWithLastNameTest() {
        List<Student> actual = facade.findAllStudentsWithLastName("And");
        assertEquals(2,actual.size());
    }

    @Test
    void findAmountOfStudentInSemesterTest() {
        int actual = facade.findAmountOfStudentInSemester("CLdat-a14e");
        assertEquals(3,actual);
    }



    @Test
    void findAllTeachersTest() {
        List<Teacher> actual = facade.findAllTeachers();
        assertEquals(3,actual.size());
    }

    @Test
    void getStudentCountTest() {
        assertEquals(7,facade.getStudentCount());
    }

    @Test
    void getTeacherWithMostSemestersTest() {
        assertEquals("Lars", facade.getTeacherWithMostSemesters().getFirstname());
    }
    @Test
    void getStudentInfoListTest(){
        assertEquals(7,facade.getStudentInfo().size());
    }
    @Test
    void getStudentInfoByIdTest(){
        assertEquals("Viggo Larsen",facade.getStudentInfoById(8).getFullName());
    }
}