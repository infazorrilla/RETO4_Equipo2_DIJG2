package PokeZoo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import PokeZoo.bbdd.manager.ManagerCaretaker;
import PokeZoo.bbdd.manager.ManagerCleaner;
import PokeZoo.bbdd.manager.ManagerDependent;
import PokeZoo.bbdd.manager.ManagerEmployee;
import PokeZoo.bbdd.manager.ManagerEnclosure;
import PokeZoo.bbdd.manager.ManagerFood;
import PokeZoo.bbdd.manager.ManagerPokemon;
import PokeZoo.bbdd.manager.ManagerUser;
import PokeZoo.bbdd.pojo.Cleaner;
import PokeZoo.bbdd.pojo.Dependent;
import PokeZoo.bbdd.pojo.Employee;
import PokeZoo.bbdd.pojo.Enclosure;
import PokeZoo.bbdd.pojo.Pokemon;
import PokeZoo.bbdd.pojo.User;
import rsscalelabel.RSScaleLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Views {

	private JFrame frame;

	private JPanel panelWelcome = null;
	private JPanel panelMain = null;

	private JPanel panelMap = null;
	private JPanel panelPokedex = null;
	private JPanel panelShop = null;
	private JPanel panelTickets = null;

	private JPanel panelLogin = null;

	private JPanel panelAdmin = null;

	private JPanel panelAdminWelcome = null;
	private JPanel panelAdminEmployee = null;
	private JPanel panelAdminCleaner = null;
	private JPanel panelAdminCaretaker = null;
	private JPanel panelAdminPokemon = null;
	private JPanel panelAdminEnclosure = null;
	private JPanel panelAdminFood = null;

	// Labels
	private JLabel lblInfoTabla = null;

	// Managers
	private ManagerUser managerUser = null;
	private ManagerEmployee managerEmployee = null;
	private ManagerDependent managerDependent = null;
	private ManagerCleaner managerCleaner = null;
	private ManagerCaretaker managerCaretaker = null;
	private ManagerPokemon managerPokemon = null;
	private ManagerEnclosure managerEnclosure = null;
	private ManagerFood managerFood = null;

	// JTables admin
	private JTable tableEmployee = null;
	private JTable tableCleaner = null;
	private JTable tableCaretaker = null;
	private JTable tablePokemon = null;
	private JTable tableEnclosure = null;
	private JTable tableFood = null;

	/**
	 * Create the application.
	 */
	public Views() {
		initialize();
		this.frame.setTitle("Poke-Zoo");
		ImageIcon img = new ImageIcon(Views.class.getResource("/misc/LogoRecortado.png"));
		this.frame.setIconImage(img.getImage());
		this.frame.setVisible(true);
		this.frame.setResizable(false);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// PANEL WELCOME
		panelWelcome = new JPanel();
		panelWelcome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToClientZone();
			}
		});
		panelWelcome.setBounds(0, 0, 734, 461);
		panelWelcome.setVisible(true);

		// PANEL ADMIN
		panelAdmin = new JPanel();
		panelAdmin.setVisible(false);

		// PANEL MAIN
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 734, 461);
		panelMain.setVisible(false);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToWorkerZone();
			}
		});
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/misc/Logo.png")).getImage()
				.getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(668, 11, 56, 39);
		panelMain.add(lblLogo);

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
		lblAd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchMainPanels("TICKETS");
			}
		});
		lblAd.setBounds(250, 440, 257, 14);
		panelMain.add(lblAd);

