package PokeZoo.view.IndividualPanels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import javax.swing.JScrollPane;

import PokeZoo.view.Views;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mapa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mapa window = new mapa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mapa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(10, 111, 714, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMapa = new JLabel("labelMapa");
		lblMapa.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Desktop\\PokemonMap.png"));
		lblMapa.setBounds(30, 86, 636, 178);
		frame.getContentPane().add(lblMapa);
		
		JLabel lblPokemonQuestion = new JLabel("¿Que Pokemon estas Buscando? :");
		lblPokemonQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPokemonQuestion.setBounds(30, 28, 278, 22);
		frame.getContentPane().add(lblPokemonQuestion);
		
		TextField textFieldAllPokemons = new TextField();
		textFieldAllPokemons.setBounds(329, 28, 222, 22);
		frame.getContentPane().add(textFieldAllPokemons);
		
		JButton btnMapSearch = new JButton("Buscar");
		btnMapSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldAllPokemons.getText().equals("charizard")) {
					lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("C:\\Users\\in1dw3\\Desktop\\PokemonMap.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
				}
			}	
		});
		btnMapSearch.setBounds(577, 28, 89, 23);
		frame.getContentPane().add(btnMapSearch);
		
		
		
	
	}
}
