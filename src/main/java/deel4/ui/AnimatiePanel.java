package deel4.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import deel4.domain.BallenVeld;
import deel4.domain.Cirkel;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AnimatiePanel extends JPanel{
	private final BallenVeld ballenVeld;
	public AnimatiePanel(BallenVeld ballenVeld){
		this.ballenVeld = ballenVeld;
		this.setBackground(ballenVeld.getAchtergrondKleur());
		this.setBorder(BorderFactory.createMatteBorder( 3, 3, 3, 3, Color.darkGray));
		//als we met de muis klikken in het animatiepanel wordt er een bal toegevoegd aan ballenveld
		//met middelpunt gelijk aan geklikt punt
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				ballenVeld.voegCirkelToe(event.getX(),event.getY());
				repaint();				
			}
		}
		);
		addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if(e.getKeyChar() =='n')
                    ballenVeld.voegCirkelToeViaKeyBoard();
                repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
		gameStart();
	}
	
	public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (Cirkel cirkel:ballenVeld.getCirkels()){
			cirkel.teken(g);
		}
	}
	
	public void gameStart(){
		 Thread gameThread = new Thread() {
	         public void run() {
	            while (true) {
	               // Execute one time-step for the game 
	               gameUpdate();
	               // Refresh the display
	               repaint();
	               // Delay and give other thread a chance
	               try {
	            	  //Om de 4 milliseconden zal het animatiepanel hertekend worden 
	                  Thread.sleep(4);
	               }
	               catch (InterruptedException ex) {System.out.println(ex.getMessage());}
	            }
	         }
	      };
	      gameThread.start();  // Invoke 
	}
	
	public void gameUpdate(){
		try{
			for (Cirkel cirkel:ballenVeld.getCirkels()){
				cirkel.beweeg();
			}
		}
		catch (Exception e){System.out.println(e.getMessage());}
	}
}
