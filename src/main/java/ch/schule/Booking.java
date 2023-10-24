package ch.schule;

/**
 * Buchung.
 * @author  Luigi Cavuoti
 * @version  2.0
 */
public class Booking
{
	/**
	 * Datum der Transaktion (Banktage seit 1.1.1970).
	 *
	 */
	private final int date;

	/**
	 * Transaktionsbetrag (Millirappen).
	 *
	 */
	private final long amount;

	/**
	 * Erzeugt eine neue Buchung
	 * @param date int
	 *      Datum der Transaktion (Banktage seit 1.1.1970)
	 * @param amount long
	 *      Transaktionsbetrag (Millirappen)
	 */
	public Booking(int date, long amount)
	{
		this.date = date;
		this.amount = amount;
	}

	/**
	 * Gibt das Datum der Buchung zur�ck.
	 * @return  int Datum (Banktage seit 1.1.1970)
	 *
	 */
	public int getDate()
	{
		return date;
	}

	/**
	 * Gibt den Betrag zur�ck.
	 * @return  long Betrag (in Millirappen)
	 *
	 */
	public long getAmount()
	{
		return amount;
	}

	/**
	 * Druckt die Buchungszeile
	 */
	public void print(long balance)
	{
		System.out.println(BankUtils.formatBankDate(date)
			+ " " + BankUtils.formatAmount(amount)
			+ " " + BankUtils.formatAmount(balance + amount));
	}
}
