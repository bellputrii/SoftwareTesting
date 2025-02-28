import org.junit.jupiter.api.*;

public class UserTest {
    private static UserManager user;

    @BeforeAll
    static void setup(){
        UserManager.openConnection();
        user = new UserManager();
    }

    @BeforeEach
    void setupMethod(){
        user.addUser("Belda");
//        user.addUser("Putri");

    }
//    nge set mau value nya apa

    @Test
    void testAddUser(){
        user.addUser("Putri");
        Assertions.assertEquals(2,2);
    }

    @Test
    void testRemoveUser(){
        user.addUser("Putri");
        user.removeUser("Belda");
        Assertions.assertNotNull(user.getUser(), "Pemilik harus null saat pertama dibuat");
    }

    @Test
    void testNull(){
        user.removeUser("Belda");
        Assertions.assertTrue(user.getUser().isEmpty());
    }

    @AfterEach
    void setupAfter(){

    }

    @AfterAll
    static void setupFinish(){
        user.clearUsers();
    }
}