// PANEL MAIN MAP
		panelMap = new JPanel();
		panelMap.setVisible(false);
		panelMap.setBounds(10, 111, 714, 328);
		panelMain.add(panelMap);
		panelMap.setLayout(null);

		panelMap.setBounds(10, 111, 714, 328);
		panelMain.add(panelMap);

		panelMap.setLayout(null);

		TextField textFieldAllPokemons = new TextField();
		textFieldAllPokemons.setBounds(174, 20, 142, 23);
		panelMap.add(textFieldAllPokemons);

		JButton btnMapSearch = new JButton("Buscar");
		btnMapSearch.setBounds(318, 20, 92, 23);
		panelMap.add(btnMapSearch);

		JPanel panelMapa = new JPanel();
		panelMapa.setBounds(0, 0, 714, 328);
		panelMap.add(panelMapa);
		panelMapa.setLayout(new GridLayout(6, 7, 0, 0));

		JLabel lblMapa1_0 = new JLabel();
		lblMapa1_0.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_0, "img/map/mapa1-0.png");
		panelMapa.add(lblMapa1_0);

		JLabel lblMapa1_1 = new JLabel();
		lblMapa1_1.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_1, "img/map/mapa1-1.png");
		panelMapa.add(lblMapa1_1);

		JLabel lblMapa1_2 = new JLabel();
		lblMapa1_2.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_2, "img/map/mapa1-2.png");
		panelMapa.add(lblMapa1_2);

		JLabel lblMapa1_3 = new JLabel();
		lblMapa1_3.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_3, "img/map/mapa1-3.png");
		panelMapa.add(lblMapa1_3);

		JLabel lblMapa1_4 = new JLabel();
		lblMapa1_4.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_4, "img/map/mapa1-4.png");
		panelMapa.add(lblMapa1_4);

		JLabel lblMapa1_5 = new JLabel();
		lblMapa1_5.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_5, "img/map/mapa1-5.png");
		panelMapa.add(lblMapa1_5);

		JLabel lblMapa1_6 = new JLabel();
		lblMapa1_6.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_6, "img/map/mapa1-6.png");
		panelMapa.add(lblMapa1_6);

		JLabel lblMapa2_0 = new JLabel();
		lblMapa2_0.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_0, "img/map/mapa2-0.png");
		panelMapa.add(lblMapa2_0);

		JLabel lblMapa2_1 = new JLabel();
		lblMapa2_1.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_1, "img/map/mapa2-1.png");
		panelMapa.add(lblMapa2_1);

		JLabel lblMapa2_2 = new JLabel();
		lblMapa2_2.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_2, "img/map/mapa2-2.png");
		panelMapa.add(lblMapa2_2);

		JLabel lblMapa2_3 = new JLabel();
		lblMapa2_3.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_3, "img/map/mapa2-3.png");
		panelMapa.add(lblMapa2_3);

		JLabel lblMapa2_4 = new JLabel();
		lblMapa2_4.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_4, "img/map/mapa2-4.png");
		panelMapa.add(lblMapa2_4);

		JLabel lblMapa2_5 = new JLabel();
		lblMapa2_5.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_5, "img/map/mapa2-5.png");
		panelMapa.add(lblMapa2_5);

		JLabel lblMapa2_6 = new JLabel();
		lblMapa2_6.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_6, "img/map/mapa2-6.png");
		panelMapa.add(lblMapa2_6);

		JLabel lblMapa3_0 = new JLabel();
		lblMapa3_0.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_0, "img/map/mapa3-0.png");
		panelMapa.add(lblMapa3_0);

		JLabel lblMapa3_1 = new JLabel();
		lblMapa3_1.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_1, "img/map/mapa3-1.png");
		panelMapa.add(lblMapa3_1);

		JLabel lblMapa3_2 = new JLabel();
		lblMapa3_2.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_2, "img/map/mapa3-2.png");
		panelMapa.add(lblMapa3_2);

		JLabel lblMapa3_3 = new JLabel();
		lblMapa3_3.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_3, "img/map/mapa3-3.png");
		panelMapa.add(lblMapa3_3);

		JLabel lblMapa3_4 = new JLabel();
		lblMapa3_4.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_4, "img/map/mapa3-4.png");
		panelMapa.add(lblMapa3_4);

		JLabel lblMapa3_5 = new JLabel();
		lblMapa3_5.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_5, "img/map/mapa3-5.png");
		panelMapa.add(lblMapa3_5);

		JLabel lblMapa3_6 = new JLabel();
		lblMapa3_6.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_6, "img/map/mapa3-6.png");
		panelMapa.add(lblMapa3_6);

		JLabel lblMapa4_0 = new JLabel();
		lblMapa4_0.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_0, "img/map/mapa4-0.png");
		panelMapa.add(lblMapa4_0);

		JLabel lblMapa4_1 = new JLabel();
		lblMapa4_1.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_1, "img/map/mapa4-1.png");
		panelMapa.add(lblMapa4_1);

		JLabel lblMapa4_2 = new JLabel();
		lblMapa4_2.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_2, "img/map/mapa4-2.png");
		panelMapa.add(lblMapa4_2);

		JLabel lblMapa4_3 = new JLabel();
		lblMapa4_3.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_3, "img/map/mapa4-3.png");
		panelMapa.add(lblMapa4_3);

		JLabel lblMapa4_4 = new JLabel();
		lblMapa4_4.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_4, "img/map/mapa4-4.png");
		panelMapa.add(lblMapa4_4);

		JLabel lblMapa4_5 = new JLabel();
		lblMapa4_5.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_5, "img/map/mapa4-5.png");
		panelMapa.add(lblMapa4_5);

		JLabel lblMapa4_6 = new JLabel();
		lblMapa4_6.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_6, "img/map/mapa4-6.png");
		panelMapa.add(lblMapa4_6);

		JLabel lblMapa5_0 = new JLabel();
		lblMapa5_0.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_0, "img/map/mapa5-0.png");
		panelMapa.add(lblMapa5_0);

		JLabel lblMapa5_1 = new JLabel();
		lblMapa5_1.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_1, "img/map/mapa5-1.png");
		panelMapa.add(lblMapa5_1);

		JLabel lblMapa5_2 = new JLabel();
		lblMapa5_2.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_2, "img/map/mapa5-2.png");
		panelMapa.add(lblMapa5_2);

		JLabel lblMapa5_3 = new JLabel();
		lblMapa5_3.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_3, "img/map/mapa5-3.png");
		panelMapa.add(lblMapa5_3);

		JLabel lblMapa5_4 = new JLabel();
		lblMapa5_4.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_4, "img/map/mapa5-4.png");
		panelMapa.add(lblMapa5_4);

		JLabel lblMapa5_5 = new JLabel();
		lblMapa5_5.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_5, "img/map/mapa5-5.png");
		panelMapa.add(lblMapa5_5);

		JLabel lblMapa5_6 = new JLabel();
		lblMapa5_6.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_6, "img/map/mapa5-6.png");
		panelMapa.add(lblMapa5_6);

		JLabel lblMapa6_0 = new JLabel();
		lblMapa6_0.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_0, "img/map/mapa6-0.png");
		panelMapa.add(lblMapa6_0);

		JLabel lblMapa6_1 = new JLabel();
		lblMapa6_1.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_1, "img/map/mapa6-1.png");
		panelMapa.add(lblMapa6_1);

		JLabel lblMapa6_2 = new JLabel();
		lblMapa6_2.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_2, "img/map/mapa6-2.png");
		panelMapa.add(lblMapa6_2);

		JLabel lblMapa6_3 = new JLabel();
		lblMapa6_3.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_3, "img/map/mapa6-3.png");
		panelMapa.add(lblMapa6_3);

		JLabel lblMapa6_4 = new JLabel();
		lblMapa6_4.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_4, "img/map/mapa6-4.png");
		panelMapa.add(lblMapa6_4);

		JLabel lblMapa6_5 = new JLabel();
		lblMapa6_5.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_5, "img/map/mapa6-5.png");
		panelMapa.add(lblMapa6_5);

		JLabel lblMapa6_6 = new JLabel();
		lblMapa6_6.setBounds(0, 0, 105, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_6, "img/map/mapa6-6.png");
		panelMapa.add(lblMapa6_6);

		btnMapSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMapa4_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-5.png")));
				lblMapa4_5.setBounds(0, 0, 105, 55);
				RSScaleLabel.setScaleLabel(lblMapa4_5, "img/map/mapa4-5.png");
				lblMapa2_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-2.png")));
				lblMapa2_2.setBounds(0, 0, 105, 55);
				RSScaleLabel.setScaleLabel(lblMapa2_2, "img/map/mapa2-2.png");
				if (textFieldAllPokemons.getText().equalsIgnoreCase("charmander")) {
					lblMapa4_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-5-Alter.png")));
					lblMapa4_5.setBounds(0, 0, 105, 55);
					RSScaleLabel.setScaleLabel(lblMapa4_5, "img/map/mapa4-5-Alter.png");
				} else if (textFieldAllPokemons.getText().equalsIgnoreCase("charizard")) {
					lblMapa4_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-5-Alter.png")));
					lblMapa4_5.setBounds(0, 0, 105, 55);
					RSScaleLabel.setScaleLabel(lblMapa4_5, "img/map/mapa4-5-Alter.png");
					lblMapa2_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-2-Alter.png")));
					lblMapa2_2.setBounds(0, 0, 105, 55);
					RSScaleLabel.setScaleLabel(lblMapa2_2, "img/map/mapa2-2-Alter.png");
				}
			}
		});

		// PANEL MAIN POKEDEX
		panelPokedex = new JPanel();
		panelPokedex.setVisible(false);
		panelPokedex.setBounds(10, 111, 714, 328);
		panelMain.add(panelPokedex);
		panelPokedex.setLayout(null);

		JLabel lblSelectedPokemonImage = new JLabel();
		lblSelectedPokemonImage.setForeground(new Color(0, 0, 0));
		lblSelectedPokemonImage.setBackground(new Color(255, 255, 255));
		lblSelectedPokemonImage.setBounds(531, -50, 173, 222);
		panelPokedex.add(lblSelectedPokemonImage);

		JLabel lblInfoName = new JLabel("Nombre :");
		lblInfoName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoName.setBounds(20, 11, 85, 30);
		panelPokedex.add(lblInfoName);

		JTextArea textPokemonName = new JTextArea();
		textPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonName.setBounds(131, 15, 139, 30);
		textPokemonName.setEditable(false);
		panelPokedex.add(textPokemonName);

		JLabel lblInfoEggGroup = new JLabel("G.Huevo:");
		lblInfoEggGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoEggGroup.setBounds(20, 50, 105, 30);
		panelPokedex.add(lblInfoEggGroup);

		JTextArea textPokemonEggGroup = new JTextArea();
		textPokemonEggGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonEggGroup.setBounds(131, 53, 139, 30);
		textPokemonEggGroup.setEditable(false);
		panelPokedex.add(textPokemonEggGroup);

		JLabel lblInfoTypes = new JLabel("Tipo/s :");
		lblInfoTypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoTypes.setBounds(20, 90, 85, 30);
		panelPokedex.add(lblInfoTypes);

		JTextArea textPokemonTypeP = new JTextArea();
		textPokemonTypeP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonTypeP.setBounds(131, 90, 139, 30);
		textPokemonTypeP.setEditable(false);
		panelPokedex.add(textPokemonTypeP);

		JTextArea textPokemonTypeS = new JTextArea();
		textPokemonTypeS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonTypeS.setBounds(281, 90, 122, 30);
		textPokemonTypeS.setEditable(false);
		panelPokedex.add(textPokemonTypeS);

		JLabel lblDescription = new JLabel("Descripcion :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(20, 120, 200, 44);
		panelPokedex.add(lblDescription);

		JTextArea textPokemonDescription = new JTextArea();
		textPokemonDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPokemonDescription.setBounds(20, 160, 423, 100);
		textPokemonDescription.setLineWrap(true);
		textPokemonDescription.setWrapStyleWord(true);
		textPokemonDescription.setEditable(false);
		panelPokedex.add(textPokemonDescription);

		JTextField textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textSearch.setBounds(100, 268, 150, 40);
		panelPokedex.add(textSearch);

		JButton btnSearch = new JButton();
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(250, 268, 40, 40);
		btnSearch.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/misc/PokeLupa.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon pokemonSeleccionado = new Pokemon();
				if (null == managerPokemon) {
					managerPokemon = new ManagerPokemon();
				}
				if (textSearch.getText().matches("[0-9]+")) {
					pokemonSeleccionado = managerPokemon.getPokemonByNumPokedex(Integer.parseInt(textSearch.getText()));
				} else if (managerPokemon.getPokemonByName(textSearch.getText()) != null) {
					pokemonSeleccionado = managerPokemon.getPokemonByName(textSearch.getText());
				} else {
					pokemonSeleccionado.setNamePo("");
					pokemonSeleccionado.setEggGroup("");
					pokemonSeleccionado.setTypeP("");
					pokemonSeleccionado.setTypeS("");
					pokemonSeleccionado.setDescriptionPo("");
				}
				textPokemonName.setText(pokemonSeleccionado.getNamePo());
				textPokemonEggGroup.setText(pokemonSeleccionado.getEggGroup());
				textPokemonTypeP.setText(pokemonSeleccionado.getTypeP());
				textPokemonTypeS.setText(pokemonSeleccionado.getTypeS());
				textPokemonDescription.setText(pokemonSeleccionado.getDescriptionPo());
				lblSelectedPokemonImage.setIcon(null);
			}
		});
		panelPokedex.add(btnSearch);

		JLabel lblPokedexImage = new JLabel();
		lblPokedexImage.setBounds(0, 0, 714, 314);
		lblPokedexImage.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/misc/Pokedex.png")).getImage()
				.getScaledInstance(714, 314, Image.SCALE_DEFAULT)));
		panelPokedex.add(lblPokedexImage);

		// PANEL MAIN TIENDA
		panelShop = new JPanel();
		panelShop.setVisible(false);
		panelShop.setBounds(10, 111, 714, 328);
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

		// PANEL MAIN TICKETS
		panelTickets = new JPanel();
		panelTickets.setVisible(false);
		panelTickets.setBounds(10, 111, 714, 328);
		panelMain.add(panelTickets);
		panelTickets.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Working working");
		lblNewLabel_1.setBounds(126, 113, 231, 76);
		panelTickets.add(lblNewLabel_1);
		panelAdmin.setBounds(0, 0, 734, 461);
		frame.getContentPane().add(panelAdmin);
		panelAdmin.setLayout(null);

		JButton btnZooArea = new JButton("Zoo");

		JButton btnWorkerArea = new JButton("Trabajadores");
		btnWorkerArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Una vez cerrados los paneles volver a poner ambos botones visibles
				btnWorkerArea.setVisible(false);
				btnZooArea.setVisible(true);
			}
		});
		btnWorkerArea.setBackground(new Color(255, 255, 255));
		btnWorkerArea.setBounds(0, 0, 370, 46);
		panelAdmin.add(btnWorkerArea);

		btnZooArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO ocultar btnZooArea y mostrar los otros 3 bottones que estan abajo
				btnWorkerArea.setVisible(true);
				btnZooArea.setVisible(false);
			}
		});
		btnZooArea.setBackground(new Color(255, 255, 255));
		btnZooArea.setBounds(369, 0, 365, 46);
		panelAdmin.add(btnZooArea);

		// PANEL ADMIN WELCOME
		panelAdminWelcome = new JPanel();
		panelAdminWelcome.setBounds(10, 57, 24, 14);
		panelAdmin.add(panelAdminWelcome);
		panelAdminWelcome.setLayout(null);

		JLabel lblImageWorkers = new JLabel("(worker image)");
		lblImageWorkers.setBounds(10, 11, 265, 371);
		panelAdminWelcome.add(lblImageWorkers);

		JLabel lbllogo2 = new JLabel("Logo");
		lbllogo2.setIcon(new ImageIcon(Views.class.getResource("/misc/Logo.png")));
		lbllogo2.setBounds(285, 154, 116, 73);
		panelAdminWelcome.add(lbllogo2);

		JLabel lblImageZoo = new JLabel("(zoo image)");
		lblImageZoo.setBounds(411, 11, 293, 371);
		panelAdminWelcome.add(lblImageZoo);

		JButton btnEmployee = new JButton("Oficinistas");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(1);
				lblInfoTabla.setText("Tabla Oficinistas");
				loadTableEmployeeData(tableEmployee);
			}
		});
		btnEmployee.setBackground(Color.WHITE);
		btnEmployee.setBounds(0, 0, 117, 46);
		panelAdmin.add(btnEmployee);

		JButton btnCleaner = new JButton("Limpiadores");
		btnCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(2);
				lblInfoTabla.setText("Tabla Limpiadores");
				loadTableCleanerData(tableCleaner);
			}
		});
		btnCleaner.setBackground(Color.WHITE);
		btnCleaner.setBounds(118, 0, 135, 46);
		panelAdmin.add(btnCleaner);

		JButton btnCaretakers = new JButton("Cuidadores");
		btnCaretakers.setBackground(Color.WHITE);
		btnCaretakers.setBounds(253, 0, 117, 46);
		panelAdmin.add(btnCaretakers);

		JButton btnPokemon = new JButton("Pokemons");
		btnPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(4);
				lblInfoTabla.setText("Tabla Pokemons");
				loadTablePokemonData(tablePokemon);
			}
		});
		btnPokemon.setBackground(Color.WHITE);
		btnPokemon.setBounds(369, 0, 117, 46);
		panelAdmin.add(btnPokemon);

		JButton btnEnclosure = new JButton("Recintos");
		btnEnclosure.setBackground(Color.WHITE);
		btnEnclosure.setBounds(486, 0, 131, 46);
		panelAdmin.add(btnEnclosure);

		JButton btnFood = new JButton("Alimento");
		btnFood.setBackground(Color.WHITE);
		btnFood.setBounds(617, 0, 117, 46);
		panelAdmin.add(btnFood);

		// PANEL EMPLOYEE
		panelAdminEmployee = new JPanel();
		panelAdminEmployee.setBounds(10, 68, 714, 370);
		panelAdmin.add(panelAdminEmployee);
		panelAdminEmployee.setLayout(null);
		panelAdminEmployee.setVisible(false);

		JScrollPane scrollPaneTableEmployee = new JScrollPane();
		scrollPaneTableEmployee.setBounds(10, 11, 694, 321);
		panelAdminEmployee.add(scrollPaneTableEmployee);

		tableEmployee = new JTable();
		scrollPaneTableEmployee.setViewportView(tableEmployee);

		tableEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEmployee.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "DNI", "Nombre", "Apellido", "Telf.", "Bloqueado", "usuario" }));
		tableEmployee.setDefaultEditor(Object.class, null);

		JButton btnAddNewEmployee = new JButton("Añadir Empleado");
		btnAddNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField dni = new JTextField();
				JTextField name = new JTextField();
				JTextField surName = new JTextField();
				JTextField phone = new JTextField();
				JTextField username = new JTextField();
				JPasswordField password = new JPasswordField();

				Object[] message = { "DNI: *", dni, "Nombre: *", name, "Apellido: *", surName, "Telefono:", phone,
						"Username: *", username, "Password: *", password };

				int option = JOptionPane.showConfirmDialog(null, message, "Registrar nuevo Oficinista",
						JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (dni.getText().isEmpty() || name.getText().isEmpty() || surName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Oficinista!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else if (username.getText().isEmpty() || password.getPassword().length == 0) {
						JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Usuario!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						// User(idUser, isAdmin, username, passwd, isBlocked)
						User userToInsert = new User(0, false, username.getText(), new String(password.getPassword()),
								false);

						Employee employeToInsert = new Employee();
						employeToInsert.setDni(dni.getText());
						employeToInsert.setNameWo(name.getText());
						employeToInsert.setSurnameWo(surName.getText());
						employeToInsert.setPhoneWo(phone.getText());

						try {
							if (null == managerUser) {
								managerUser = new ManagerUser();
							}

							if (null == managerEmployee) {
								managerEmployee = new ManagerEmployee();
							}
							// TODO Comprobar que el usuario no existe ya
							managerUser.insert(userToInsert);
							userToInsert = managerUser.selectUserByUsernameAndPasswd(userToInsert.getUsername(),
									userToInsert.getPasswd());
							employeToInsert.setUser(userToInsert);
							managerEmployee.insert(employeToInsert);
							JOptionPane.showMessageDialog(null, "Empleado registrado correctamente", "Yay!",
									JOptionPane.INFORMATION_MESSAGE);
							loadTableEmployeeData(tableEmployee);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnAddNewEmployee.setBounds(10, 336, 150, 23);
		panelAdminEmployee.add(btnAddNewEmployee);

		JButton btnModifyEmployee = new JButton("Modificar Empleado");
		btnModifyEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee selectedEmployee = getSelectedEmployee();

				JLabel dni = new JLabel();
				dni.setText(selectedEmployee.getDni());
				JTextField name = new JTextField();
				name.setText(selectedEmployee.getNameWo());
				JTextField surName = new JTextField();
				surName.setText(selectedEmployee.getSurnameWo());
				JTextField phone = new JTextField();
				phone.setText(selectedEmployee.getPhoneWo());
				JTextField username = new JTextField();
				username.setText(selectedEmployee.getUser().getUsername());
				JPasswordField password = new JPasswordField();

				Object[] message = { "DNI: ", dni, "Nombre: *", name, "Apellido: *", surName, "Telefono:", phone,
						"Username: *", username, "Password: *", password };

				int option = JOptionPane.showConfirmDialog(null, message, "Modificar Oficinista",
						JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					int confimation = JOptionPane.showConfirmDialog(null,
							"¿Estas seguro de que deseas realizar los cambios?", "Confirmacion",
							JOptionPane.OK_CANCEL_OPTION);
					if (confimation == JOptionPane.OK_OPTION) {
						selectedEmployee.setIdEmployee(managerEmployee.getEmployeeIdByDni(selectedEmployee.getDni()));
						selectedEmployee.setNameWo(name.getText());
						selectedEmployee.setSurnameWo(surName.getText());
						selectedEmployee.setPhoneWo(phone.getText());
						selectedEmployee.getUser().setUsername(username.getText());
						selectedEmployee.getUser().setPasswd(new String(password.getPassword()));
						try {
							managerEmployee.update(selectedEmployee);

							if (null == managerUser) {
								managerUser = new ManagerUser();
							}
							managerUser.update(selectedEmployee.getUser());
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						loadTableEmployeeData(tableEmployee);
					}
				}
			}
		});
		btnModifyEmployee.setBounds(180, 336, 141, 23);
		panelAdminEmployee.add(btnModifyEmployee);

		JButton btnDeleteEmployee = new JButton("Borrar Empleado");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee selectedEmployee = getSelectedEmployee();
				int confimation = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar el empleado?",
						"Confirmacion", JOptionPane.OK_CANCEL_OPTION);
				if (confimation == JOptionPane.OK_OPTION) {
					deleteSelectedEmployee(selectedEmployee);
				}
			}
		});
		btnDeleteEmployee.setBounds(399, 336, 141, 23);
		panelAdminEmployee.add(btnDeleteEmployee);

		JButton btnBlockEmployee = new JButton("Bloquear Empleado");
		btnBlockEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO SI SE SELECCIONA EL USUARIO QUE ES DEPENDENDIENTE NO FUNCIONA NADA :S
				Employee selectedEmployee = getSelectedEmployee();

				int confimation = JOptionPane.showConfirmDialog(null,
						"¿Estas seguro de que deseas BLOQUEAR el empleado?", "Confirmacion",
						JOptionPane.OK_CANCEL_OPTION);
				if (confimation == JOptionPane.OK_OPTION) {
					blockSelectedEmployee(selectedEmployee);
				}

				loadTableEmployeeData(tableEmployee);
			}
		});
		btnBlockEmployee.setBounds(563, 336, 141, 23);
		panelAdminEmployee.add(btnBlockEmployee);

		// PANEL CLEANER
		// TODO
		panelAdminCleaner = new JPanel();
		panelAdminCleaner.setBounds(10, 68, 714, 370);
		panelAdmin.add(panelAdminCleaner);
		panelAdminCleaner.setLayout(null);
		panelAdminCleaner.setVisible(false);

		JScrollPane scrollPaneTableCleaner = new JScrollPane();
		scrollPaneTableCleaner.setBounds(10, 11, 694, 321);
		panelAdminCleaner.add(scrollPaneTableCleaner);

		tableCleaner = new JTable();
		scrollPaneTableCleaner.setViewportView(tableCleaner);

		tableCleaner.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCleaner.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "DNI", "Nombre", "Apellido", "Telf.", "Bloqueado", "usuario", "Recinto" }));
		tableCleaner.setDefaultEditor(Object.class, null);

		JButton btnAddNewCleaner = new JButton("Añadir Limpiador");
		btnAddNewCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField dni = new JTextField();
				JTextField name = new JTextField();
				JTextField surName = new JTextField();
				JTextField phone = new JTextField();
				JTextField username = new JTextField();
				JPasswordField password = new JPasswordField();
				JTextField enclosure = new JTextField();

				Object[] message = { "DNI: *", dni, "Nombre: *", name, "Apellido: *", surName, "Telefono:", phone,
						"Username: *", username, "Password: *", password, "Recinto*: ", enclosure };

				int option = JOptionPane.showConfirmDialog(null, message, "Resgistrar nuevo Oficinista",
						JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (dni.getText().isEmpty() || name.getText().isEmpty() || surName.getText().isEmpty()
							|| enclosure.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Limpiador!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else if (username.getText().isEmpty() || password.getPassword().length == 0) {
						JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Usuario!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						// User(idUser, isAdmin, username, passwd, isBlocked)
						User userToInsert = new User(0, false, username.getText(), new String(password.getPassword()),
								false);

						Cleaner CleanerToInsert = new Cleaner();
						CleanerToInsert.setDni(dni.getText());
						CleanerToInsert.setNameWo(name.getText());
						CleanerToInsert.setSurnameWo(surName.getText());
						CleanerToInsert.setPhoneWo(phone.getText());

						Enclosure enclosureToInsert = new Enclosure();
						enclosureToInsert.setTypeEn(enclosure.getText());

						CleanerToInsert.setEnclosure(enclosureToInsert);

						try {
							if (null == managerUser) {
								managerUser = new ManagerUser();
							}
							if (null == managerEmployee) {
								managerEmployee = new ManagerEmployee();
							}
							if (null == managerCleaner) {
								managerCleaner = new ManagerCleaner();
							}
							if (null == managerEnclosure) {
								managerEnclosure = new ManagerEnclosure();
							}
							// TODO Comprobar que el usuario no existe ya
							managerUser.insert(userToInsert);
							userToInsert = managerUser.selectUserByUsernameAndPasswd(userToInsert.getUsername(),
									userToInsert.getPasswd());
							CleanerToInsert.setUser(userToInsert);

							managerEmployee.insert(CleanerToInsert);

							CleanerToInsert.setIdEmployee(managerEmployee.getEmployeeIdByDni(CleanerToInsert.getDni()));
							CleanerToInsert.setEnclosure((managerEnclosure
									.selectEnclosureByTypeEn(CleanerToInsert.getEnclosure().getTypeEn())));

							managerCleaner.insert(CleanerToInsert);

							JOptionPane.showMessageDialog(null, "Limpiador registrado correctamente", "Yay!",
									JOptionPane.INFORMATION_MESSAGE);
							loadTableCleanerData(tableCleaner);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnAddNewCleaner.setBounds(10, 336, 150, 23);
		panelAdminCleaner.add(btnAddNewCleaner);

		JButton btnModifyCleaner = new JButton("Modificar Limpiador");
		btnModifyCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				/*
				 * Cleaner selectedEmployee = getSelectedCleaner();
				 * 
				 * JLabel dni = new JLabel(); dni.setText(selectedEmployee.getDni()); JTextField
				 * name = new JTextField(); name.setText(selectedEmployee.getNameWo());
				 * JTextField surName = new JTextField();
				 * surName.setText(selectedEmployee.getSurnameWo()); JTextField phone = new
				 * JTextField(); phone.setText(selectedEmployee.getPhoneWo()); JTextField
				 * username = new JTextField();
				 * username.setText(selectedEmployee.getUser().getUsername()); JPasswordField
				 * password = new JPasswordField();
				 * 
				 * Object[] message = { "DNI: ", dni, "Nombre: *", name, "Apellido: *", surName,
				 * "Telefono:", phone, "Username: *", username, "Password: *", password };
				 * 
				 * int option = JOptionPane.showConfirmDialog(null, message,
				 * "Modificar Oficinista", JOptionPane.OK_CANCEL_OPTION); if (option ==
				 * JOptionPane.OK_OPTION) { int confimation =
				 * JOptionPane.showConfirmDialog(null,
				 * "¿Estas seguro de que deseas realizar los cambios?", "Confirmacion",
				 * JOptionPane.OK_CANCEL_OPTION); if (confimation == JOptionPane.OK_OPTION) {
				 * selectedEmployee.setIdEmployee(managerEmployee.getEmployeeIdByDni(
				 * selectedEmployee.getDni())); selectedEmployee.setNameWo(name.getText());
				 * selectedEmployee.setSurnameWo(surName.getText());
				 * selectedEmployee.setPhoneWo(phone.getText());
				 * selectedEmployee.getUser().setUsername(username.getText());
				 * selectedEmployee.getUser().setPasswd(new String(password.getPassword())); try
				 * { managerEmployee.update(selectedEmployee);
				 * 
				 * if (null == managerUser) { managerUser = new ManagerUser(); }
				 * managerUser.update(selectedEmployee.getUser()); } catch (Exception e1) {
				 * e1.printStackTrace(); }
				 * 
				 * loadTableEmployeeData(tableEmployee); } }
				 */
			}
		});
		btnModifyCleaner.setBounds(180, 336, 141, 23);
		panelAdminCleaner.add(btnModifyCleaner);

		JButton btnDeleteCleaner = new JButton("Borrar Limpiador");
		btnDeleteCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cleaner selectedCleaner = getSelectedCleaner();
				int confimation = JOptionPane.showConfirmDialog(null,
						"¿Estas seguro de que deseas borrar el limpiador?", "Confirmacion",
						JOptionPane.OK_CANCEL_OPTION);
				if (confimation == JOptionPane.OK_OPTION) {
					// deleteSelectedCleaner(selectedCleaner);
				}
			}
		});
		btnDeleteCleaner.setBounds(399, 336, 141, 23);
		panelAdminCleaner.add(btnDeleteCleaner);

		JButton btnBlockCleaner = new JButton("Bloquear Limpiador");
		btnBlockCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cleaner selectedCleaner = getSelectedCleaner();

				int confimation = JOptionPane.showConfirmDialog(null,
						"¿Estas seguro de que deseas BLOQUEAR el limpiador?", "Confirmacion",
						JOptionPane.OK_CANCEL_OPTION);
				if (confimation == JOptionPane.OK_OPTION) {
					blockSelectedCleaner(selectedCleaner);
				}

				loadTableEmployeeData(tableCleaner);
			}
		});
		btnBlockCleaner.setBounds(563, 336, 141, 23);
		panelAdminCleaner.add(btnBlockCleaner);

		// PANEL POKEMON
		panelAdminPokemon = new JPanel();
		panelAdminPokemon.setBounds(10, 68, 714, 370);
		panelAdmin.add(panelAdminPokemon);
		panelAdminPokemon.setLayout(null);
		panelAdminPokemon.setVisible(false);

		JScrollPane scrollPaneTablePokemon = new JScrollPane();
		scrollPaneTablePokemon.setBounds(10, 11, 694, 321);
		panelAdminPokemon.add(scrollPaneTablePokemon);

		tablePokemon = new JTable();
		scrollPaneTablePokemon.setViewportView(tablePokemon);

		tablePokemon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePokemon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nombre", "Grupo huevo", "Tipo P", "Tipo S" }));
		tablePokemon.setDefaultEditor(Object.class, null);

		JButton btnAddNewPokemon = new JButton("Añadir Pokemon");
		btnAddNewPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField id = new JTextField();
				JTextField namePo = new JTextField();
				JTextField eggGroup = new JTextField();
				JTextField typeP = new JTextField();
				JTextField typeS = new JTextField();

				Object[] message = { "idPokemon: ", id, "namePo: *", namePo, "eggGroup: *", eggGroup, "typeP:", typeP,
						"typeS: ", typeS };

				int option = JOptionPane.showConfirmDialog(null, message, "Resgistrar nuevo Pokemon",
						JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (id.getText().isEmpty() || namePo.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Pokemon!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else {

						Pokemon pokemonToInsert = new Pokemon();
						pokemonToInsert.setIdPokemon(Integer.valueOf(id.getText()));
						pokemonToInsert.setNamePo(namePo.getText());
						pokemonToInsert.setEggGroup(eggGroup.getText());
						pokemonToInsert.setTypeP(typeP.getText());
						pokemonToInsert.setTypeS(typeS.getText());

						try {
							if (null == managerPokemon) {
								managerPokemon = new ManagerPokemon();
							}
							// TODO Comprobar que el usuario no existe ya
							managerPokemon.insert(pokemonToInsert);
							JOptionPane.showMessageDialog(null, "Pokemon registrado correctamente", "Yay!",
									JOptionPane.INFORMATION_MESSAGE);
							loadTablePokemonData(tablePokemon);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnAddNewPokemon.setBounds(10, 336, 150, 23);
		panelAdminPokemon.add(btnAddNewPokemon);

		JButton btnModifyPokemon = new JButton("Modificar Pokemon");
		btnModifyPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Pokemon selectedPokemon = getSelectedPokemon();
				 * 
				 * JLabel id = new JLabel(); id.setText(selectedPokemon.getIdPokemon());
				 * JTextField namePo = new JTextField();
				 * namePo.setText(selectedPokemon.getNamePo()); JTextField eggGroup = new
				 * JTextField(); eggGroup.setText(selectedPokemon.getEggGroup()); JTextField
				 * typeP = new JTextField(); typeP.setText(selectedPokemon.getTypeP());
				 * JTextField typeS = new JTextField();
				 * typeS.setText(selectedPokemon.getTypeS());
				 * 
				 * Object[] message = { "idPokemon: ", id, "namePo: *", namePo, "eggGroup: *",
				 * eggGroup, "typeP:", typeP, "typeS: ", typeS };
				 * 
				 * int option = JOptionPane.showConfirmDialog(null, message,
				 * "Modificar Oficinista", JOptionPane.OK_CANCEL_OPTION); if (option ==
				 * JOptionPane.OK_OPTION) { int confimation =
				 * JOptionPane.showConfirmDialog(null,
				 * "¿Estas seguro de que deseas realizar los cambios?", "Confirmacion",
				 * JOptionPane.OK_CANCEL_OPTION); if (confimation == JOptionPane.OK_OPTION) {
				 * selectedPokemon.setIdPokemon(managerPokemon.getPokemonIdByName(
				 * selectedPokemon.getIdPokemon()));
				 * selectedPokemon.setNamePo(namePo.getText());
				 * selectedPokemon.setEggGroup(eggGroup.getText());
				 * selectedPokemon.setTypeP(typeP.getText());
				 * selectedPokemon.setTypeS(typeS.getText()); try {
				 * managerPokemon.update(selectedPokemon); } catch (Exception e1) {
				 * e1.printStackTrace(); }
				 * 
				 * loadTablePokemonData(tablePokemon); } }
				 */
			}
		});
		btnModifyPokemon.setBounds(180, 336, 141, 23);
		panelAdminPokemon.add(btnModifyPokemon);

		JButton btnDeletePokemon = new JButton("Borrar Pokemon");
		btnDeletePokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Pokemon selectedPokemon = getSelectedPokemon(); int confimation =
				 * JOptionPane.showConfirmDialog(null,
				 * "¿Estas seguro de que deseas borrar el empleado?", "Confirmacion",
				 * JOptionPane.OK_CANCEL_OPTION); if (confimation == JOptionPane.OK_OPTION) {
				 * deleteSelectedPokemon(selectedPokemon); }
				 */
			}
		});
		btnDeletePokemon.setBounds(399, 336, 141, 23);
		panelAdminPokemon.add(btnDeletePokemon);

		// FIN PANELES ADMIN
		lblInfoTabla = new JLabel("");
		lblInfoTabla.setBounds(42, 53, 135, 14);
		panelAdmin.add(lblInfoTabla);

		JButton btnLogOut = new JButton("Cerrar Sesion");
		btnLogOut.setBorderPainted(false);
		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				changeToClientZone();
			}
		});
		btnLogOut.setBounds(0, 437, 117, 24);
		panelAdmin.add(btnLogOut);
		frame.getContentPane().add(panelWelcome);
		panelWelcome.setLayout(null);

		JLabel lblWelcome = new JLabel("¡¡ Bienvenido !!");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWelcome.setBounds(280, 149, 170, 105);
		panelWelcome.add(lblWelcome);

		/*
		 * JButton btnMap = new JButton("Mapa"); btnMap.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) {
		 * switchMainPanels("MAP"); } }); btnMap.setBackground(new Color(255, 255,
		 * 255)); btnMap.setBounds(10, 11, 186, 39); panelMain.add(btnMap);
		 */

		// PANEL LOGIN
		panelLogin = new JPanel();
		panelLogin.setVisible(false);
		panelLogin.setBounds(0, 0, 734, 461);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lblLoginTitle = new JLabel("Login\r\n");
		lblLoginTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoginTitle.setBounds(331, 11, 136, 55);
		panelLogin.add(lblLoginTitle);

		JLabel lblUser = new JLabel("Usuario: ");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBounds(142, 119, 109, 55);
		panelLogin.add(lblUser);

		JLabel lblPasswd = new JLabel("Contaseña: ");
		lblPasswd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPasswd.setBounds(142, 200, 146, 55);
		panelLogin.add(lblPasswd);

		JTextField textFieldUserName = new JTextField();
		textFieldUserName.setBounds(254, 139, 227, 20);
		panelLogin.add(textFieldUserName);
		textFieldUserName.setColumns(10);

		JPasswordField passwordFieldPasswd = new JPasswordField();
		passwordFieldPasswd.setBounds(254, 220, 227, 20);
		panelLogin.add(passwordFieldPasswd);

		JButton btnAccess = new JButton("Acceder");
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin(textFieldUserName, passwordFieldPasswd);
				passwordFieldPasswd.setText(null);
				textFieldUserName.setText(null);
			}
		});
		btnAccess.setBounds(254, 294, 89, 23);
		panelLogin.add(btnAccess);

		JButton btnQuit = new JButton("Salir");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToClientZone();
			}
		});
		btnQuit.setBounds(392, 294, 89, 23);
		panelLogin.add(btnQuit);
	}

