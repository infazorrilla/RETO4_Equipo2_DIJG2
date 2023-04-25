package PokeZoo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Views {

	private JFrame frame;
	
	private JPanel panelWelcome = null;
	private JPanel panelMain = null;
	
	private JPanel panelMap = null;
	private JPanel panelPokedex = null;
	private JPanel panelShop = null;
	private JPanel panelTickets = null;

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
		panelWelcome.setBounds(0, 0, 734, 461);
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
		lblLogo.setBounds(668, 11, 56, 39);
		panelMain.add(lblLogo);
		
		JLabel lblTitle = new JLabel("Poke-Zoo");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setBounds(316, 0, 163, 58);
		panelMain.add(lblTitle);
		
		JButton btnMap = new JButton("Mapa");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("MAP");
			}			
		});
		btnMap.setBackground(new Color(255, 255, 255));
		btnMap.setBounds(10, 61, 186, 39);
		panelMain.add(btnMap);
		
		JButton btnPokedex = new JButton("Pokedex");
		btnPokedex.setBackground(new Color(255, 255, 255));
		btnPokedex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("POKEDEX");
			}
		});
		btnPokedex.setBounds(194, 61, 186, 39);
		panelMain.add(btnPokedex);
		
		JButton btnShop = new JButton("Tienda");
		btnShop.setBackground(new Color(255, 255, 255));
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("SHOP");
			}
		});
		btnShop.setBounds(379, 61, 174, 39);
		panelMain.add(btnShop);
		
		JButton btnTickets = new JButton("Entradas");
		btnTickets.setBackground(new Color(255, 255, 255));
		btnTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("TICKETS");
			}
		});
		btnTickets.setBounds(550, 61, 174, 39);
		panelMain.add(btnTickets);
		
		JLabel lblAd = new JLabel("¡¡ Compre sus entradas por 9,99€ aqui !!");
		lblAd.setBounds(250, 440, 257, 14);
		panelMain.add(lblAd);
		
		panelMap = new JPanel();
		panelMap.setVisible(false);
		panelMap.setBounds(10, 111, 714, 314);
		panelMain.add(panelMap);
		panelMap.setLayout(null);
		
		JLabel lblMapa = new JLabel();
		lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap.png")).getImage().getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
		lblMapa.setBounds(30, 86, 636, 217);
		panelMap.add(lblMapa);
		
		JLabel lblPokemonQuestion = new JLabel("¿Que Pokemon estas Buscando? :");
		lblPokemonQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPokemonQuestion.setBounds(23, 26, 278, 22);
		panelMap.add(lblPokemonQuestion);
		
		TextField textFieldAllPokemons = new TextField();
		textFieldAllPokemons.setBounds(327, 29, 222, 22);
		panelMap.add(textFieldAllPokemons);
		
		JButton btnMapSearch = new JButton("Buscar");
		btnMapSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldAllPokemons.getText().equalsIgnoreCase("charmander")) {
					lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap2.png")).getImage().getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
				}
				else if(textFieldAllPokemons.getText().equalsIgnoreCase("charizard")) {
					lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap3.png")).getImage().getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
				}
				else {
					lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap.png")).getImage().getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
				}		
			}	
		});
		btnMapSearch.setBounds(577, 28, 89, 23);
		panelMap.add(btnMapSearch);
		
		panelPokedex = new JPanel();
		panelPokedex.setVisible(false);
		panelPokedex.setBounds(10, 111, 714, 314);
		panelMain.add(panelPokedex);
		panelPokedex.setLayout(null);
		
		JScrollPane scrollPaneAllPokemons = new JScrollPane();
		scrollPaneAllPokemons.setBounds(29, 11, 197, 303);
		panelPokedex.add(scrollPaneAllPokemons);
		
		JLabel lblSelectedPokemonImage = new JLabel("(imagen del Pokemon aqui)");
		lblSelectedPokemonImage.setBounds(531, 11, 173, 222);
		panelPokedex.add(lblSelectedPokemonImage);
		
		JLabel lblInfoName = new JLabel("Nombre :");
		lblInfoName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoName.setBounds(281, 11, 85, 44);
		panelPokedex.add(lblInfoName);
		
		JLabel lblPokemonName = new JLabel("NamePo");
		lblPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPokemonName.setBounds(382, 11, 139, 44);
		panelPokedex.add(lblPokemonName);
		
		JLabel lblInfoTypes = new JLabel("Tipo/s :");
		lblInfoTypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoTypes.setBounds(281, 78, 85, 44);
		panelPokedex.add(lblInfoTypes);
		
		JLabel lblPokemonTypeP = new JLabel("typeP");
		lblPokemonTypeP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPokemonTypeP.setBounds(382, 78, 139, 44);
		panelPokedex.add(lblPokemonTypeP);
		
		JLabel lblPokemonTypeS = new JLabel("typeS");
		lblPokemonTypeS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPokemonTypeS.setBounds(382, 135, 139, 44);
		panelPokedex.add(lblPokemonTypeS);
		
		JLabel lblDescription = new JLabel("Descripcion :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(281, 189, 124, 44);
		panelPokedex.add(lblDescription);
		
		JLabel lbldescripcion = new JLabel("DescriptionPo");
		lbldescripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldescripcion.setBounds(281, 244, 423, 70);
		panelPokedex.add(lbldescripcion);
		
		panelShop = new JPanel();
		panelShop.setVisible(false);
		panelShop.setBounds(10, 111, 714, 314);
		panelMain.add(panelShop);
		panelShop.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 694, 303);
		panelShop.add(scrollPane);
		
		JPanel panelProducts = new JPanel();
		scrollPane.setViewportView(panelProducts);
		panelProducts.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("(imagen 1 ejemplo)");
		lblNewLabel.setBounds(10, 11, 93, 55);
		panelProducts.add(lblNewLabel);
		
		panelTickets = new JPanel();
		panelTickets.setVisible(false);
		panelTickets.setBounds(10, 111, 714, 314);
		panelMain.add(panelTickets);
		panelTickets.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Working working");
		lblNewLabel_1.setBounds(126, 113, 231, 76);
		panelTickets.add(lblNewLabel_1);
	}
	
// --------------------------------------------------------------------------------------
	// CREATED METHODS
	private void changeToPanelMain() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(true);
		panelMap.setVisible(true);
	}
	
	private void switchMainPanels(String panel) {
		switch (panel) {
		case "MAP":
			panelMap.setVisible(true);
			panelPokedex.setVisible(false);
			panelShop.setVisible(false);
			panelTickets.setVisible(false);
			break;
		case "POKEDEX":
			panelMap.setVisible(false);
			panelPokedex.setVisible(true);
			panelShop.setVisible(false);
			panelTickets.setVisible(false);
			break;
		case "SHOP":
			panelMap.setVisible(false);
			panelPokedex.setVisible(false);
			panelShop.setVisible(true);
			panelTickets.setVisible(false);
			break;
		case "TICKETS":
			panelMap.setVisible(false);
			panelPokedex.setVisible(false);
			panelShop.setVisible(false);
			panelTickets.setVisible(true);
			break;
		default:
			System.out.println("This is not supposed to happen");
		}
		
	}
}
