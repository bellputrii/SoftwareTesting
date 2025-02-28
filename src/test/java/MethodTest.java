import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MethodTest {

    @Test
    void testCobaCoba() {
//        System.out.println("test1");
//        Assertions.assertEquals(5,5);
//        String a = new String("test");
//        String b = new String("test");
//        Assertions.assertEquals(a,b, "Equals Failed");
//        kalo equals kalo value objek sama, maka hasil tetap sama
        String a = new String("Test");
        String b = a;
        Assertions.assertSame(a,b);
//        kalo same nama objek harus benar2 sama

    }


    @Test
    void testCoba2() {
//        System.out.println("test2");
    }

}
