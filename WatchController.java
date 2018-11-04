package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Entità.Customer;
import model.util.CustomerHandler;
import view.resultPanels.WatchCustomerPanel;

public class WatchController implements ActionListener
{
	private WatchCustomerPanel view;
	private CustomerHandler model;
	
	
	public WatchController(WatchCustomerPanel view, CustomerHandler model)
	{
		this.view = view;
		this.model = model;
		view.attachController(this);
		view.setup();
	}
	
	
	public Customer[] getCustomers()
	{
		return model.getCustomers();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		view.refreshTable();
	}
	
	
	
}
