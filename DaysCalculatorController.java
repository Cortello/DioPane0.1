package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import model.Entità.BreadMonth;
import model.util.CalculatorModel;
import view.resultPanels.CalculatorPanel;
import view.resultPanels.calculator.DaysCalculatorPanel;

public class DaysCalculatorController implements ItemListener
{
	
	private DaysCalculatorPanel view;
	private CalculatorModel calcModel;
	private BreadMonth breadMonth;
	
	
	
	public DaysCalculatorController(DaysCalculatorPanel view)
	{
		this.view = view;
		calcModel = view.getCalcModel();
		
	}
	
    
	
    @Override
    public void itemStateChanged(ItemEvent arg0)
    {
    	//selection conditions
    	boolean autoCount = view.getAutoCountBox().isSelected();
    	boolean paneDoppio = view.getPaneDoppioBox().isSelected();
    	boolean ciabSegMerc = view.getCiabSegMercoledìBox().isSelected();
    	boolean ciabSegSab = view.getCiabSegSabato().isSelected();
    	
        if (autoCount)
         	view.setInserimentoGiorni("" + new BreadMonth(paneDoppio).getDays());
        else
        	view.setInserimentoGiorni("");
        //se non è auto inserisci tu e sai già quanti giorni sono
        
        if(paneDoppio)
        	calcModel.setPaneDoppio(true);
        else
        	calcModel.setPaneDoppio(false);
       
        if(ciabSegMerc)
        	calcModel.setCiabSegMercole(true);
        else
        	calcModel.setCiabSegMercole(false);
        
        if(ciabSegSab)
        	calcModel.setCiabSegSabato(true);
        else
        	calcModel.setCiabSegSabato(false);
        
        view.setInserimentoGiorni("" + new BreadMonth(paneDoppio).getDays());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
