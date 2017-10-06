package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import commands.AddFlightCommand;

/**
 * The frame for the entry of information to add a new flight,
 * and have the flight included in system.  The frame includes
 * a quit button to close the window.
 */
public class AddFlightFrame extends JFrame 
{
	/**
	 * The label at the top of the window: either shows a greeting
	 * or the error message for the last attempt to add a flight.
	 */
	JLabel headingLabel;
	
	/**
	 * The text field into which the number of the new flight is entered.
	 */
	JTextField numberField;
	
	/**
	 * The text field into which the width of the new flight is entered.
	 */
	JTextField widthField;
	
	/**
	 * The text field into which the capacity of the new flight is entered.
	 */
	JTextField capacityField;
	
	/** 
	 * Build the frame and handle the entry of data for the creation 
	 * of a new flight.
	 */
	public AddFlightFrame()
	{
		/* Initialize the frame and add a panel for the components. */
		setTitle("Add Flight");
		setSize(300, 350);
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 1));
		
		/*  Create and add a welcome label at the top of the panel. */
		headingLabel = new JLabel("Welcome");
		mainPanel.add(headingLabel);
		
		/* Add the prompt and number field for the new flight. */
		JPanel numberPanel = new JPanel();
		mainPanel.add(numberPanel);
		numberPanel.add(new JLabel("number"));
		numberField = new JTextField(6);
		numberPanel.add(numberField);

		/* Add the prompt and width field for the new flight. */
		JPanel widthPanel = new JPanel();
		mainPanel.add(widthPanel);
		widthPanel.add(new JLabel("width"));
		widthField = new JTextField(3);
		widthPanel.add(widthField);
		
		/* Add the prompt and capacity field for the new flight. */
		JPanel capacityPanel = new JPanel();
		mainPanel.add(capacityPanel);
		capacityPanel.add(new JLabel("capacity"));
		capacityField = new JTextField(3);
		capacityPanel.add(capacityField);
		
		/* Add the button to add the flight to the system, 
		 * and close this window. */
		JButton submitButton = new JButton("Submit");
		JPanel submitSpacer = new JPanel();
		submitSpacer.add(submitButton);
		mainPanel.add(submitSpacer);
		submitButton.addActionListener(new SubmitListener());
	}
	
	/**
	 * The actionListener for the Submit button.
	 * Create the new flight from the data in the fields.
	 * If the creation fails, place the error message in 
	 * label at the top of the window.
	 */
	class SubmitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AddFlightCommand addFlightCmd = new AddFlightCommand();
			int number = 0;
			int width = 0;
			int capacity = 0;
			try
			{
				number = parseInt (numberField.getText(), "number field");
				width = parseInt (widthField.getText(), "width field");
				capacity = parseInt (capacityField.getText(), "capacity field");
			} catch (Exception excep)
			{
				headingLabel.setText(excep.getMessage());
				return;
			}
			addFlightCmd.addFlight(number, width, capacity);
			if (!addFlightCmd.wasSuccessful())
				headingLabel.setText("Error: " 
						+ addFlightCmd.getErrorMessage());
			else
				setVisible(false);
		}
	}
	
	/**
	 * Parse the string parameter to yield an int value.  If an exception occurs,
	 * throw an exception with an error message that uses fieldName to indicate
	 * the field with the error. 
	 * @param intString  the string to be parsed to obtain the int value
	 * @param fieldName  the name of the field with the error
	 * @return   the int value contained in the string intString
	 */
	private int parseInt (String intString, String fieldName)
	{
		int result = 0;
		try
		{
			result = Integer.parseInt(intString);
		} catch (Exception excep)
		{
			throw new RuntimeException("Error: invalid int in " + fieldName + 
					" : " + intString);
		}
		return result;
	}
	
	public static final long serialVersionUID = 1;
}
