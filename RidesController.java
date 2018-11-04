package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.util.CustomerHandler;
import view.resultPanels.RidePanel;

public class RidesController implements ActionListener
{
	
	//MVC
	private RidePanel view;
	private CustomerHandler model;
	
	
	
	
	
	
	
	public RidesController(RidePanel view, CustomerHandler model)
	{
		this.view = view;
		this.model = model;
		view.attachController(this);
		view.setup();
	}
	
	
	public Vector<String> getGiri()
	{
		
		return model.selectAllRidesNames();
	}
	
	public Vector<String> getFullRide(String name)
	{
		return model.getFullRide(name);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() instanceof JButton)
		{
			JButton jb = (JButton) e.getSource();
			String btn = jb.getText();
			
			switch (btn)
			{
				case "Nuovo giro":
					model.addNewRide(view.toggleInsertDialog("Inserisci nome:"),
									 Integer.parseInt(view.toggleInsertDialog("Inserisci il giorno della settimana:")));
					break;
				
				case "Rimuovi":
					model.removeRide(view.toggleInsertDialog("Inserisci nome:"));
					break;
				
				case "Aggiungi Cliente":
					////////////
					break;
				
				case "Rimuovi Cliente":
					///////////
					break;
				
				case "Modifica":
					/////////////
					break;
					
				case "Stampa giro":
					model.printRide(view.toggleInsertDialog("Inserisci nome:"));
					break;
					
				case "Stampa Etichette":
					/////////////model.printLabel
					break;
			}
		}
		else if(e.getSource() instanceof JComboBox)
		{
			JComboBox<String> combo = (JComboBox<String>) e.getSource();
			String selected = combo.getSelectedItem().toString();
			view.showRide(selected);
		}
	}
	
	
	
	
	
	
	
	
}
