package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import commands.AddPassengerCommand;
/**
 * The frame for the entry of information to add a new passenger,
 * and have the passenger included in system.  The frame stays
 * visible while several passengers are added.
 */
public class AddPassFrame extends JFrame 
{
	/**
	 * The label at the top of the window: either shows a greeting
	 * or the error message for the last attempt to add a passenger.
	 */
	JLabel headingLabel;
	
	/**
	 * The text field into which the name of the new passenger is entered.
	 */
	JTextField nameField;
	
	/**
	 * The text field into which the telephone number of the new passenger is entered.
	 */
	JTextField telNumField;
	
	/**
	 * The listener for the press of Enter in a text field.
	 */
	ActionListener fieldListener;
	
	/** 
	 * Build the frame and handle the entry of data for the creation 
	 * of a new passenger.
	 */
	public AddPassFrame()
	{
		/* Initialize the frame and add a panel for the components. */
		setTitle("Add Passenger");
		setSize(500, 350);
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 1));
		
		/*  Create and add a welcome label at the top of the panel. */
		headingLabel = new JLabel("Welcome");
		/* Place the label in another panel  in order to center it. */
		JPanel centeringPanel = new JPanel();
		centeringPanel.add(headingLabel);
		mainPanel.add(centeringPanel);
		
		/* Add the prompt and name field for the new passenger. */
		JPanel namePanel = new JPanel();
		mainPanel.add(namePanel);
		namePanel.add(new JLabel("name"));
		nameField = new JTextField(15);
		namePanel.add(nameField);
		fieldListener = new FieldListener(); 
		nameField.addActionListener(fieldListener);
		
		/* Add the prompt and telephone number field for the new passenger. */
		JPanel telNumPanel = new JPanel();
		mainPanel.add(telNumPanel);
		telNumPanel.add(new JLabel("telephone number"));
		telNumField = new JTextField(12);
		telNumPanel.add(telNumField);
		telNumField.addActionListener(fieldListener);
	}
	
	/**
	 * The ActionListener to respond to the press of Enter in a text field.
	 * Create and add the new passenger using the data in the fields.
	 * If the command fails, place the error message in the label at the top.
	 */
	public class FieldListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AddPassengerCommand addPassCmd = new AddPassengerCommand();
			addPassCmd.addPassenger(nameField.getText(), telNumField.getText());
			if (!addPassCmd.wasSuccessful())
			{
				headingLabel.setText("Error: " + addPassCmd.getErrorMessage());
			}
			else
			{
				nameField.setText("");
				telNumField.setText("");
				headingLabel.setText("Welcome");
			}
		}
	}
	
	public static final long serialVersionUID = 1;
}
