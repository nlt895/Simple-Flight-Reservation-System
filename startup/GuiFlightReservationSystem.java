package startup;

import javax.swing.JFrame;

import gui.MainFrame;

/**
 * A simple flight reservation system whereby passengers can be created, flights created,
 * and passengers booked on the flights.  First class passengers are given a seat and a meal
 * plan when first entered into the system.  Regular passengers are booked on a flight with 
 * no seat and can later be given a seat.  A graphic user interface is used for input and 
 * output.
 */
public class GuiFlightReservationSystem 
{
	/**
	 * Run the flight reservation system.
	 * @param args not used
	 */
	public static void main(String[] args) 
	{
		MainFrame mf = new MainFrame();
		mf.setLocation(200, 200);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);;
	}

}
