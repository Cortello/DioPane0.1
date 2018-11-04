package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import model.Entità.TipoPane;
import model.util.CalculatorModel;
import view.resultPanels.CalculatorPanel;

public class CalculatorController implements ActionListener, KeyListener
{
	private CalculatorPanel view;
    private CalculatorModel calculatorModel;

	
    public CalculatorModel getCalculatorModel()
    {
    	return calculatorModel;
    }
    
    
    public CalculatorController(CalculatorPanel c)
    {
    	this.view = c;
    	calculatorModel = new CalculatorModel();
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	int length = TipoPane.values().length;
    	int[] qta = new int[length];
        double[] pesi = new double[length];
        JTextField[] qPanelContent = view.getQuantityTxFields();
        JTextField[] wPanelContent = view.getWeightTxFields();
        
        int i = 0;
        while (i < length)
        {
        	String s1 = wPanelContent[i].getText();
            pesi[i] = s1.isEmpty() ? 0.0 : Double.parseDouble(s1);
            String s2 = qPanelContent[i].getText();
            qta[i] = s2.isEmpty() ? 0 : Integer.parseInt(s2);
            i++;
        }
        
       	calculatorModel.setGiorni(Integer.parseInt(view.getDays()));
        double totale = calculatorModel.calcola(qta, pesi);
        view.updateResult(totale);
        
        
        //calculator.setGiorni(Integer.parseInt(calculator.getDays()));
        //double totale = calculator.calcola(qta, pesi);
        //risultatoLabel.setText(new Double(totale).toString());
    }


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
}