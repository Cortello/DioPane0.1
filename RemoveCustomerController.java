package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.util.CustomerHandler;
import model.util.DBTool;
import model.util.QueryGen;
import view.resultPanels.RemoveCustomerPanel;

public class RemoveCustomerController implements ActionListener 
{
	private final String seiSicuroMSG = "Sei sicuro di voler rimuovere ";
	
	private RemoveCustomerPanel view;
	private CustomerHandler model;
	
	
	public RemoveCustomerController(RemoveCustomerPanel view, CustomerHandler model)
	{
		this.view = view;
		this.model = model;
		view.attachController(this);
		view.setup();
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String name = view.getTxfContent();
		String nomeCognome = model.selectCustomerForName(name);
		
		int i = JOptionPane.showConfirmDialog(null,	 seiSicuroMSG + nomeCognome + "?", "Attenzione!",
											  JOptionPane.YES_NO_OPTION,
											  JOptionPane.INFORMATION_MESSAGE);
		
		if(i == JOptionPane.YES_OPTION)
			model.removeCustomerForName(name);
		else
			JOptionPane.showMessageDialog(null, "Operazione annllata");
	}
}
