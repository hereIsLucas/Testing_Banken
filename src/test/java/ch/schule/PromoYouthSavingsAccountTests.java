package ch.schule;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author Luigi Cavuoti
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests
{
	/**
	 * Der Test des Bonus
	 */
	@Test
	@DisplayName("Constructs a PromoYouthSavingsAccount and tests a simple deposit")
	public void test(){
		PromoYouthSavingsAccount promoYouthSavingsAccount = new PromoYouthSavingsAccount("Y-1000");
		Assertions.assertTrue(promoYouthSavingsAccount.deposit(20130820,100));
	}
}
