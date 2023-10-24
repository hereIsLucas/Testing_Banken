package ch.schule;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class SalaryAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	@DisplayName("Constructs a SalaryAccount and tests a simple deposit")
	public void test() {
		SalaryAccount salaryAccount = new SalaryAccount("P-1000",-80);
		assertTrue(salaryAccount.deposit(20130820,1000));
	}
}
