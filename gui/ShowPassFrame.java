package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import commands.DisplayPassengersCommand;

/**
 * The frame to display all passengers in the system. 
 */
public class ShowPassFrame extends JFrame 
{
	 /*
	  * Display all the passengers in the system. 
	  */
	public ShowPassFrame()
	{
		setTitle("Display Passengers");
		setSize(300, 400);
		
		/* Use a scroll pane to display the flights in case there are too
		 * many to display in the frame. */
		DisplayPassengersCommand displayPassCmd = new DisplayPassengersCommand();
		JTextArea passText = new JTextArea(displayPassCmd.getPassengersString());
		passText.setEditable(false);
		JScrollPane passPane = new JScrollPane(passText);
		add(passPane);
		setVisible(true);
	}

	public static final long serialVersionUID = 1;
}
