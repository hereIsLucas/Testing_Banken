package ch.schule;

import ch.schule.SavingsAccount;



/**
 * Tests f�r die Klasse SavingsAccount.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author Luigi Cavuoti
 * @version 1.0
 */
public class SavingsAccountTests
{
	@Test
	@DisplayName("Constructs a SavingsAccount and tests a simple deposit")
	public void test() {
		SavingsAccount savingsAccount = new SavingsAccount("S-1000");
		assertTrue(savingsAccount.deposit(20130820,1000));
	}
}

