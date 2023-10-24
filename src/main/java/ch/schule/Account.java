package ch.schule;

import java.util.ArrayList;

/**
 * Konto.
 * @author  Luigi Cavuoti
 * @version  2.0
 */
public abstract class Account
{
	/**
	 * Die Kontonummer (kann auch Buchstaben und Sonderzeichen enthalten).
	 */
	private final String id;

	/**
	 * Kontostand in Millirappen.
	 */
	private long balance;

	/**
	 * Die Buchungen.
	 */
	private final ArrayList<Booking> bookings;

	/**
	 * Erzeugt ein neues Konto.
	 *
	 * @param id die Kontonummer
	 */
	public Account(String id)
	{
		this.id = id;
		this.balance = 0;
		this.bookings = new ArrayList<Booking>();
	}

	/**
	 * Gibt die Kontonummer zur�ck.
	 * @return  die Kontonummer
	 *
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Gibt das Saldo zur�ck.
	 * @return  Saldo
	 */
	public long getBalance()
	{
		return balance;
	}

	public boolean canTransact(int date)
	{
		if (bookings.isEmpty())
			return true;

	    Booking b = (Booking) bookings.get(bookings.size() - 1);

	    return date >= b.getDate();
	}

	/**
	 * Zahlt den gegebenen Betrag aufs Konto ein.
	 *
	 * @param date das Transaktionsdatum
	 * @param amount der einzuzahlende Betrag
	 *
	 * @return boolean <code>true</code>, falls die
	 * Einzahlung erfolgreich war, andernfalls (z.B.
	 * bei negativem Betrag) <code>false</code>.
	 */
	public boolean deposit(int date, long amount)
	{
		if (amount < 0)
			return false;

	    if (!canTransact(date))
			return false;

	    balance += amount;
		bookings.add(new Booking(date, amount));
		return true;
	}

	/**
	 * Hebt den gegebenen Betrag vom Konto ab.
	 *
	 * @param date das Transaktionsdatum
	 * @param amount der abzuhebende Betrag
	 *
	 * @return boolean <code>true</code>, falls die
	 * Abhebung erfolgreich war, andernfalls (z.B.
	 * bei negativem Betrag) <code>false</code>.
	 */
	public boolean withdraw(int date, long amount)
	{
		if (amount < 0)
			return false;

		if (!canTransact(date))
			return false;

	    balance -= amount;
		// Achtung: hier Buchung mit negativem Betrag!
		bookings.add(new Booking(date, -amount));
		return true;
	}

	/**
	 * Druckt den Kontoauszug dieses Kontos.
	 */
	public void print()
	{
		System.out.println("Kontoauszug '" + id + "'");
		System.out.println("Datum          Betrag      Saldo");

	    long balance = 0;

	    for (int i = 0; i < bookings.size(); ++i)
		{
			Booking b = (Booking) bookings.get(i);

		    b.print(balance);
			balance += b.getAmount();
		}
	}

	/**
	 * Druckt den Monats-Kontoauszug dieses Kontos.
	 *
	 * @param year das Jahr
	 * @param month der Monat
	 */
	public void print(int year, int month)
	{
		System.out.println("Kontoauszug '" + id + "' "
			+ "Monat: " + month + "." + year);
	    System.out.println("Datum          Betrag      Saldo");

	    int startDate = (year - 1970) * 360
			+ (month - 1) * 30;
		int endDate = startDate + 30;
		long balance = 0;

		for (int i = 0; i < bookings.size(); ++i)
		{
			Booking b = (Booking) bookings.get(i);

			if (b.getDate() >= endDate)
				break; // Fertig, aus der Schleife springen

			if (b.getDate() >= startDate)
				b.print(balance);

		    balance += b.getAmount();
		}
	}


}
