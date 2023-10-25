package ch.schule;

import ch.schule.Bank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author luigicavuoti
 * @version 1.0
 */
public class BankTests {
    @Test
    @DisplayName("Constructor Test, creates two SavingsAccounts")
    public void testCreate() {
        SavingsAccount account1 = new SavingsAccount("S-1010");
        SavingsAccount account2 = new SavingsAccount("S-1011");

        assertNotNull(account1, "First account should not be null");
        assertNotNull(account2, "Second account should not be null");
    }

    @Test
    @DisplayName("Simple deposit on Bank-SavingsAccount should work")
    public void testDeposit() {

        SavingsAccount myAccount = new SavingsAccount("S-1001");
        assertTrue(myAccount.deposit(190813, 418), "true" );
    }


    @Test
    @DisplayName("Simple withdraw on Bank-SavingsAccount should work")
    public void testWithdraw() {

        SalaryAccount myAccount = new SalaryAccount("S-1000", 5000);
        assertFalse(myAccount.withdraw(20130819, 0));
    }

    /**
     * Experimente mit print().
     */
    @Test
    @DisplayName("Not a real test, it prints a list of bookings")
    public void testPrint() {
        SavingsAccount myAccount = new SavingsAccount("S-1000");
        myAccount.deposit(20130819, 418);
        myAccount.withdraw(20130820, 8);
        myAccount.print();
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    @DisplayName("Not a real test, it prints a list of bookings")
    public void testMonthlyPrint() {
        SavingsAccount myAccount = new SavingsAccount("S-1000");
        myAccount.deposit(20130819, 418);
        myAccount.withdraw(20130820, 8);
        myAccount.print(2013,8);
}

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    @DisplayName("Tests the balance of two SalaryAccounts from the Bank")
    public void testBalance() {
        Bank myBank = new Bank();
        myBank.createSalaryAccount(-1000);
        myBank.createSalaryAccount(-1000);
        myBank.deposit("P-1001", 20130820, 100);

        assertEquals(0, myBank.getBalance("P-1000"));
        assertEquals(100, myBank.getBalance("P-1001"));
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    @DisplayName("Tests the List of the top 5 balances")
    public void testTop5() {
        Bank bank = new Bank();

        bank.createSavingsAccount();
        bank.createSavingsAccount();
        bank.createSavingsAccount();
        bank.createSavingsAccount();
        bank.createSavingsAccount();

        bank.deposit("S-1000",20130820,600);
        bank.deposit("S-1000",20130820,500);
        bank.deposit("S-1000",20130820,400);
        bank.deposit("S-1000",20130820,300);
        bank.deposit("S-1000",20130820,200);
        bank.deposit("S-1000",20130820,100);

        bank.printTop5();

}

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    @DisplayName("Tests the List of the bottom 5 balances")
    public void testBottom5() {
        Bank bank = new Bank();

        bank.createSavingsAccount();
        bank.createSavingsAccount();
        bank.createSavingsAccount();
        bank.createSavingsAccount();
        bank.createSavingsAccount();

        bank.deposit("S-1000",20130820,600);
        bank.deposit("S-1000",20130820,500);
        bank.deposit("S-1000",20130820,400);
        bank.deposit("S-1000",20130820,300);
        bank.deposit("S-1000",20130820,200);
        bank.deposit("S-1000",20130820,100);

        bank.printBottom5();
    }

}
