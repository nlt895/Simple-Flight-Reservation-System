package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import commands.DisplayFlightsCommand;

/**
 * The frame to display all flights in the system. 
 */
public class ShowFlightsFrame extends JFrame 
{
	 /*
	  * Display all the flights in the system. 
	  */
	public ShowFlightsFrame()
	{
		setTitle("Display Flights");
		setSize(300, 500);
		
		/* Use a scroll pane to display the flights in case there are too
		 * many to display in the frame. */
		DisplayFlightsCommand displayFlightsCmd = new DisplayFlightsCommand();
		JTextArea flightsText = new JTextArea(displayFlightsCmd.getFlightsString());
		flightsText.setEditable(false);
		JScrollPane flightsPane = new JScrollPane(flightsText);
		add(flightsPane);
		setVisible(true);
	}
	
	public static final long serialVersionUID = 1;
}
