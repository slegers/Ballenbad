package deel2.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import deel2.domain.BallenVeld;

public class BesturingsPanelBal extends JPanel{
	//elke bal kan 4 snelheiden hebben (1=zeer snel- 4=zeer traag
	private final static int MAX_SNELHEID =1;
	private final static int MIN_SNELHEID =4;
	private final static int START_SNELHEID =1;
	//elke bal kan volgende banen hebben
	private static final String[] banen = {"horizontaal","verticaal"};
		
	private JSpinner snelheidControl;
	private JComboBox<String> baanControl;
	
	private BallenVeld ballenVeld;
	private int balNr;
	
	public BesturingsPanelBal(BallenVeld ballenVeld, Color achterGrondKleur,int balNr){//Bal bal){
		this.ballenVeld = ballenVeld;
		this.balNr  = balNr;
		this.setBackground(achterGrondKleur);
		this.setBorder(BorderFactory.createMatteBorder( 3, 3, 3, 3, Color.darkGray));

		this.setLayout(new GridLayout(5,1));
		//spinner voor snelheid bal te selecteren
		SpinnerModel spinnerModel = new SpinnerNumberModel(START_SNELHEID, //initial value
		         MAX_SNELHEID, //min
		         MIN_SNELHEID, //max
		         1);//step
		snelheidControl = new JSpinner(spinnerModel);
		
		 this.add(new JLabel("Snelheid bal"));
		 this.add(snelheidControl);
		
		 //combox voor baan (richting) bal te selecteren
		 baanControl = new JComboBox<String>(banen);
		
		 this.add(new JLabel("Baan bal"));
		 this.add(baanControl);
	}
}
