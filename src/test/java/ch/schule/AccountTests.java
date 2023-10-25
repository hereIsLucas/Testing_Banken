package ch.schule;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author luigicavuoti
 * @version 2.0
 */
public class AccountTests {
    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    @DisplayName("Simple constructor-Test for SavingsAccount should work")
    public void testInit() {
        SavingsAccount myAccount = new SavingsAccount("hallo");
        assertNotNull(myAccount, "Account object found");
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    @DisplayName("Simple deposit on SavingsAccount should work")
    public void testDeposit() {
        SavingsAccount myAccount = new SavingsAccount("hallo");
        assertTrue(myAccount.deposit(190813, 418), "true" );
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    @DisplayName("Simple withdraw from SalaryAccount should work")
    public void testWithdraw() {
        SalaryAccount myAccount = new SalaryAccount("hallo", 5000);
        assertFalse(myAccount.withdraw(190813, 0));

    }

    @Test
    @DisplayName("TreeMap of two Account-References should work")
    public void testReferences() {
        TreeMap treeMap = new TreeMap<String, Long>();

        SalaryAccount myAccount = new SalaryAccount("0010", 5000);
        SavingsAccount mySavingsAccount = new SavingsAccount("0011");

        treeMap.put(myAccount.getId(), myAccount.getBalance());
        treeMap.put(mySavingsAccount.getId(), mySavingsAccount.getBalance());


        assertNotNull(treeMap.get(myAccount.getId()));
        assertNotNull(treeMap.get(mySavingsAccount.getId()));

    }
    @Test
    @DisplayName("TreeMap of two Account-References should work")
    public void testCanTransact() {
        TreeMap treeMap = new TreeMap<String, Long>();
        TreeMap transactMap = new TreeMap<String, Boolean>();

        SalaryAccount myAccount = new SalaryAccount("0010", 5000);
        SavingsAccount mySavingsAccount = new SavingsAccount("0011");

        transactMap.put(myAccount.getId(), myAccount.canTransact(190813));
        treeMap.put(mySavingsAccount.getId(), mySavingsAccount.getBalance());

        assertEquals(myAccount.canTransact(190813), transactMap.get(myAccount.getId()));
    }

    /**
     * Experimente mit print().
     */
    @Test
    @DisplayName("Not a real test, it prints a list of bookings")
    public void testPrint() {
        SalaryAccount myAccount = new SalaryAccount("hallo", 5000);
        Booking book1 = new Booking(190813, 50);
        Booking book2 = new Booking(190813, 50);
        assertDoesNotThrow(() -> myAccount.print());
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    @DisplayName("Not a real test, it prints a list of bookings")
    public void testMonthlyPrint() {
        SalaryAccount myAccount = new SalaryAccount("hallo", 5000);
        Booking book1 = new Booking(190813, 50);
        Booking book2 = new Booking(190813, 50);
        myAccount.print();
    }

}
