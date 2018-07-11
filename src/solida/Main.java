package solida;

public class Main {

	public static void main(String[] args) {
		String[] bookingsInput = Constants.BOOKINGS_INPUT.split(Constants.LINE_SEPARATOR);
		Booker booker = new Booker();
		boolean bookingsSucceeded = true;
		
		for (String booking : bookingsInput) {
			try {
				if (!booker.book(booking)) {
					bookingsSucceeded = false;
					break;
				}
			} catch(Exception e) {
                            bookingsSucceeded = false;
                            System.out.println(e.getMessage());
			}
		}
		
		if (bookingsSucceeded)
                        System.out.println(Constants.BOOKINGS_SUCCEEDED);
                else
                        System.out.println(booker.getCurrentBooking());
	}
}