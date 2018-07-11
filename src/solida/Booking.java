package solida;

import java.util.Date;

public final class Booking {
	private final String firstName, lastName;
	private final Date startDate, endDate;
	
	public Booking(String firstName, String lastName, Date startDate, Date endDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	public Date getEndDate() {
		return this.endDate;
	} 
        public String toString() {
            return this.firstName + Constants.PARAMS_SEPARATOR + this.lastName;
        }
}