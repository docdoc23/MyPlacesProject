package standAloneboundary;

import constants.Constants;
import entity.Utente;
import standAlonecontrol.ControlloreProfiloAmministratore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;


public class BoundaryFallimento {
	


	//Pannelli
	
	
	public JPanel pannelloInsuccesso;
	public JPanel panelTitolo = new JPanel();
	public JPanel panelButtonHome = new JPanel();
	
	//Label
	public JLabel titolo = new JLabel();
	
	//Bottone
	public JButton bHome; 
	
	// Ascoltatore di bottone e relativa azioni
	private HomeAA ascoltatoreEtAzioneHome;
	
	String errore;

	private ControlloreProfiloAmministratore cp;
	
	public BoundaryFallimento(String errore)
	{
        this.cp = new ControlloreProfiloAmministratore();
        Utente utente = cp.ottieniUtente(
                System.getProperty(Constants.USER_KEY));

        Locale langLocale;
        if (utente != null) {
            langLocale = utente.getLingua();
        } else {
            langLocale = Locale.getDefault();
        }

        ResourceBundle bundle = ResourceBundle
                .getBundle(Constants.PACKAGE_LANGUAGE, langLocale);

		this.errore = errore;
		int border = 5;
		
		pannelloInsuccesso = new JPanel();
		
		pannelloInsuccesso.setSize(BoundaryAvvio.Confine.getWidth(), BoundaryAvvio.Confine.getHeight());
		BoundaryAvvio.Confine.add(pannelloInsuccesso);
		pannelloInsuccesso.setLayout(null);
		
        panelTitolo.setLayout(null);
        panelTitolo.setSize(BoundaryAvvio.Confine.getWidth(), 45);
        panelTitolo.setLocation(5, 5);  
        panelTitolo.add(titolo);
        
        titolo.setFont(new Font("Verdana", Font.BOLD, 20));
        titolo.setLocation(border, border);
        titolo.setSize(panelTitolo.getWidth(), 35);
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titolo.setVerticalAlignment(JLabel.CENTER);

        titolo.setText(errore);
        
        pannelloInsuccesso.add(panelTitolo);	
        
		panelButtonHome.setLayout(null);
		panelButtonHome.setSize(BoundaryAvvio.Confine.getWidth(), 150);
		panelButtonHome.setLocation(5, 30);

		
		bHome = new JButton(bundle.getString("logout_home"));
		bHome.setLocation(300,100);
		bHome.setSize(panelTitolo.getWidth()/3,50);
		bHome.setFont(new Font("Arial", 0, 20));
		bHome.setToolTipText("Torna alla Home"); 
		
		panelButtonHome.add(bHome);
        	
		pannelloInsuccesso.add(panelButtonHome);
		
	  	
					
		// Ascoltatore di bottone e relativa azione
		ascoltatoreEtAzioneHome = new HomeAA();
		
		
		// Associazione di bottone a relativo ascoltatore
		bHome.addActionListener(ascoltatoreEtAzioneHome);
		
	}
	// Fine costruttore
	
	//Ascoltatore
	
	private class HomeAA implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{				
			try 
			{
				pannelloInsuccesso.setVisible(false);
				new BoundaryAmministrazione();
				
			} 
			catch (Exception e) 
			{				
				e.printStackTrace();					
			}
		}
	}


}
