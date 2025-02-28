import org.junit.jupiter.api.*;

public class TransactionTest {
    private static TransactionSystem transactionSystem;

    @BeforeAll
    static void setup(){
        TransactionSystem.openConnection();
        transactionSystem = new TransactionSystem(500000);
    }
// setup semuanya dari awal
    @BeforeEach
    void setupMethod(){
        transactionSystem.resetBalance(500000);
    }

//    biar aman make before each, ga ngebikin urutan, karena masuk ke test deposit maupun testWithdraw pun balance tetep 500k

    @Test
    void testDeposit(){
        transactionSystem.deposit(100000);
        Assertions.assertEquals(600000, transactionSystem.getBalance());
    }

    @Test
    void testWithdraw(){
//        TransactionSystem transactionSystem1 = new TransactionSystem(50000);
//        transactionSystem1.resetBalance(1000000);
        transactionSystem.Withdraw(100000);
        Assertions.assertEquals(400000, transactionSystem.getBalance());
    }

    @AfterEach
    void cleanupMethod(){
        //
    }

    @AfterAll
    static void cleanup(){
        transactionSystem = null;
        TransactionSystem.closeConnection();
    }
}
