import org.example.Kalkulator;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    void testStudent(){
        Student student1 = new Student("Belda", 7, true);
        Assertions.assertTrue(student1.isDoingMBKM());
    }

}