// --------------------------------------------------------------------------------------
//PANELS METHODS		
	private void switchAdminPanels(int i) {
		switch (i) {
		case 1:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(true);
			panelAdminCleaner.setVisible(false);
			// panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(false);
			/*
			 * panelAdminEnclosure.setVisible(false); panelAdminFood.setVisible(false);
			 */
			break;
		case 2:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(true);
			// panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(false);
			/*
			 * panelAdminEnclosure.setVisible(false); panelAdminFood.setVisible(false);
			 */
			break;
		case 3:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			// panelAdminCaretaker.setVisible(true);
			panelAdminPokemon.setVisible(false);
			/*
			 * panelAdminEnclosure.setVisible(false); panelAdminFood.setVisible(false);
			 */
			break;
		case 4:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			// panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(true);
			/*
			 * panelAdminEnclosure.setVisible(false); panelAdminFood.setVisible(false);
			 */
			break;
		case 5:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			// panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(false);
			/*
			 * panelAdminEnclosure.setVisible(true); panelAdminFood.setVisible(false);
			 */
			break;
		case 6:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			/*
			 * panelAdminCaretaker.setVisible(false); panelAdminPokemon.setVisible(false);
			 * panelAdminEnclosure.setVisible(false); panelAdminFood.setVisible(true);
			 */
			break;
		default:
			System.out.println("Error");
		}

	}

	private void changeToClientZone() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(true);
		panelMap.setVisible(true);
		panelLogin.setVisible(false);
		panelAdmin.setVisible(false);
		panelAdminWelcome.setVisible(false);
		panelAdminEmployee.setVisible(false);
	}

	private void changeToWorkerZone() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(false);
		panelMap.setVisible(false);
		panelLogin.setVisible(true);
		panelAdmin.setVisible(false);
	}

	private void changeToAdminZone() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(false);
		panelMap.setVisible(false);
		panelLogin.setVisible(false);
		panelAdmin.setVisible(true);
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

	// otros metodos
	// ----------------------------------------------------------------------------
	private void deleteSelectedEmployee(Employee selectedEmployee) {
		if (null == managerEmployee) {
			managerEmployee = new ManagerEmployee();
		}
		selectedEmployee.setIdEmployee(managerEmployee.getEmployeeIdByDni(selectedEmployee.getDni()));

		try {
			managerUser.delete(selectedEmployee.getUser());
			JOptionPane.showMessageDialog(null, "Empleado Borrado correctamente", "Correcto!",
					JOptionPane.PLAIN_MESSAGE);
			loadTableEmployeeData(tableEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void blockSelectedEmployee(Employee selectedEmployee) {
		if (null == managerUser) {
			managerUser = new ManagerUser();
		}
		managerUser.blockUserByIdUser(selectedEmployee.getUser().getIdUser());
	}

	private void blockSelectedCleaner(Cleaner selectedCleaner) {
		// TODO

	}

	private void loadTableEmployeeData(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		if (null == managerEmployee) {
			managerEmployee = new ManagerEmployee();
		}

		if (null == managerDependent) {
			managerDependent = new ManagerDependent();
		}

		ArrayList<Employee> allEmployees = null;
		ArrayList<Dependent> allDependant = null;
		try {
			allEmployees = managerEmployee.selectAll();
			allDependant = managerDependent.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != allEmployees) {
			for (Employee employee : allEmployees) {
				String dni = employee.getDni();
				String name = employee.getNameWo();
				String surName = employee.getSurnameWo();
				String phone = employee.getPhoneWo();
				Boolean isBlocked = employee.getUser().getIsBlocked();
				String username = employee.getUser().getUsername();

				model.addRow(new String[] { dni, name, surName, phone, isBlocked.toString(), username });
			}
		}

		if (null != allDependant) {
			for (Dependent dependant : allDependant) {
				String dni = dependant.getDni();
				String name = dependant.getNameWo();
				String surName = dependant.getSurnameWo();
				String phone = dependant.getPhoneWo();
				Boolean isBlocked = dependant.getUser().getIsBlocked();

				model.addRow(new String[] { dni, name, surName, phone, isBlocked.toString() });
			}
		}
	}

	private void loadTableCleanerData(JTable tableCleaner) {
		DefaultTableModel model = (DefaultTableModel) tableCleaner.getModel();
		model.setRowCount(0);

		if (null == managerCleaner) {
			managerCleaner = new ManagerCleaner();
		}

		ArrayList<Cleaner> allCleaners = null;
		try {
			allCleaners = managerCleaner.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != allCleaners) {
			for (Cleaner cleaner : allCleaners) {
				String dni = cleaner.getDni();
				String name = cleaner.getNameWo();
				String surName = cleaner.getSurnameWo();
				String phone = cleaner.getPhoneWo();
				Boolean isBlocked = cleaner.getUser().getIsBlocked();
				String username = cleaner.getUser().getUsername();
				String enclosure = cleaner.getEnclosure().getTypeEn();

				model.addRow(new String[] { dni, name, surName, phone, isBlocked.toString(), username, enclosure });
			}
		}
	}

	private void loadTablePokemonData(JTable tablePokemon) {
		DefaultTableModel model = (DefaultTableModel) tablePokemon.getModel();
		model.setRowCount(0);

		if (null == managerPokemon) {
			managerPokemon = new ManagerPokemon();
		}

		ArrayList<Pokemon> allPokemons = null;
		try {
			allPokemons = managerPokemon.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != allPokemons) {
			for (Pokemon poke : allPokemons) {
				String idPokemon = Integer.toString(poke.getIdPokemon());
				String namePo = poke.getNamePo();
				String eggGroup = poke.getEggGroup();
				String typeP = poke.getTypeP();
				String typeS = poke.getTypeS();

				model.addRow(new String[] { idPokemon, namePo, eggGroup, typeP, typeS });
			}
		}
	}

	private Employee getSelectedEmployee() {
		Employee ret = null;
		if (tableEmployee.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para modificar.", "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			ret = new Employee();
		}
		int row = tableEmployee.getSelectedRow();

		String dni = (String) tableEmployee.getValueAt(row, 0);
		ret = managerEmployee.selectEmployeeByDni(dni);

		return ret;
	}

	private Cleaner getSelectedCleaner() {
		Cleaner ret = null;
		if (tableCleaner.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para modificar.", "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			ret = new Cleaner();
		}
		int row = tableCleaner.getSelectedRow();

		String dni = (String) tableCleaner.getValueAt(row, 0);
		ret = managerCleaner.selectCleanerByDni(dni);

		return ret;
	}

	private void checkLogin(JTextField textFieldUserName, JPasswordField passwordFieldPasswd) {
		String userName = textFieldUserName.getText();
		String passwd = new String(passwordFieldPasswd.getPassword());

		if (null == managerUser) {
			managerUser = new ManagerUser();
		}
		int result = managerUser.checkUserExists(userName, passwd);
		loginOptions(result);
	}

	private void loginOptions(int result) {
		switch (result) {
		case 0:
			JOptionPane.showMessageDialog(null, "El usuario no existe o la contraseña es incorrecta", "Oye!",
					JOptionPane.ERROR_MESSAGE);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Iniciando sesion...", "Correcto!", JOptionPane.PLAIN_MESSAGE);
			// TODO Zona empleado changeToAdminZone();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Iniciando sesion como admin...", "Correcto!",
					JOptionPane.PLAIN_MESSAGE);
			changeToAdminZone();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "El usuario esta bloqueado... :,C", "Upss!",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			System.out.println("This is not supposed to happen");
		}
	}
}
