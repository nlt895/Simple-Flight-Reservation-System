package commands;

import entities.Flight;
import containers.FlightSetAccess;

/**	
 * Command to obtain a String that displays the empty seats of a flight.
 */
public class DisplayEmptySeatsCommand extends CommandStatus
{
	/**
	 * The field to store the String displaying the empty seats.
	 */
	private String emptySeatsString;
	
	/**	
	 * Generate a String that displays the empty seats of the Flight 
	 * with number 'number'.  
	 * @param number  the number for the FLight whose empty seats are to be displayed
	 */
	public DisplayEmptySeatsCommand(int number)
	{
		Flight f = FlightSetAccess.dictionary().get(number);
		if (f == null)
		{
			errorMessage = "There is no flight with number " + number;
			successful = false;
		}
		else
		{
			emptySeatsString = f.availableSeats();
			successful = true;
		}
	}
	
	/**
	 * @return the String that contains the display of empty seats
	 * @precond successful
	 */
	public String getEmptySeatsString()
	{
		if (!successful)
			throw new RuntimeException("Cannot access the empty seats display unless" +
					" the previous run of generateEmptySeatsDisplay was successful.");
		return emptySeatsString;
	}
}
