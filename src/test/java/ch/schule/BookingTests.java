package ch.schule;

import ch.schule.Booking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests
{
	/**
	 * Tests f�r die Erzeugung von Buchungen.
	 */
	@Test
	@DisplayName("Construct Simple Booking, should work ")
	public void testInitialization() {
		Booking myBooking = new Booking(20130820,100);
		assertEquals(20130820, myBooking.getDate());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	@DisplayName("Not a real test, it prints a list of bookings")
	public void testPrint()
	{
		Booking myBooking = new Booking(20130820, 100);
		myBooking.print(100);
	}
}
