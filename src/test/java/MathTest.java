import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    void testPerkalian(){
        int kali = 2 * 8;
        Assertions.assertEquals(16, kali);
    }

    @Test
    void testString(){
        String hello = "hello bell";
        Assertions.assertEquals("hello bell", hello);
    }

    @Test
    void testA(){
        String a = "hello world";
        String b = "hello world";
        Assertions.assertSame(a,b, "what is this");
    }
}