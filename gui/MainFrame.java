package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The frame to hold the main window of the project.  It displays buttons 
 * to add a passenger, add a flight, list all passengers, list all flights,
 * and exit the project.  There is also a prompt and text field for the 
 * entry of the number of a flight, upon which operations are performed.
 */
public class MainFrame extends JFrame 
{
	/**
	 * The text field into which a flight number is entered in order
	 * to apply operations on the flight. 
	 */
	JTextField flightNumField;
	
	/**
	 * Build and display the frame to contain the buttons and the text field.
	 */
	public MainFrame()
	{
		/* Initialize the frame and a panel within it to hold the
		 * components of the window. */
		setTitle("Flight Reservation System");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		/* Add the button to add a passenger. */
		mainPanel.add(Box.createVerticalGlue());
		JButton addPassButton = new JButton("Add passenger");
		mainPanel.add(addPassButton);
		addPassButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addPassButton.addActionListener(new AddPassListener());
		
		/* Add the button to display all passengers. */
		mainPanel.add(Box.createVerticalGlue());
		JButton showPassButton = new JButton("Show all passengers");
		mainPanel.add(showPassButton);
		showPassButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		showPassButton.addActionListener(
				new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							ShowPassFrame showPassFrame = new ShowPassFrame();
							showPassFrame.setLocation(200, 200);
							showPassFrame.setVisible(true);
						}
					}
				);
	
		/* Add the button to add a flight. */
		mainPanel.add(Box.createVerticalGlue());
		JButton addFlightButton = new JButton("Add flight");
		mainPanel.add(addFlightButton);
		addFlightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addFlightButton.addActionListener(
				new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							AddFlightFrame addPassFrame = new AddFlightFrame();
							addPassFrame.setLocation(200, 200);
							addPassFrame.setVisible(true);;
						}
					}
				);
		
		/* Add the button to display all flights. */
		mainPanel.add(Box.createVerticalGlue());
		JButton showFlightsButton = new JButton("Show all flights");
		mainPanel.add(showFlightsButton);
		showFlightsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		showFlightsButton.addActionListener(
				new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							ShowFlightsFrame showFlightsFrame = new ShowFlightsFrame();
							showFlightsFrame.setLocation(200, 200);
							showFlightsFrame.setVisible(true);
						}
					}
				);
	
		/* Add the prompt and text field for the entry of the number
		 * for a flight upon which operations are to be done. */
		mainPanel.add(Box.createVerticalGlue());
		JPanel handleFlightPanel = new JPanel();
		mainPanel.add(handleFlightPanel);
		handleFlightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		handleFlightPanel.add(new JLabel("Process flight"));
		flightNumField = new JTextField(6);
		handleFlightPanel.add(flightNumField);
		flightNumField.addActionListener(new FlightNumFieldListener());
		
		/* Add the button to quit the project. */
		mainPanel.add(Box.createVerticalGlue());
		JButton quitButton = new JButton("Quit");
		mainPanel.add(quitButton);
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.addActionListener(
				new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							System.exit(0);
						}
					}
				);
		mainPanel.add(Box.createVerticalGlue());
	}
	
	/**
	 * The inner class for the ActionListener to response to the press
	 * of the button to add a passenger.  The action is to create and
	 * display the window for the entry of passengers.
	 */
	private class AddPassListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AddPassFrame addPassFrame = new AddPassFrame();
			addPassFrame.setLocation(200, 200);
			addPassFrame.setVisible(true);;
		}
	}
	
	/**
	 * The inner class for the ActionListener to response to the press
	 * of the Enter key in the field for the entry of a flight number.  
	 * The action is to create and display the window handle the flight;
	 * book passengers, assign seats, etc.
	 */
	class FlightNumFieldListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int number = 0;
			try
			{
				number = Integer.parseInt(flightNumField.getText());
			} catch (Exception ex)
			{
				flightNumField.setText(flightNumField.getText() + ": invalid");
				return;
			}
			HandleFlightFrame handleFlightFrame = new HandleFlightFrame(number);
			handleFlightFrame.setLocation(200, 200);
			handleFlightFrame.setVisible(true);
			flightNumField.setText("");
		}
	}
	
	public static final long serialVersionUID = 1;
}
