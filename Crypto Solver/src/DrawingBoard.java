import javax.swing.*;

import static java.lang.System.out;

import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author scrotumsimon
 * The purpose of this program is to accept words and convert it to a shifted alphabetical order
 * it can also take the encrypted sentences and revert it back to normal as well.
 *(Continuing Project, Status: Halt)
 *
 */
public class DrawingBoard extends JPanel 
{	// declared objects
	JButton enter, clear;
	JTextArea input, output;
	JScrollPane scroll_input, scroll_output;
	CeaserShift CS_tool;
	
	public DrawingBoard()	// constructor that puts all the functionalities into one method
	{
		this.setLayout(null);	// sets the default layout (flow layout)
		
		String[] CipherStrings = { "CeaserShift" };		// names of each drop down option, reusable
		
		JComboBox CipherList = new JComboBox(CipherStrings);	// takes in the str array and display
		CipherList.setSelectedIndex(0);
		CipherList.setBounds(280, 30, 140, 30);
		add(CipherList);	// any "add" will result in adding to the frame 
		
		input = new JTextArea(10, 10);		// created two textfields, one for input and the other for output
		input.setFont(new Font("Tahoma", Font.PLAIN, 20));		// when the user types in input, this is where it is taken
		input.setLineWrap(true);
		add(input);
		
		output = new JTextArea(10, 10);
		output.setFont(new Font("Tahoma", Font.PLAIN, 20));
		output.setLineWrap(true);
		output.setEditable(false);
		add(output);
		
		scroll_input = new JScrollPane(input);		// this component allows the textfield to be scrollable as well as borders
		scroll_input.setBounds(50, 100, 200, 300);
		add(scroll_input);
		
		scroll_output = new JScrollPane(output);
		scroll_output.setBounds(450, 100, 300, 300);
		add(scroll_output);
		
		enter = new JButton("Enter");	// JButtons, enter and clear that takes the user actions 
		enter.setBounds(290, 150, 120, 80);
		enter.setFont(new Font("Tahoma", Font.BOLD, 20));
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)		// when clicked, it runs the object class methods
			{
				CS_tool = new CeaserShift(input.getText());
				output.setText(CS_tool.multiply());
			}
		});
		add(enter);
		
		clear = new JButton("Clear");
		clear.setBounds(290, 250, 120, 80);
		clear.setFont(new Font("Tahoma", Font.BOLD, 20));
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				input.setText("");
				output.setText("");
			}
		});
		add(clear);
		
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Cipher Tools");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new DrawingBoard());
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.isOpaque();
		frame.setResizable(false);
		
	}

}
