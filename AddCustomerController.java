package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Entità.Customer;
import model.util.CustomerHandler;
import view.resultPanels.AddCustomerPanel;


public class AddCustomerController implements ActionListener
{
	private AddCustomerPanel view;
	private CustomerHandler model;
	
	
	public CustomerHandler getCustomerModel()
	{
		return model;
	}
	
	public AddCustomerController(AddCustomerPanel view, CustomerHandler model)
	{
		this.view = view;
		this.model = model;
		view.attachController(this);
		view.setup();
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//e.getSource() instanceof JRadioButton ?
		
		JTextField[] tfs = view.getTFields();
		String[] fields = new String[tfs.length];
		int i=0;
		
		for(JTextField tf : tfs)
		{
			fields[i] = tf.getText();
			i++;
		}
		
		//FIXARE gli ultimi 3
		/*
		 * COME?
		 */
		Customer c = new Customer(fields[0], fields[1], fields[2], fields[3], fields[4], true, false, true);
		
		model.addSQLCustomer(c);
		
		for(JTextField tf : tfs)
		{
			tf.setText("");
		}
	}
	
	
	
	
	
	
}
