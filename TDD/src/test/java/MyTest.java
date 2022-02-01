import facade.greetingClass;
import facade.myNonExistingClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @BeforeEach
    void setUp() {
        greetingClass greetingClass = new greetingClass();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void myTest(){
        myNonExistingClass myNonExistingClass = new myNonExistingClass();
        String actual = myNonExistingClass.greeting();
        String expected = "hello";
        assertEquals(actual,expected);
    }
    @Test
    public void greetingOneNameTest(){
       // String[] names=new String[]{"Jill","Jane"};
        String name="";
        String actual=greetingClass.greet(name);
        String expected;
        if(name.isEmpty()){
            expected = "Hello, my friend.";
        }else {
            expected = "Hello, " + name + ".";
        }
        if(name.toUpperCase().equals(name) && !name.isEmpty()){
            expected="HELLO "+name+"!";
        }
        System.out.println(expected);
        assertEquals(actual,expected);
    }

    @Test
    public void greetingMultipleNamesTest(){
        String[] names=new String[]{"Amy", "Brian", "Charlotte"};
        String actual=greetingClass.greetMultiple(names);
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!";
        System.out.println(actual);
        assertEquals(actual,expected);
    }
}
