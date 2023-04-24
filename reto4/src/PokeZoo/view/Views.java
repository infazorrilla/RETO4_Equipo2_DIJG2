package PokeZoo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Views {

	private JFrame frame;
	
	private JPanel panelWelcome = null;
	private JPanel panelMain = null;

	/**
	 * Create the application.
	 */
	public Views() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelWelcome = new JPanel();
		panelWelcome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToPanelMain();
			}			
		});
		panelWelcome.setBounds(0, 0, 81, 53);
		panelWelcome.setVisible(true);
		frame.getContentPane().add(panelWelcome);
		panelWelcome.setLayout(null);
		
		JLabel lblWelcome = new JLabel("¡¡ Bienvenido !!");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWelcome.setBounds(280, 149, 170, 105);
		panelWelcome.add(lblWelcome);
		
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 734, 461);
		panelMain.setVisible(false);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Logo.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(654, 11, 70, 71);
		panelMain.add(lblLogo);
	}
	
	
	// TODO CREATED METHODS
	private void changeToPanelMain() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(true);
	}
}
