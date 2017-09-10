package deel4.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import com.sun.webkit.dom.KeyboardEventImpl;
import deel4.domain.*;

public class BesturingsPanelBal extends JPanel{
	//elke bal kan 4 snelheiden hebben (1=zeer snel- 4=zeer traag
	private final static int MAX_SNELHEID =1;
	private final static int MIN_SNELHEID =4;
	private final static int START_SNELHEID =1;
	//elke bal kan volgende banen hebben
	private static final String[] banen = {"horizontaal","verticaal", "diagonaal"};
		
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
		//indien nieuwe waarde is geselecteerd in spinner-> zet snelheid bal gelijk aan spinnerwaarde
		snelheidControl.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
		          BewegendeCirkel cirkel = (BewegendeCirkel)ballenVeld.getCirkel(balNr-1);
		          cirkel.setSnelheid(Integer.parseInt(((JSpinner)e.getSource()).getValue().toString()));
		    }
		 });		
		 this.add(new JLabel("Snelheid bal"));
		 this.add(snelheidControl);
		
		 //combox voor baan (richting) bal te selecteren
		 baanControl = new JComboBox<String>(banen);
		//indien nieuwe waarde is geselecteerd in combobox-> zet baan bal gelijk aan geselecteerde baan
		 baanControl.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	        	 if (e.getStateChange() == ItemEvent.SELECTED){
	        		 BewegendeCirkel cirkel = (BewegendeCirkel)ballenVeld.getCirkel(balNr-1);
	        		 IBaan baan  = null;
	        		 if (banen[baanControl.getSelectedIndex()].equals("horizontaal")){
	        			 baan = new HorizontaleBaan(cirkel.getMiddelPunt().getX(),cirkel.getMiddelPunt().getY());
	        		 }
	        		 else{
	        			 if (banen[baanControl.getSelectedIndex()].equals("verticaal")){
		        			baan = new VertikaleBaan(cirkel.getMiddelPunt().getX(),cirkel.getMiddelPunt().getY());
		        		 }else if(banen[baanControl.getSelectedIndex()].equals("diagonaal")){
							 baan = new SchuinBaan(cirkel.getMiddelPunt().getX(),cirkel.getMiddelPunt().getY());
						 }
	        		 }	 
	        		 cirkel.setBaan(baan);
	        	 }	 
	         }
	     });

		 this.add(new JLabel("Baan bal"));
		 this.add(baanControl);
	}
}
