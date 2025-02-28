import org.example.Kalkulator;
import org.junit.jupiter.api.*;

public class KalkulatorTest {
    @Test
    void testTambahDefault(){
        int a = 10;
        int b = 15;
        Kalkulator calc = new Kalkulator(a,b);
        Assertions.assertEquals(25,calc.tambah(), "Equals Tambah");
    }

    @Test
    void testTambahNotNull(){
        int a = 10;
        int b = 15;
        Kalkulator calc = new Kalkulator(a,b);
        Assertions.assertNotNull(calc.tambah());
    }
    @Test
    void testTambahComplete(){
        Kalkulator calc = new Kalkulator(10,15);
        Assertions.assertAll(
                ()-> Assertions.assertEquals(10, calc.a),
                ()-> Assertions.assertEquals(15, calc.b)
        );
    }

    @BeforeAll
    static void setupBeforeAll(){
        System.out.println("before all");
    }

    @BeforeEach
    void setupMethodBeforeEach(){
        System.out.println("before each");
    }

    @AfterEach
    void setupMethodAfterEach(){
        System.out.println("after each");
    }

    @AfterAll
     static void setupMethodAfterAll(){
        System.out.println("after all");
    }

}
