package deel4.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import deel4.domain.BallenVeld;

public class KnoppenPanel extends JPanel{
	private JButton knop;
	private JLabel aantalMogelijkeBallenLabel;
	
	public KnoppenPanel(BallenVeld ballenVeld){
		this.setBorder(BorderFactory.createMatteBorder( 3, 3, 3, 3, Color.darkGray));
		this.setLayout(new GridLayout(4,1));
		knop = new JButton("Herstart animatie");
		knop.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		//als op de knop geklikt wordt zal het ballenveld leeggemaakt worden
		knop.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 ballenVeld.init();
	         }
		});     
		this.add(knop);
		this.add(new JLabel("Om bal toe tevoegen: "));
		this.add(new JLabel("Klik met muis in ballenveld"));
		String tekst= ballenVeld.getAantalMogelijkeBallen()==1? "1 bal toegelaten":ballenVeld.getAantalMogelijkeBallen()+ " ballen toegelaten";
		aantalMogelijkeBallenLabel = new JLabel();
		aantalMogelijkeBallenLabel.setText(tekst);
		aantalMogelijkeBallenLabel.setForeground(Color.RED);
		this.add(aantalMogelijkeBallenLabel);		
	}

}
