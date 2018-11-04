package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.util.MenuSelector;
import view.ResultPanel;

public class ActionMenuController implements ActionListener
{
	/*
	 * 			Controller per scelta menu, non serve model, 
	 * 													perchè?
	 */
	
	private ResultPanel view;
	private MenuSelector selector;
	
	
	//Getters
	public JButton[] getCustomerActionButtons ()
	{
		return selector.getCustomerActionButtons();
	}
	public JButton[] getOperationActionButtons ()
	{
		return selector.getOperationActionButtons();
	}
	public String[] getCustomerActions()
	{
		return selector.getCustomerActions();
	}
	public String[] getOperationActions()
	{
		return selector.getOperationActions();
	}
	
	
	
	public ActionMenuController(ResultPanel view)
	{
		this.view = view;
		selector = new MenuSelector();
	}
	
	
	
	//		Controllo evento update alla view con pannello scelto
	private void processButtonEvent(String name)
	{
		view.update(selector.selectMenu(name));
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton jb = (JButton) e.getSource();
		processButtonEvent(jb.getText());
	}
	
}
