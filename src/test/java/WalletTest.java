import org.example.Wallet;
import org.junit.jupiter.api.*;
import java.util.List;

public class WalletTest {
    private static Wallet wallet;

    @BeforeAll
    static void initializeWallet() {
        wallet = new Wallet();
    }

    @BeforeEach
    void prepareWalletForTest() {
        wallet.setOwner("Belda");
        wallet.addCard("KTM");
        wallet.addCard("BRI");
        wallet.addMoney(50000);
        wallet.addMoney(1000);
        wallet.addMoney(500);
    }

    @Test
    void verifyWalletInitialization() {
        Wallet newWallet = new Wallet();
        Assertions.assertNull(newWallet.getOwner(), "Owner should be null when wallet is newly created");
        Assertions.assertNotNull(newWallet.getCards(), "Card list should not be null initially");
        Assertions.assertTrue(newWallet.getCards().isEmpty(), "Card list should be empty initially");
    }

    @Test
    void checkAddingCards() {
        List<String> cards = wallet.getCards();
        Assertions.assertAll(
                () -> Assertions.assertFalse(cards.isEmpty(), "Card list should not be empty after adding cards"),
                () -> Assertions.assertEquals(2, cards.size(), "The number of cards should be exactly 2"),
                () -> Assertions.assertEquals("KTM", cards.get(0),
                        "First card should be KTM"),
                () -> Assertions.assertEquals("BRI", cards.get(1), "Second card should be BRI")
        );
    }

    @Test
    void validateAddingMoney() {
        Assertions.assertEquals(51500, wallet.getTotalMoney(), "Total balance should match the added amounts");
    }

    @Test
    void verifyMoneyWithdrawal() {
        boolean result = wallet.withdrawMoney(51000);
        Assertions.assertTrue(result, "Withdrawal should succeed if sufficient balance is available");
        Assertions.assertEquals(500, wallet.getTotalMoney(), "Remaining balance should be correct after withdrawal");
    }

    @AfterEach
    void resetWalletAfterTest() {
        wallet = new Wallet(); // Reset wallet state after each test
    }

    @AfterAll
    static void cleanUpWallet() {
        wallet = null;
    }
}


//public class WalletTest {
//
//    @Test
//    void testWalletDefault() {
//        Wallet bell = new Wallet();
//        Assertions.assertNull(bell.getOwner(), "Pemilik harus null saat pertama dibuat");
//        Assertions.assertNotNull(bell.getCards(), "List kartu tidak boleh null saat pertama dibuat");
//        Assertions.assertTrue(bell.getCards().isEmpty(), "List kartu harus kosong saat pertama dibuat");
//    }
////
////    @Test
////    void testSetOwner() {
////        Wallet bell = new Wallet();
////        bell.setOwner("Belda");
////        Assertions.assertNotNull(bell.getOwner(), "Pemilik tidak boleh null setelah diatur");
////        Assertions.assertEquals("Belda", bell.getOwner(), "Pemilik harus sesuai dengan yang diatur");
////    }
////
//    @Test
//    void testAddCard() {
//        Wallet bell = new Wallet();
//        bell.addCard("KartuTandaMahasiswa");
//        bell.addCard("ATMBRI");
//
//        List<String> cards = bell.getCards();
//        Assertions.assertAll(
//                () -> Assertions.assertFalse(cards.isEmpty(), "List kartu tidak boleh kosong setelah ditambahkan"),
//                () -> Assertions.assertEquals(2, cards.size(), "Jumlah kartu harus 2"),
//                () -> Assertions.assertEquals("KartuTandaMahasiswa", cards.get(0), "Kartu pertama harus Visa"),
//                () -> Assertions.assertEquals("ATMBRI", cards.get(1), "Kartu kedua harus MasterCard")
//        );
//    }
////
////    @Test
////    void testAddCardComplete() {
////        Wallet bell = new Wallet();
////        bell.setOwner("Belda");
////        bell.addCard("KartuBPJS");
////
////        Assertions.assertAll(
////                () -> Assertions.assertNotNull(bell.getOwner(), "Pemilik tidak boleh null"),
////                () -> Assertions.assertEquals("Belda", bell.getOwner(), "Pemilik harus Belda"),
////                () -> Assertions.assertFalse(bell.getCards().isEmpty(), "List kartu tidak boleh kosong"),
////                () -> Assertions.assertEquals(1, bell.getCards().size(), "Jumlah kartu harus 1"),
////                () -> Assertions.assertSame("KartuBPJS", bell.getCards().get(0), "Kartu pertama harus Visa")
////        );
////    }
//
//    @Test
//    void testAddMoney() {
//        Wallet bell = new Wallet();
//        bell.addMoney(50000);
//        bell.addMoney(1000);
//        bell.addMoney(500);
//        Assertions.assertEquals(51500, bell.getTotalMoney(), "Total saldo harus sesuai dengan uang yang ditambahkan");
//    }
//
//    @Test
//    void testWithdrawMoney() {
//        Wallet bell = new Wallet();
//        bell.addMoney(50000);
//        bell.addMoney(1000);
//        bell.addMoney(500);
//        boolean result = bell.withdrawMoney(51000);
//        Assertions.assertTrue(result, "Penarikan harus berhasil jika saldo cukup");
//        Assertions.assertEquals(500, bell.getTotalMoney(), "Sisa saldo harus sesuai setelah penarikan");
//    }
//}