package solida;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Booker {
	private final List<Booking> bookings;
        private Booking currentBooking;
	
	private static enum BookingParams {
		FIRST_NAME, LAST_NAME, START_DATE, END_DATE
	}
	
	public Booker() {
		this.bookings = new ArrayList<>();
	}
	
	private boolean isBookingAvailable(Booking booking) {
		Predicate<Booking> p = b -> (booking.getStartDate().compareTo(b.getStartDate()) >= 0 && 
			booking.getStartDate().compareTo(b.getEndDate()) <= 0) ||
			(booking.getEndDate().compareTo(b.getStartDate()) >= 0 && 
			booking.getEndDate().compareTo(b.getEndDate()) <= 0);
	
		return !bookings.stream().anyMatch(p);
	}
	
	public Boolean book(String bookingInput) throws Exception {
		String[] information = bookingInput.split(Constants.PARAMS_SEPARATOR);
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
		sdf.setLenient(false);
		
		if (information.length != 4)
			throw new Exception(Constants.INVALID_BOOKING_INPUT);
		
		if (information[BookingParams.FIRST_NAME.ordinal()].length() == 0)
			throw new Exception(Constants.INVALID_FIRST_NAME);
		
		if (information[BookingParams.LAST_NAME.ordinal()].length() == 0)
			throw new Exception(Constants.INVALID_LAST_NAME);
		
		Date startDate = sdf.parse(information[BookingParams.START_DATE.ordinal()]);
		Date endDate = sdf.parse(information[BookingParams.END_DATE.ordinal()]);
		
		currentBooking = new Booking(information[0], information[1], startDate, endDate);
		boolean isAvailable = isBookingAvailable(currentBooking);
                
                if (isAvailable)
                    bookings.add(currentBooking);        
                               
		return isAvailable;
	}
        
        public String getCurrentBooking()
        {
            return currentBooking.toString();
        }
}