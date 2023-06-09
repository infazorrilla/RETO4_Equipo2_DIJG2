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
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import PokeZoo.bbdd.exception.EmployeeNotSelected;
import PokeZoo.bbdd.manager.ManagerCaretaker;
import PokeZoo.bbdd.manager.ManagerCleaner;
import PokeZoo.bbdd.manager.ManagerEmployee;
import PokeZoo.bbdd.manager.ManagerEnclosure;
import PokeZoo.bbdd.manager.ManagerFile;
import PokeZoo.bbdd.manager.ManagerFood;
import PokeZoo.bbdd.manager.ManagerPokemon;
import PokeZoo.bbdd.manager.ManagerUser;
import PokeZoo.bbdd.pojo.Caretaker;
import PokeZoo.bbdd.pojo.Cleaner;
import PokeZoo.bbdd.pojo.Employee;
import PokeZoo.bbdd.pojo.Enclosure;
import PokeZoo.bbdd.pojo.Food;
import PokeZoo.bbdd.pojo.Pokemon;
import PokeZoo.bbdd.pojo.User;
import rsscalelabel.RSScaleLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

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
	private JLabel lblAdd = null;

	// Managers
	private ManagerUser managerUser = null;
	private ManagerEmployee managerEmployee = null;
	private ManagerCleaner managerCleaner = null;
	private ManagerCaretaker managerCaretaker = null;
	private ManagerPokemon managerPokemon = null;
	private ManagerEnclosure managerEnclosure = null;
	private ManagerFood managerFood = null;
	private ManagerFile managerFile = null;

	// JTables admin
	private JTable tableEmployee = null;
	private JTable tableCleaner = null;
	private JTable tableCaretaker = null;
	private JTable tablePokemon = null;
	private JTable tableEnclosure = null;
	private JTable tableFood = null;

	// Buttons Admin Zone
	private JButton btnEmployee = null;
	private JButton btnCleaner = null;
	private JButton btnCaretakers = null;
	private JButton btnPokemon = null;
	private JButton btnEnclosure = null;
	private JButton btnFood = null;

	// Variables for Tickets
	private int totalTicket = 40;
	private int quantity = 0;
	private double ticketValue = 9.99;

	// JTextFields Tickets
	private JTextField textFieldTicketTotalPrice = null;
	private JTextField textFieldTicketJournal = null;
	private JTextField textFieldTicketDate = null;
	private JTextField textFieldTicketQuantity = null;
	private JTextField textFieldTotalTicket = null;

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
		panelAdmin.setBounds(0, 0, 734, 461);
		frame.getContentPane().add(panelAdmin);
		panelAdmin.setLayout(null);

		JButton btnZooArea = new JButton("Zoo");

		JButton btnWorkerArea = new JButton("Trabajadores");
		btnWorkerArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWorkerArea.setVisible(false);
				btnZooArea.setVisible(true);
			}
		});
		btnWorkerArea.setBackground(new Color(255, 255, 255));
		btnWorkerArea.setBounds(0, 0, 370, 46);
		panelAdmin.add(btnWorkerArea);

		btnZooArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWorkerArea.setVisible(true);
				btnZooArea.setVisible(false);
			}
		});
		btnZooArea.setBackground(new Color(255, 255, 255));
		btnZooArea.setBounds(369, 0, 365, 46);
		panelAdmin.add(btnZooArea);

		// PANEL MAIN
		panelMain = new JPanel();
		panelMain.setBackground(new Color(254, 235, 197));
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
		lblLogo.setBounds(668, 11, 56, 39);
		RSScaleLabel.setScaleLabel(lblLogo, "img/misc/LogoRecortado.png");
		panelMain.add(lblLogo);

		lblAdd = new JLabel("¡¡ Compre sus entradas por " + ticketValue + "€ aqui !!");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchMainPanels("TICKETS");
			}
		});
		lblAdd.setBounds(250, 440, 257, 14);
		panelMain.add(lblAdd);

		JButton btnMap = new JButton("Mapa");
		btnMap.setFocusPainted(false);
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("MAP");
			}
		});
		btnMap.setBackground(new Color(255, 255, 255));
		btnMap.setBounds(10, 61, 186, 39);
		panelMain.add(btnMap);

		JButton btnPokedex = new JButton("Pokedex");
		btnPokedex.setFocusPainted(false);
		btnPokedex.setBackground(new Color(255, 255, 255));
		btnPokedex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("POKEDEX");
			}
		});
		btnPokedex.setBounds(194, 61, 186, 39);
		panelMain.add(btnPokedex);

		JButton btnShop = new JButton("Tienda");
		btnShop.setFocusPainted(false);
		btnShop.setBackground(new Color(255, 255, 255));
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("SHOP");
			}
		});
		btnShop.setBounds(379, 61, 174, 39);
		panelMain.add(btnShop);

		JButton btnTickets = new JButton("Entradas");
		btnTickets.setFocusPainted(false);
		btnTickets.setBackground(new Color(255, 255, 255));
		btnTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMainPanels("TICKETS");
			}
		});
		btnTickets.setBounds(550, 61, 174, 39);
		panelMain.add(btnTickets);

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
		lblMapa1_0.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_0, "img/map/mapa1-0.png");
		panelMapa.add(lblMapa1_0);

		JLabel lblMapa1_1 = new JLabel();
		lblMapa1_1.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_1, "img/map/mapa1-1.png");
		panelMapa.add(lblMapa1_1);

		JLabel lblMapa1_2 = new JLabel();
		lblMapa1_2.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_2, "img/map/mapa1-2.png");
		panelMapa.add(lblMapa1_2);

		JLabel lblMapa1_3 = new JLabel();
		lblMapa1_3.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_3, "img/map/mapa1-3.png");
		panelMapa.add(lblMapa1_3);

		JLabel lblMapa1_4 = new JLabel();
		lblMapa1_4.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_4, "img/map/mapa1-4.png");
		panelMapa.add(lblMapa1_4);

		JLabel lblMapa1_5 = new JLabel();
		lblMapa1_5.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_5, "img/map/mapa1-5.png");
		panelMapa.add(lblMapa1_5);

		JLabel lblMapa1_6 = new JLabel();
		lblMapa1_6.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa1_6, "img/map/mapa1-6.png");
		panelMapa.add(lblMapa1_6);

		JLabel lblMapa2_0 = new JLabel();
		lblMapa2_0.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_0, "img/map/mapa2-0.png");
		panelMapa.add(lblMapa2_0);

		JLabel lblMapa2_1 = new JLabel();
		lblMapa2_1.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_1, "img/map/mapa2-1.png");
		panelMapa.add(lblMapa2_1);

		JLabel lblMapa2_2 = new JLabel();
		lblMapa2_2.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_2, "img/map/mapa2-2.png");
		panelMapa.add(lblMapa2_2);

		JLabel lblMapa2_3 = new JLabel();
		lblMapa2_3.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_3, "img/map/mapa2-3.png");
		panelMapa.add(lblMapa2_3);

		JLabel lblMapa2_4 = new JLabel();
		lblMapa2_4.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_4, "img/map/mapa2-4.png");
		panelMapa.add(lblMapa2_4);

		JLabel lblMapa2_5 = new JLabel();
		lblMapa2_5.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_5, "img/map/mapa2-5.png");
		panelMapa.add(lblMapa2_5);

		JLabel lblMapa2_6 = new JLabel();
		lblMapa2_6.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa2_6, "img/map/mapa2-6.png");
		panelMapa.add(lblMapa2_6);

		JLabel lblMapa3_0 = new JLabel();
		lblMapa3_0.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_0, "img/map/mapa3-0.png");
		panelMapa.add(lblMapa3_0);

		JLabel lblMapa3_1 = new JLabel();
		lblMapa3_1.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_1, "img/map/mapa3-1.png");
		panelMapa.add(lblMapa3_1);

		JLabel lblMapa3_2 = new JLabel();
		lblMapa3_2.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_2, "img/map/mapa3-2.png");
		panelMapa.add(lblMapa3_2);

		JLabel lblMapa3_3 = new JLabel();
		lblMapa3_3.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_3, "img/map/mapa3-3.png");
		panelMapa.add(lblMapa3_3);

		JLabel lblMapa3_4 = new JLabel();
		lblMapa3_4.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_4, "img/map/mapa3-4.png");
		panelMapa.add(lblMapa3_4);

		JLabel lblMapa3_5 = new JLabel();
		lblMapa3_5.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_5, "img/map/mapa3-5.png");
		panelMapa.add(lblMapa3_5);

		JLabel lblMapa3_6 = new JLabel();
		lblMapa3_6.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa3_6, "img/map/mapa3-6.png");
		panelMapa.add(lblMapa3_6);

		JLabel lblMapa4_0 = new JLabel();
		lblMapa4_0.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_0, "img/map/mapa4-0.png");
		panelMapa.add(lblMapa4_0);

		JLabel lblMapa4_1 = new JLabel();
		lblMapa4_1.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_1, "img/map/mapa4-1.png");
		panelMapa.add(lblMapa4_1);

		JLabel lblMapa4_2 = new JLabel();
		lblMapa4_2.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_2, "img/map/mapa4-2.png");
		panelMapa.add(lblMapa4_2);

		JLabel lblMapa4_3 = new JLabel();
		lblMapa4_3.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_3, "img/map/mapa4-3.png");
		panelMapa.add(lblMapa4_3);

		JLabel lblMapa4_4 = new JLabel();
		lblMapa4_4.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_4, "img/map/mapa4-4.png");
		panelMapa.add(lblMapa4_4);

		JLabel lblMapa4_5 = new JLabel();
		lblMapa4_5.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_5, "img/map/mapa4-5.png");
		panelMapa.add(lblMapa4_5);

		JLabel lblMapa4_6 = new JLabel();
		lblMapa4_6.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa4_6, "img/map/mapa4-6.png");
		panelMapa.add(lblMapa4_6);

		JLabel lblMapa5_0 = new JLabel();
		lblMapa5_0.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_0, "img/map/mapa5-0.png");
		panelMapa.add(lblMapa5_0);

		JLabel lblMapa5_1 = new JLabel();
		lblMapa5_1.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_1, "img/map/mapa5-1.png");
		panelMapa.add(lblMapa5_1);

		JLabel lblMapa5_2 = new JLabel();
		lblMapa5_2.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_2, "img/map/mapa5-2.png");
		panelMapa.add(lblMapa5_2);

		JLabel lblMapa5_3 = new JLabel();
		lblMapa5_3.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_3, "img/map/mapa5-3.png");
		panelMapa.add(lblMapa5_3);

		JLabel lblMapa5_4 = new JLabel();
		lblMapa5_4.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_4, "img/map/mapa5-4.png");
		panelMapa.add(lblMapa5_4);

		JLabel lblMapa5_5 = new JLabel();
		lblMapa5_5.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_5, "img/map/mapa5-5.png");
		panelMapa.add(lblMapa5_5);

		JLabel lblMapa5_6 = new JLabel();
		lblMapa5_6.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa5_6, "img/map/mapa5-6.png");
		panelMapa.add(lblMapa5_6);

		JLabel lblMapa6_0 = new JLabel();
		lblMapa6_0.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_0, "img/map/mapa6-0.png");
		panelMapa.add(lblMapa6_0);

		JLabel lblMapa6_1 = new JLabel();
		lblMapa6_1.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_1, "img/map/mapa6-1.png");
		panelMapa.add(lblMapa6_1);

		JLabel lblMapa6_2 = new JLabel();
		lblMapa6_2.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_2, "img/map/mapa6-2.png");
		panelMapa.add(lblMapa6_2);

		JLabel lblMapa6_3 = new JLabel();
		lblMapa6_3.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_3, "img/map/mapa6-3.png");
		panelMapa.add(lblMapa6_3);

		JLabel lblMapa6_4 = new JLabel();
		lblMapa6_4.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_4, "img/map/mapa6-4.png");
		panelMapa.add(lblMapa6_4);

		JLabel lblMapa6_5 = new JLabel();
		lblMapa6_5.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_5, "img/map/mapa6-5.png");
		panelMapa.add(lblMapa6_5);

		JLabel lblMapa6_6 = new JLabel();
		lblMapa6_6.setBounds(0, 0, 104, 55);
		RSScaleLabel.setScaleLabel(lblMapa6_6, "img/map/mapa6-6.png");
		panelMapa.add(lblMapa6_6);

		btnMapSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type1 = null;
				String type2 = null;
				if (managerPokemon == null) {
					managerPokemon = new ManagerPokemon();
				}
				lblMapa6_0.setIcon(new ImageIcon(Views.class.getResource("/map/mapa6-0.png")));
				lblMapa6_0.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa6_0, "img/map/mapa6-0.png");

				lblMapa3_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa3-2.png")));
				lblMapa3_2.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa3_2, "img/map/mapa3-2.png");

				lblMapa2_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-4.png")));
				lblMapa2_4.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa2_4, "img/map/mapa2-4.png");

				lblMapa1_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa1-4.png")));
				lblMapa1_4.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa1_4, "img/map/mapa1-4.png");

				lblMapa2_1.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-1.png")));
				lblMapa2_1.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa2_1, "img/map/mapa2-1.png");

				lblMapa4_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-5.png")));
				lblMapa4_5.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa4_5, "img/map/mapa4-5.png");

				lblMapa5_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa5-5.png")));
				lblMapa5_5.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa5_5, "img/map/mapa5-5.png");

				lblMapa2_3.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-3.png")));
				lblMapa2_3.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa2_3, "img/map/mapa2-3.png");

				lblMapa3_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa3-4.png")));
				lblMapa3_4.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa3_4, "img/map/mapa3-4.png");

				lblMapa1_0.setIcon(new ImageIcon(Views.class.getResource("/map/mapa1-0.png")));
				lblMapa1_0.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa1_0, "img/map/mapa1-0.png");

				lblMapa5_3.setIcon(new ImageIcon(Views.class.getResource("/map/mapa5-3.png")));
				lblMapa5_3.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa5_3, "img/map/mapa5-3.png");

				lblMapa2_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-2.png")));
				lblMapa2_2.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa2_2, "img/map/mapa2-2.png");

				lblMapa4_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-4.png")));
				lblMapa4_4.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa4_4, "img/map/mapa4-4.png");

				lblMapa5_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa5-4.png")));
				lblMapa5_4.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa5_4, "img/map/mapa5-4.png");

				lblMapa4_1.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-1.png")));
				lblMapa4_1.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa4_1, "img/map/mapa4-1.png");

				lblMapa6_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa6-5.png")));
				lblMapa6_5.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa6_5, "img/map/mapa6-5.png");

				lblMapa4_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-2.png")));
				lblMapa4_2.setBounds(0, 0, 104, 55);
				RSScaleLabel.setScaleLabel(lblMapa4_2, "img/map/mapa4-2.png");

				Pokemon pokemonSeleccionado = managerPokemon.getPokemonByName(textFieldAllPokemons.getText());
				if (pokemonSeleccionado != null) {
					type1 = pokemonSeleccionado.getTypeP();
					if (pokemonSeleccionado.getTypeS() != null) {
						type2 = pokemonSeleccionado.getTypeS();
					}
				}
				if (type1 == null) {
					type1 = "";
				}
				if (type2 == null) {
					type2 = "";
				}
				if (type1.equalsIgnoreCase("Bicho") || type2.equalsIgnoreCase("Bicho")) {
					lblMapa6_0.setIcon(new ImageIcon(Views.class.getResource("/map/mapa6-0-Alter.png")));
					lblMapa6_0.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa6_0, "img/map/mapa6-0-Alter.png");
				}
				if (type1.equalsIgnoreCase("Dragon") || type2.equalsIgnoreCase("Dragon")) {
					lblMapa3_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa3-2-Alter.png")));
					lblMapa3_2.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa3_2, "img/map/mapa3-2-Alter.png");
				}
				if (type1.equalsIgnoreCase("Electrico") || type2.equalsIgnoreCase("Electrico")) {
					lblMapa2_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-4-Alter.png")));
					lblMapa2_4.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa2_4, "img/map/mapa2-4-Alter.png");
				}
				if (type1.equalsIgnoreCase("Hada") || type2.equalsIgnoreCase("Hada")) {
					lblMapa1_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa1-4-Alter.png")));
					lblMapa1_4.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa1_4, "img/map/mapa1-4-Alter.png");
				}
				if (type1.equalsIgnoreCase("Lucha") || type2.equalsIgnoreCase("Lucha")) {
					lblMapa2_1.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-1-Alter.png")));
					lblMapa2_1.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa2_1, "img/map/mapa2-1-Alter.png");
				}
				if (type1.equalsIgnoreCase("Fuego") || type2.equalsIgnoreCase("Fuego")) {
					lblMapa4_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-5-Alter.png")));
					lblMapa4_5.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa4_5, "img/map/mapa4-5-Alter.png");
				}
				if (type1.equalsIgnoreCase("Volador") || type2.equalsIgnoreCase("Volador")) {
					lblMapa5_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa5-5-Alter.png")));
					lblMapa5_5.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa5_5, "img/map/mapa5-5-Alter.png");
				}
				if (type1.equalsIgnoreCase("Fantasma") || type2.equalsIgnoreCase("Fantasma")) {
					lblMapa2_3.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-3-Alter.png")));
					lblMapa2_3.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa2_3, "img/map/mapa2-3-Alter.png");
				}
				if (type1.equalsIgnoreCase("Planta") || type2.equalsIgnoreCase("Planta")) {
					lblMapa3_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa3-4-Alter.png")));
					lblMapa3_4.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa3_4, "img/map/mapa3-4-Alter.png");
				}
				if (type1.equalsIgnoreCase("Tierra") || type2.equalsIgnoreCase("Tierra")) {
					lblMapa1_0.setIcon(new ImageIcon(Views.class.getResource("/map/mapa1-0-Alter.png")));
					lblMapa1_0.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa1_0, "img/map/mapa1-0-Alter.png");
				}
				if (type1.equalsIgnoreCase("Hielo") || type2.equalsIgnoreCase("Hielo")) {
					lblMapa5_3.setIcon(new ImageIcon(Views.class.getResource("/map/mapa5-3-Alter.png")));
					lblMapa5_3.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa5_3, "img/map/mapa5-3-Alter.png");
				}
				if (type1.equalsIgnoreCase("Normal") || type2.equalsIgnoreCase("Normal")) {
					lblMapa2_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa2-2-Alter.png")));
					lblMapa2_2.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa2_2, "img/map/mapa2-2-Alter.png");
				}
				if (type1.equalsIgnoreCase("Veneno") || type2.equalsIgnoreCase("Veneno")) {
					lblMapa4_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-4-Alter.png")));
					lblMapa4_4.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa4_4, "img/map/mapa4-4-Alter.png");
				}
				if (type1.equalsIgnoreCase("Psiquico") || type2.equalsIgnoreCase("Psiquico")) {
					lblMapa5_4.setIcon(new ImageIcon(Views.class.getResource("/map/mapa5-4-Alter.png")));
					lblMapa5_4.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa5_4, "img/map/mapa5-4-Alter.png");
				}
				if (type1.equalsIgnoreCase("Roca") || type2.equalsIgnoreCase("Roca")) {
					lblMapa4_1.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-1-Alter.png")));
					lblMapa4_1.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa4_1, "img/map/mapa4-1-Alter.png");
				}
				if (type1.equalsIgnoreCase("Acero") || type2.equalsIgnoreCase("Acero")) {
					lblMapa6_5.setIcon(new ImageIcon(Views.class.getResource("/map/mapa6-5-Alter.png")));
					lblMapa6_5.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa6_5, "img/map/mapa6-5-Alter.png");
				}
				if (type1.equalsIgnoreCase("Agua") || type2.equalsIgnoreCase("Agua")) {
					lblMapa4_2.setIcon(new ImageIcon(Views.class.getResource("/map/mapa4-2-Alter.png")));
					lblMapa4_2.setBounds(0, 0, 104, 55);
					RSScaleLabel.setScaleLabel(lblMapa4_2, "img/map/mapa4-2-Alter.png");
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
		textPokemonName.setBackground(new Color(251, 236, 171));
		textPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonName.setBounds(131, 15, 175, 30);
		textPokemonName.setEditable(false);
		panelPokedex.add(textPokemonName);

		JLabel lblInfoEggGroup = new JLabel("G.Huevo:");
		lblInfoEggGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoEggGroup.setBounds(20, 50, 105, 30);
		panelPokedex.add(lblInfoEggGroup);

		JTextArea textPokemonEggGroup = new JTextArea();
		textPokemonEggGroup.setBackground(new Color(251, 236, 171));
		textPokemonEggGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonEggGroup.setBounds(131, 53, 175, 30);
		textPokemonEggGroup.setEditable(false);
		panelPokedex.add(textPokemonEggGroup);

		JLabel lblInfoTypes = new JLabel("Tipo/s :");
		lblInfoTypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoTypes.setBounds(20, 90, 85, 30);
		panelPokedex.add(lblInfoTypes);

		JTextField textPokemonTypeP = new JTextField();
		textPokemonTypeP.setBackground(new Color(251, 236, 171));
		textPokemonTypeP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonTypeP.setHorizontalAlignment(JTextField.CENTER);
		textPokemonTypeP.setBounds(131, 90, 90, 30);
		textPokemonTypeP.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textPokemonTypeP.setEditable(false);
		textPokemonTypeP.setVisible(false);
		panelPokedex.add(textPokemonTypeP);

		JTextField textPokemonTypeS = new JTextField();
		textPokemonTypeS.setBackground(new Color(251, 236, 171));
		textPokemonTypeS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonTypeS.setHorizontalAlignment(JTextField.CENTER);
		textPokemonTypeS.setBounds(224, 90, 90, 30);
		textPokemonTypeS.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textPokemonTypeS.setEditable(false);
		textPokemonTypeS.setVisible(false);
		panelPokedex.add(textPokemonTypeS);

		JLabel lblDescription = new JLabel("Descripcion :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(20, 120, 200, 44);
		panelPokedex.add(lblDescription);

		JTextArea textPokemonDescription = new JTextArea();
		textPokemonDescription.setBackground(new Color(251, 236, 171));
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
				textPokemonTypeS.setVisible(true);
				textPokemonTypeP.setBackground(new Color(251, 236, 171));
				textPokemonTypeS.setBackground(new Color(251, 236, 171));
				if (null == managerPokemon) {
					managerPokemon = new ManagerPokemon();
				}
				if (textSearch.getText().matches("[0-9]+")) {
					pokemonSeleccionado = managerPokemon.getPokemonByNumPokedex(Integer.parseInt(textSearch.getText()));
				} else if (managerPokemon.getPokemonByName(textSearch.getText()) != null) {
					pokemonSeleccionado = managerPokemon.getPokemonByName(textSearch.getText());
				}

				if (pokemonSeleccionado == null) {
					pokemonSeleccionado = new Pokemon();
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
				lblSelectedPokemonImage.setBounds(550, 20, 110, 90);
				RSScaleLabel.setScaleLabel(lblSelectedPokemonImage,
						"img/pokemon/" + pokemonSeleccionado.getIdPokemon() + ".png");
				if (pokemonSeleccionado.getTypeP() != "") {
					textPokemonTypeP.setVisible(true);
					if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Bicho")) {
						textPokemonTypeP.setBackground(new Color(146, 170, 41, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Dragon")) {
						textPokemonTypeP.setBackground(new Color(97, 57, 204, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Electrico")) {
						textPokemonTypeP.setBackground(new Color(229, 218, 67, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Hada")) {
						textPokemonTypeP.setBackground(new Color(215, 161, 211, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Lucha")) {
						textPokemonTypeP.setBackground(new Color(177, 47, 33, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Fuego")) {
						textPokemonTypeP.setBackground(new Color(238, 130, 44, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Volador")) {
						textPokemonTypeP.setBackground(new Color(164, 147, 217, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Fantasma")) {
						textPokemonTypeP.setBackground(new Color(106, 88, 146, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Planta")) {
						textPokemonTypeP.setBackground(new Color(116, 191, 94, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Tierra")) {
						textPokemonTypeP.setBackground(new Color(226, 210, 117, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Hielo")) {
						textPokemonTypeP.setBackground(new Color(139, 220, 203, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Normal")) {
						textPokemonTypeP.setBackground(new Color(166, 172, 129, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Veneno")) {
						textPokemonTypeP.setBackground(new Color(139, 83, 142, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Psiquico")) {
						textPokemonTypeP.setBackground(new Color(234, 117, 145, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Roca")) {
						textPokemonTypeP.setBackground(new Color(181, 164, 49, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Acero")) {
						textPokemonTypeP.setBackground(new Color(179, 182, 207, 255));
					} else if (pokemonSeleccionado.getTypeP().equalsIgnoreCase("Agua")) {
						textPokemonTypeP.setBackground(new Color(108, 143, 228, 255));
					}
				} else {
					textPokemonTypeP.setVisible(false);
				}
				if (pokemonSeleccionado.getTypeS() == null) {
					textPokemonTypeS.setVisible(false);
				} else {
					textPokemonTypeP.setVisible(true);
					textPokemonTypeS.setText(pokemonSeleccionado.getTypeS());
					if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Bicho")) {
						textPokemonTypeS.setBackground(new Color(146, 170, 41, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Dragon")) {
						textPokemonTypeS.setBackground(new Color(97, 57, 204, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Electrico")) {
						textPokemonTypeS.setBackground(new Color(229, 218, 67, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Hada")) {
						textPokemonTypeS.setBackground(new Color(215, 161, 211, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Lucha")) {
						textPokemonTypeS.setBackground(new Color(177, 47, 33, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Fuego")) {
						textPokemonTypeS.setBackground(new Color(238, 130, 44, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Volador")) {
						textPokemonTypeS.setBackground(new Color(164, 147, 217, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Fantasma")) {
						textPokemonTypeS.setBackground(new Color(106, 88, 146, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Planta")) {
						textPokemonTypeS.setBackground(new Color(116, 191, 94, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Tierra")) {
						textPokemonTypeS.setBackground(new Color(226, 210, 117, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Hielo")) {
						textPokemonTypeS.setBackground(new Color(139, 220, 203, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Normal")) {
						textPokemonTypeS.setBackground(new Color(166, 172, 129, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Veneno")) {
						textPokemonTypeS.setBackground(new Color(139, 83, 142, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Psiquico")) {
						textPokemonTypeS.setBackground(new Color(234, 117, 145, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Roca")) {
						textPokemonTypeS.setBackground(new Color(181, 164, 49, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Acero")) {
						textPokemonTypeS.setBackground(new Color(179, 182, 207, 255));
					} else if (pokemonSeleccionado.getTypeS().equalsIgnoreCase("Agua")) {
						textPokemonTypeS.setBackground(new Color(108, 143, 228, 255));
					}
				}
				textPokemonDescription.setText(pokemonSeleccionado.getDescriptionPo());
			}
		});
		panelPokedex.add(btnSearch);

		JLabel lblPokedexImage = new JLabel();
		lblPokedexImage.setBounds(0, 0, 714, 314);
		lblPokedexImage.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/misc/Pokedex.png")).getImage()
				.getScaledInstance(714, 314, Image.SCALE_DEFAULT)));
		panelPokedex.add(lblPokedexImage);

		// PANEL MAIN SHOP
		panelShop = new JPanel();
		panelShop.setVisible(false);
		panelShop.setBounds(10, 111, 714, 328);
		panelMain.add(panelShop);
		panelShop.setLayout(null);

		JLabel lblShopImage1 = new JLabel("New label");
		lblShopImage1.setBounds(136, 66, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage1, "img/products/Eevee Primavera.png");
		lblShopImage1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("Nombre: Eevee Primavera");
				JLabel site = new JLabel("Ubicación: Disponible en la tienda del PokeZoo");

				Object[] message = { productName, site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage1);

		JLabel lblShopImage2 = new JLabel("New label");
		lblShopImage2.setBounds(253, 66, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage2, "img/products/Juego de ajedrez Pokémon.png");
		lblShopImage2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("-Ajedrez Pokemon");
				JLabel site = new JLabel("-Disponible en la tienda del PokeZoo");

				Object[] message = { "Nombre: ", productName, "Ubicación: ", site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage2);

		JLabel lblShopImage3 = new JLabel("New label");
		lblShopImage3.setBounds(373, 66, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage3, "img/products/Maceta grande Pokémon.png");
		lblShopImage3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("-Maceta Pokemon");
				JLabel site = new JLabel("-Disponible en la tienda del PokeZoo");

				Object[] message = { "Nombre: ", productName, "Ubicación: ", site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage3);

		JLabel lblShopImage4 = new JLabel("label4");
		lblShopImage4.setBounds(472, 66, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage4, "img/products/Lapras Flotador de Piscina.png");
		lblShopImage4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("-Flotador Lapras");
				JLabel site = new JLabel("-Disponible en la tienda del PokeZoo");

				Object[] message = { "Nombre: ", productName, "Ubicación: ", site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage4);

		JLabel lblShopImage5 = new JLabel("Marco");
		lblShopImage5.setBounds(136, 162, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage5, "img/products/Marco para diploma de graduación Pikachu.png");
		lblShopImage5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("-Marco Pokemon de Pikachu");
				JLabel site = new JLabel("-Disponible en la tienda del PokeZoo");

				Object[] message = { "Nombre: ", productName, "Ubicación: ", site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage5);

		JLabel lblShopImage6 = new JLabel("New label");
		lblShopImage6.setBounds(253, 162, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage6, "img/products/Mareep Llavero de peluche.png");
		lblShopImage6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("-LLavero Mareep de peluche");
				JLabel site = new JLabel("-Disponible en la tienda del PokeZoo");

				Object[] message = { "Nombre: ", productName, "Ubicación: ", site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage6);

		JLabel lblShopImage7 = new JLabel("New label");
		lblShopImage7.setBounds(373, 162, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage7, "img/products/Peluche Oshawott Sentado.png");
		lblShopImage7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("-Peluche Oshawott");
				JLabel site = new JLabel("-Disponible en la tienda del PokeZoo");

				Object[] message = { "Nombre: ", productName, "Ubicación: ", site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage7);

		JLabel lblShopImage8 = new JLabel("New label");
		lblShopImage8.setBounds(472, 162, 89, 85);
		RSScaleLabel.setScaleLabel(lblShopImage8, "img/products/PikachuMood-Hungry.png");
		lblShopImage8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel productName = new JLabel("-Figura de Pikachu comiendo");
				JLabel site = new JLabel("-Disponible en la tienda del PokeZoo");

				Object[] message = { "Nombre: ", productName, "Ubicación: ", site };

				JOptionPane.showMessageDialog(null, message, "Producto", JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelShop.add(lblShopImage8);

		JLabel lblShopBackground = new JLabel("");
		lblShopBackground.setBounds(0, 0, 714, 328);
		RSScaleLabel.setScaleLabel(lblShopBackground, "img/misc/shopBackground.jpg");
		panelShop.add(lblShopBackground);

		// PANEL MAIN TICKETS
		panelTickets = new JPanel();
		panelTickets.setVisible(false);
		panelTickets.setBounds(10, 111, 714, 328);
		panelMain.add(panelTickets);
		panelTickets.setLayout(null);

		JButton btnTicketMore = new JButton("");
		ImageIcon imageMore = new ImageIcon("img/misc/plus.png");
		int heightMore = 23;
		int widthMore = 27;
		ImageIcon iconoEscalaMore = new ImageIcon(
				imageMore.getImage().getScaledInstance(widthMore, heightMore, java.awt.Image.SCALE_DEFAULT));
		btnTicketMore.setIcon(iconoEscalaMore);
		btnTicketMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantityPlusOne();
			}
		});
		btnTicketMore.setBounds(585, 75, 27, 23);
		btnTicketMore.setBorder(null);

		JButton btnTicketLess = new JButton("");
		ImageIcon imageLess = new ImageIcon("img/misc/minus.png");
		int heightLess = 23;
		int widthLess = 27;
		ImageIcon iconoEscalaLess = new ImageIcon(
				imageLess.getImage().getScaledInstance(widthLess, heightLess, java.awt.Image.SCALE_DEFAULT));
		btnTicketLess.setIcon(iconoEscalaLess);
		btnTicketLess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantityMinusOne();
			}
		});
		btnTicketLess.setBounds(525, 75, 27, 23);
		btnTicketLess.setBorder(null);
		panelTickets.add(btnTicketLess);

		textFieldTicketTotalPrice = new JTextField();
		textFieldTicketTotalPrice.setText("0");
		textFieldTicketTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTicketTotalPrice.setColumns(10);
		textFieldTicketTotalPrice.setBounds(525, 158, 78, 20);
		textFieldTicketTotalPrice.setEditable(false);

		textFieldTicketJournal = new JTextField();
		textFieldTicketJournal.setText("10:00-17:00");
		textFieldTicketJournal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTicketJournal.setColumns(10);
		textFieldTicketJournal.setBounds(140, 153, 86, 21);
		textFieldTicketJournal.setEditable(false);

		JLabel lblTotalPriceEuro = new JLabel("€");
		lblTotalPriceEuro.setBounds(607, 160, 19, 14);
		panelTickets.add(lblTotalPriceEuro);

		JLabel lblIndividualTicketPrice = new JLabel(ticketValue + " €");
		if (ticketValue >= 10) {
			lblIndividualTicketPrice.setBounds(572, 120, 80, 14);
		} else {
			lblIndividualTicketPrice.setBounds(580, 120, 80, 14);
		}
		panelTickets.add(lblIndividualTicketPrice);

		textFieldTicketDate = new JTextField();
		textFieldTicketDate.setBounds(140, 110, 86, 21);
		panelTickets.add(textFieldTicketDate);
		textFieldTicketDate.setEditable(false);
		textFieldTicketDate.setColumns(10);
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String today = formatter.format(date);
		textFieldTicketDate.setText(today);
		textFieldTicketDate.setHorizontalAlignment(SwingConstants.CENTER);
		panelTickets.add(textFieldTicketJournal);

		textFieldTicketQuantity = new JTextField();
		textFieldTicketQuantity.setText("0");
		textFieldTicketQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTicketQuantity.setBounds(555, 75, 27, 23);
		panelTickets.add(textFieldTicketQuantity);
		textFieldTicketQuantity.setEditable(false);
		textFieldTicketQuantity.setColumns(10);
		panelTickets.add(textFieldTicketTotalPrice);

		textFieldTotalTicket = new JTextField();
		textFieldTotalTicket.setBounds(175, 271, 66, 20);
		panelTickets.add(textFieldTotalTicket);
		textFieldTotalTicket.setEditable(false);
		textFieldTotalTicket.setText(Integer.toString(totalTicket));
		textFieldTotalTicket.setHorizontalAlignment(SwingConstants.CENTER);
		panelTickets.add(btnTicketMore);

		JLabel lblTotalPrice = new JLabel("Total");
		lblTotalPrice.setBounds(460, 160, 46, 14);
		panelTickets.add(lblTotalPrice);

		JLabel lblPriceTicket = new JLabel("Precio");
		lblPriceTicket.setBounds(460, 120, 46, 14);
		panelTickets.add(lblPriceTicket);

		JLabel lblTicketQuantity = new JLabel("Cantidad");
		lblTicketQuantity.setBounds(460, 75, 58, 14);
		panelTickets.add(lblTicketQuantity);

		JLabel lblTicketCount = new JLabel("Entradas restantes");
		lblTicketCount.setBounds(58, 274, 130, 14);
		panelTickets.add(lblTicketCount);

		JLabel labelTicketDate = new JLabel("Fecha");
		labelTicketDate.setBounds(70, 110, 66, 21);
		panelTickets.add(labelTicketDate);

		JLabel lblTicketJournal = new JLabel("Horario");
		lblTicketJournal.setBounds(70, 153, 66, 21);
		panelTickets.add(lblTicketJournal);

		JLabel lblTicketDates = new JLabel("");
		lblTicketDates.setBounds(50, 90, 200, 100);
		RSScaleLabel.setScaleLabel(lblTicketDates, "img/misc/marco2.png");
		panelTickets.add(lblTicketDates);

		JLabel lblTicketQuantitys = new JLabel("");
		lblTicketQuantitys.setBounds(440, 50, 200, 170);
		RSScaleLabel.setScaleLabel(lblTicketQuantitys, "img/misc/marco.png");
		panelTickets.add(lblTicketQuantitys);

		JLabel labelTickets = new JLabel("");
		labelTickets.setBounds(40, 263, 220, 38);
		RSScaleLabel.setScaleLabel(labelTickets, "img/misc/marco2.png");
		panelTickets.add(labelTickets);

		JButton btnBuyTickets = new JButton("Comprar");
		btnBuyTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyTicket();
			}
		});
		btnBuyTickets.setBounds(551, 279, 98, 38);
		panelTickets.add(btnBuyTickets);

		JLabel lblTicketBackground = new JLabel("");
		lblTicketBackground.setBounds(0, 0, 714, 328);
		RSScaleLabel.setScaleLabel(lblTicketBackground, "img/misc/ticketsBackground.jpg");
		panelTickets.add(lblTicketBackground);

		// PANEL ADMIN WELCOME
		panelAdminWelcome = new JPanel();
		panelAdminWelcome.setBounds(10, 57, 714, 381);
		panelAdminWelcome.setVisible(true);
		panelAdmin.add(panelAdminWelcome);
		panelAdminWelcome.setLayout(null);

		JLabel lblImageWorkers = new JLabel("(worker image)");
		lblImageWorkers.setBounds(56, 53, 139, 244);
		RSScaleLabel.setScaleLabel(lblImageWorkers, "img/misc/worker.png");
		panelAdminWelcome.add(lblImageWorkers);

		JLabel lblImageZoo = new JLabel("(zoo image)");
		lblImageZoo.setBounds(450, 53, 254, 244);
		RSScaleLabel.setScaleLabel(lblImageZoo, "img/misc/victini.png");
		panelAdminWelcome.add(lblImageZoo);

		JLabel lblBgWelcomeAdmin = new JLabel("");
		lblBgWelcomeAdmin.setBounds(0, 0, 714, 381);
		RSScaleLabel.setScaleLabel(lblBgWelcomeAdmin, "img/misc/pokeballbg.jpg");
		panelAdminWelcome.add(lblBgWelcomeAdmin);

		btnEmployee = new JButton("Oficinistas");
		btnEmployee.setFocusPainted(false);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(1);
				lblInfoTabla.setText("Tabla Oficinistas");
				loadTableEmployeeData(tableEmployee);
				setAllButtonsBackgroundToWhite();
				btnEmployee.setBackground(Color.GRAY);
			}
		});
		btnEmployee.setBackground(Color.WHITE);
		btnEmployee.setBounds(0, 0, 117, 46);
		panelAdmin.add(btnEmployee);

		btnCleaner = new JButton("Limpiadores");
		btnCleaner.setFocusPainted(false);
		btnCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(2);
				lblInfoTabla.setText("Tabla Limpiadores");
				loadTableCleanerData(tableCleaner);
				setAllButtonsBackgroundToWhite();
				btnCleaner.setBackground(Color.GRAY);
			}
		});
		btnCleaner.setBackground(Color.WHITE);
		btnCleaner.setBounds(117, 0, 135, 46);
		panelAdmin.add(btnCleaner);

		btnCaretakers = new JButton("Cuidadores");
		btnCaretakers.setFocusPainted(false);
		btnCaretakers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(3);
				lblInfoTabla.setText("Tabla Cuidadores");
				loadTableCaretakerData(tableCaretaker);
				setAllButtonsBackgroundToWhite();
				btnCaretakers.setBackground(Color.GRAY);
			}
		});
		btnCaretakers.setBackground(Color.WHITE);
		btnCaretakers.setBounds(252, 0, 117, 46);
		panelAdmin.add(btnCaretakers);

		btnPokemon = new JButton("Pokemons");
		btnPokemon.setFocusPainted(false);
		btnPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(4);
				lblInfoTabla.setText("Tabla Pokemons");
				loadTablePokemonData(tablePokemon);
				setAllButtonsBackgroundToWhite();
				btnPokemon.setBackground(Color.GRAY);
			}
		});
		btnPokemon.setBackground(Color.WHITE);
		btnPokemon.setBounds(369, 0, 117, 46);
		panelAdmin.add(btnPokemon);

		btnEnclosure = new JButton("Recintos");
		btnEnclosure.setFocusPainted(false);
		btnEnclosure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(5);
				lblInfoTabla.setText("Tabla Recintos");
				loadTableEnclosureData(tableEnclosure);
				setAllButtonsBackgroundToWhite();
				btnEnclosure.setBackground(Color.GRAY);
			}
		});
		btnEnclosure.setBackground(Color.WHITE);
		btnEnclosure.setBounds(486, 0, 131, 46);
		panelAdmin.add(btnEnclosure);

		btnFood = new JButton("Alimento");
		btnFood.setFocusPainted(false);
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAdminPanels(6);
				lblInfoTabla.setText("Tabla Comida");
				loadTableFoodData(tableFood);
				setAllButtonsBackgroundToWhite();
				btnFood.setBackground(Color.GRAY);
			}
		});
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
					if (!dni.getText().matches("[0-9]{8,8}[A-Za-z]")) {
						JOptionPane.showMessageDialog(null,
								"El DNI del oficinista tiene un formato invalido, debe ser 8 Numeros y 1 Letra!",
								"Oye!", JOptionPane.ERROR_MESSAGE);
						// TODO Add regex to Name and Surname
					} else if (name.getText().isEmpty() || surName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Oficinista!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else if (username.getText().isEmpty() || password.getPassword().length == 0) {
						JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Usuario!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else {
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

							if (managerUser.checkUserNameExists(userToInsert.getUsername())) {
								JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe en el sistema",
										"Oye!", JOptionPane.ERROR_MESSAGE);
							} else {
								managerUser.insert(userToInsert);
								userToInsert = managerUser.selectUserByUsernameAndPasswd(userToInsert.getUsername(),
										userToInsert.getPasswd());
								employeToInsert.setUser(userToInsert);
								managerEmployee.insert(employeToInsert);
								JOptionPane.showMessageDialog(null, "Empleado registrado correctamente", "Yay!",
										JOptionPane.INFORMATION_MESSAGE);
								loadTableEmployeeData(tableEmployee);
							}
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
				Employee selectedEmployee = null;
				try {
					selectedEmployee = getSelectedEmployee();

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
					password.setText(selectedEmployee.getUser().getPasswd());

					Object[] message = { "DNI: ", dni, "Nombre: *", name, "Apellido: *", surName, "Telefono:", phone,
							"Username: *", username, "Password: ", password };

					int option = JOptionPane.showConfirmDialog(null, message, "Modificar Oficinista",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						int confimation = JOptionPane.showConfirmDialog(null,
								"¿Estas seguro de que deseas realizar los cambios?", "Confirmacion",
								JOptionPane.OK_CANCEL_OPTION);
						if (confimation == JOptionPane.OK_OPTION) {
							selectedEmployee
									.setIdEmployee(managerEmployee.getEmployeeIdByDni(selectedEmployee.getDni()));
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
				} catch (EmployeeNotSelected e2) {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para modificar.", "¡Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModifyEmployee.setBounds(180, 336, 141, 23);
		panelAdminEmployee.add(btnModifyEmployee);

		JButton btnDeleteEmployee = new JButton("Borrar Empleado");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee selectedEmployee = null;
				try {
					selectedEmployee = getSelectedEmployee();

					int confimation = JOptionPane.showConfirmDialog(null,
							"¿Estas seguro de que deseas borrar el empleado?", "Confirmacion",
							JOptionPane.OK_CANCEL_OPTION);
					if (confimation == JOptionPane.OK_OPTION) {
						deleteSelectedEmployee(selectedEmployee);
					}
				} catch (EmployeeNotSelected e1) {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para modificar.", "¡Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteEmployee.setBounds(399, 336, 141, 23);
		panelAdminEmployee.add(btnDeleteEmployee);

		JButton btnBlockEmployee = new JButton("Bloquear Empleado");
		btnBlockEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee selectedEmployee = null;
				try {
					selectedEmployee = getSelectedEmployee();

					int confimation = JOptionPane.showConfirmDialog(null,
							"¿Estas seguro de que deseas BLOQUEAR el empleado?", "Confirmacion",
							JOptionPane.OK_CANCEL_OPTION);
					if (confimation == JOptionPane.OK_OPTION) {
						blockSelectedEmployee(selectedEmployee);
					}

					loadTableEmployeeData(tableEmployee);
				} catch (EmployeeNotSelected e1) {
					JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para modificar.", "¡Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBlockEmployee.setBounds(563, 336, 141, 23);
		panelAdminEmployee.add(btnBlockEmployee);

		// PANEL CLEANER
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

				int option = JOptionPane.showConfirmDialog(null, message, "Registrar nuevo Oficinista",
						JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (!dni.getText().matches("[0-9]{8,8}[A-Za-z]")) {
						JOptionPane.showMessageDialog(null,
								"El DNI del oficinista tiene un formato invalido, debe ser 8 Numeros y 1 Letra!",
								"Oye!", JOptionPane.ERROR_MESSAGE);
					} else if (name.getText().isEmpty() || surName.getText().isEmpty()
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
				// TODO Update Cleaner Method			
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
					deleteSelectedEmployee(selectedCleaner);
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
					blockSelectedEmployee(selectedCleaner);
				}

				loadTableCleanerData(tableCleaner);
			}
		});
		btnBlockCleaner.setBounds(563, 336, 141, 23);
		panelAdminCleaner.add(btnBlockCleaner);

		// PANEL Caretaker
		panelAdminCaretaker = new JPanel();
		panelAdminCaretaker.setBounds(10, 68, 714, 370);
		panelAdmin.add(panelAdminCaretaker);
		panelAdminCaretaker.setLayout(null);
		panelAdminCaretaker.setVisible(false);

		JScrollPane scrollPaneTableCaretaker = new JScrollPane();
		scrollPaneTableCaretaker.setBounds(10, 11, 694, 321);
		panelAdminCaretaker.add(scrollPaneTableCaretaker);

		tableCaretaker = new JTable();
		scrollPaneTableCaretaker.setViewportView(tableCaretaker);

		tableCaretaker.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCaretaker.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "DNI", "Nombre", "Apellido", "Telf.", "Bloqueado", "usuario", "Comidas" }));
		tableCaretaker.setDefaultEditor(Object.class, null);

		JButton btnAddNewCaretaker = new JButton("Añadir Cuidador");
		btnAddNewCaretaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Add Caretaker
			}
		});
		btnAddNewCaretaker.setBounds(10, 336, 150, 23);
		panelAdminCaretaker.add(btnAddNewCaretaker);

		JButton btnModifyCaretaker = new JButton("Modificar Cuidador");
		btnModifyCaretaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Update Caretaker method		
			}
		});
		btnModifyCaretaker.setBounds(180, 336, 141, 23);
		panelAdminCaretaker.add(btnModifyCaretaker);

		JButton btnDeleteCaretaker = new JButton("Borrar Cuidador");
		btnDeleteCaretaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Delete Caretaker method
			}
		});
		btnDeleteCaretaker.setBounds(399, 336, 141, 23);
		panelAdminCaretaker.add(btnDeleteCaretaker);

		JButton btnBlockCaretaker = new JButton("Bloquear Cuidador");
		btnBlockCaretaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Block Caretaker method
			}
		});
		btnBlockCaretaker.setBounds(563, 336, 141, 23);
		panelAdminCaretaker.add(btnBlockCaretaker);

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
				new String[] { "Pokedex", "Nombre", "Grupo huevo", "Tipo P", "Tipo S", "Alimento" }));
		tablePokemon.setDefaultEditor(Object.class, null);

		JButton btnAddNewPokemon = new JButton("Añadir Pokemon");
		btnAddNewPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (null == managerFood) {
					managerFood = new ManagerFood();
				}
				JTextField id = new JTextField();
				JTextField namePo = new JTextField();
				JTextField eggGroup = new JTextField();
				JComboBox<String> typeP = new JComboBox<String>();
				JComboBox<String> typeS = new JComboBox<String>();
				JComboBox<String> comboFoods = new JComboBox<String>();

				String[] allTypes = new String[] { "Bicho", "Dragón", "Eléctrico", "Hada", "Lucha", "Fuego", "Volador",
						"Fantasma", "Planta", "Tierra", "Hielo", "Normal", "Veneno", "Psíquico", "Roca", "Acero",
						"Agua" };
				typeP.setModel(new DefaultComboBoxModel<String>(allTypes));

				allTypes = new String[] { "", "Bicho", "Dragón", "Eléctrico", "Hada", "Lucha", "Fuego", "Volador",
						"Fantasma", "Planta", "Tierra", "Hielo", "Normal", "Veneno", "Psíquico", "Roca", "Acero",
						"Agua" };
				typeS.setModel(new DefaultComboBoxModel<String>(allTypes));

				ArrayList<String> allFoods = managerFood.selectAllFoodNames();
				comboFoods.setModel(new DefaultComboBoxModel<String>(allFoods.toArray(new String[0])));

				Object[] message = { "Id Pokemon: ", id, "Nombre: ", namePo, "Grupo huevo: ", eggGroup,
						"Tipo principal:", typeP, "Tipo secundario: ", typeS, "Alimento", comboFoods };

				int option = JOptionPane.showConfirmDialog(null, message, "Registrar nuevo Pokemon",
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
						pokemonToInsert.setTypeP((String) typeP.getSelectedItem());
						pokemonToInsert.setTypeS((String) typeS.getSelectedItem());

						String nameFood = String.valueOf(comboFoods.getSelectedItem());
						pokemonToInsert.setFood(managerFood.selectFoodByName(nameFood));

						try {
							if (null == managerPokemon) {
								managerPokemon = new ManagerPokemon();
							}
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
		btnAddNewPokemon.setBounds(10, 336, 224, 23);
		panelAdminPokemon.add(btnAddNewPokemon);

		JButton btnModifyPokemon = new JButton("Modificar Pokemon");
		btnModifyPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon selectedPokemon = getSelectedPokemon();

				if (null != selectedPokemon) {
					JLabel id = new JLabel();
					id.setText(Integer.toString(selectedPokemon.getIdPokemon()));
					JTextField namePo = new JTextField();
					namePo.setText(selectedPokemon.getNamePo());
					JTextField eggGroup = new JTextField();
					eggGroup.setText(selectedPokemon.getEggGroup());
					JComboBox<String> typeP = new JComboBox<String>();
					JComboBox<String> typeS = new JComboBox<String>();
					JComboBox<String> comboFoods = new JComboBox<String>();

					if (null == managerFood) {
						managerFood = new ManagerFood();
					}

					String[] allTypes = new String[] { "Bicho", "Dragón", "Eléctrico", "Hada", "Lucha", "Fuego",
							"Volador", "Fantasma", "Planta", "Tierra", "Hielo", "Normal", "Veneno", "Psíquico", "Roca",
							"Acero", "Agua" };
					typeP.setModel(new DefaultComboBoxModel<String>(allTypes));
					typeP.setSelectedItem(selectedPokemon.getTypeP());

					allTypes = new String[] { "", "Bicho", "Dragón", "Eléctrico", "Hada", "Lucha", "Fuego", "Volador",
							"Fantasma", "Planta", "Tierra", "Hielo", "Normal", "Veneno", "Psíquico", "Roca", "Acero",
							"Agua" };
					typeS.setModel(new DefaultComboBoxModel<String>(allTypes));
					typeS.setSelectedItem(selectedPokemon.getTypeS());

					ArrayList<String> allFoods = managerFood.selectAllFoodNames();

					comboFoods.setModel(new DefaultComboBoxModel<String>(allFoods.toArray(new String[0])));
					comboFoods.setSelectedIndex(selectedPokemon.getFood().getIdFood() - 1);

					Object[] message = { "Id Pokemon: ", id, "Nombre: ", namePo, "Grupo huevo: ", eggGroup,
							"Tipo principal:", typeP, "Tipo secundario: ", typeS, "Alimento", comboFoods };

					int option = JOptionPane.showConfirmDialog(null, message, "Modificar Pokemon",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						int confimation = JOptionPane.showConfirmDialog(null,
								"¿Estas seguro de que deseas realizar los cambios?", "Confirmacion",
								JOptionPane.OK_CANCEL_OPTION);
						if (confimation == JOptionPane.OK_OPTION) {
							selectedPokemon.setNumPokedex(selectedPokemon.getIdPokemon());
							selectedPokemon.setNamePo(namePo.getText());
							selectedPokemon.setEggGroup(eggGroup.getText());
							selectedPokemon.setTypeP((String) typeP.getSelectedItem());
							selectedPokemon.setTypeS((String) typeS.getSelectedItem());

							String nameFood = String.valueOf(comboFoods.getSelectedItem());
							selectedPokemon.setFood(managerFood.selectFoodByName(nameFood));

							try {
								managerPokemon.update(selectedPokemon);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							loadTablePokemonData(tablePokemon);
						}
					}
				}
			}
		});
		btnModifyPokemon.setBounds(245, 336, 224, 23);
		panelAdminPokemon.add(btnModifyPokemon);

		JButton btnDeletePokemon = new JButton("Borrar Pokemon");
		btnDeletePokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon selectedPokemon = getSelectedPokemon();
				int confimation = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar el pokemon?",
						"Confirmacion", JOptionPane.OK_CANCEL_OPTION);
				if (confimation == JOptionPane.OK_OPTION) {
					deleteSelectedPokemon(selectedPokemon);
				}
			}
		});
		btnDeletePokemon.setBounds(480, 336, 224, 23);
		panelAdminPokemon.add(btnDeletePokemon);

		// PANEL ENCLOSURE
		panelAdminEnclosure = new JPanel();
		panelAdminEnclosure.setBounds(10, 68, 714, 370);
		panelAdmin.add(panelAdminEnclosure);
		panelAdminEnclosure.setLayout(null);
		panelAdminEnclosure.setVisible(false);

		JScrollPane scrollPaneTableEnclosure = new JScrollPane();
		scrollPaneTableEnclosure.setBounds(10, 11, 694, 321);
		panelAdminEnclosure.add(scrollPaneTableEnclosure);

		tableEnclosure = new JTable();
		scrollPaneTableEnclosure.setViewportView(tableEnclosure);

		tableEnclosure.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEnclosure.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numero", "Nombre" }));
		tableEnclosure.setDefaultEditor(Object.class, null);

		JButton btnAddNewEnclosure = new JButton("Añadir Recinto");
		btnAddNewEnclosure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JTextField number = new JTextField();
				JTextField name = new JTextField();

				Object[] message = { "Número: ", number, "Nombre: ", name };

				int option = JOptionPane.showConfirmDialog(null, message, "Registrar nuevo Recinto",
						JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (!number.getText().matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "NUMERO de Recinto INCORRECTO", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else if (!name.getText().matches("[a-zA-Z]*")) {
						JOptionPane.showMessageDialog(null, "NOMBRE de Recinto INCORRECTO!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (number.getText().isEmpty() || name.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Faltan datos obligatorios del Recinto!", "Oye!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							Enclosure enclosureToInsert = new Enclosure();
							enclosureToInsert.setNumberEn(Integer.valueOf(number.getText()));
							enclosureToInsert.setTypeEn(name.getText());

							if (null == managerEnclosure) {
								managerEnclosure = new ManagerEnclosure();
							}

							if (!managerEnclosure.checkEnclosureTypeExists(enclosureToInsert)
									&& !managerEnclosure.checkEnclosureNumberExists(enclosureToInsert)) {
								try {
									managerEnclosure.insert(enclosureToInsert);
									JOptionPane.showMessageDialog(null, "Recinto registrado correctamente", "Yay!",
											JOptionPane.INFORMATION_MESSAGE);
									loadTableEnclosureData(tableEnclosure);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							} else {
								JOptionPane.showMessageDialog(null, "Ya Existe un recinto con los datos insertados",
										"Oye!", JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				}
			}
		});
		btnAddNewEnclosure.setBounds(10, 336, 224, 23);
		panelAdminEnclosure.add(btnAddNewEnclosure);

		JButton btnModifyEnclosure = new JButton("Modificar Recinto");
		btnModifyEnclosure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enclosure selectedEnclosure = getSelectedEnclosure();

				JLabel idEn = new JLabel();
				idEn.setText(Integer.toString(selectedEnclosure.getIdEnclosure()));
				JTextField numberEn = new JTextField();
				numberEn.setText(Integer.toString(selectedEnclosure.getNumberEn()));
				JTextField typeEn = new JTextField();
				typeEn.setText(selectedEnclosure.getTypeEn());

				Object[] message = { "id: ", idEn, "Numero: ", numberEn, "Tipo: ", typeEn };

				int option = JOptionPane.showConfirmDialog(null, message, "Modificar Recinto",
						JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					int confimation = JOptionPane.showConfirmDialog(null,
							"¿Estas seguro de que deseas realizar los cambios?", "Confirmacion",
							JOptionPane.OK_CANCEL_OPTION);
					if (confimation == JOptionPane.OK_OPTION) {
						if (!numberEn.getText().matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Formato de NUMERO de Recinto INCORRECTO", "Oye!",
									JOptionPane.ERROR_MESSAGE);
						} else if (!typeEn.getText().matches("[a-zA-Z]*")) {
							JOptionPane.showMessageDialog(null, "Formato de NOMBRE de Recinto INCORRECTO!", "Oye!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							selectedEnclosure.setNumberEn(Integer.valueOf(numberEn.getText()));
							selectedEnclosure.setTypeEn(typeEn.getText());

							if (null == managerEnclosure) {
								managerEnclosure = new ManagerEnclosure();
							}

							try {
								managerEnclosure.update(selectedEnclosure);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							loadTableEnclosureData(tableEnclosure);
						}
					}
				}
			}
		});
		btnModifyEnclosure.setBounds(245, 336, 224, 23);
		panelAdminEnclosure.add(btnModifyEnclosure);

		JButton btnDeleteEnclosure = new JButton("Borrar Recinto");
		btnDeleteEnclosure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enclosure selectedEnclosure = getSelectedEnclosure();
				int confimation = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar el Recinto?",
						"Confirmacion", JOptionPane.OK_CANCEL_OPTION);
				if (confimation == JOptionPane.OK_OPTION) {
					deleteSelectedEnclosure(selectedEnclosure);
				}
			}
		});
		btnDeleteEnclosure.setBounds(480, 336, 224, 23);
		panelAdminEnclosure.add(btnDeleteEnclosure);

		// PANEL FOOD
		panelAdminFood = new JPanel();
		panelAdminFood.setBounds(10, 68, 714, 370);
		panelAdmin.add(panelAdminFood);
		panelAdminFood.setLayout(null);
		panelAdminFood.setVisible(false);

		JScrollPane scrollPaneTableFood = new JScrollPane();
		scrollPaneTableFood.setBounds(10, 11, 694, 321);
		panelAdminFood.add(scrollPaneTableFood);

		tableFood = new JTable();
		scrollPaneTableFood.setViewportView(tableFood);

		tableFood.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFood.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Descripcion", "Cantidad", "Consumo Diario" }));
		tableFood.setDefaultEditor(Object.class, null);

		JButton btnAddNewFood = new JButton("Nueva Comida");
		btnAddNewFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField name = new JTextField();
				JTextField description = new JTextField();
				JTextField quantity = new JTextField();
				JTextField dailyConsume = new JTextField();

				Object[] message = { "Nombre", name, "Descripcion", description, "Cantidad", quantity, "Consumo diario",
						dailyConsume };

				int opcion = JOptionPane.showConfirmDialog(null, message, "Registrar nueva baya",
						JOptionPane.OK_CANCEL_OPTION);

				if (opcion == JOptionPane.OK_OPTION) {

					if ((name.getText().isEmpty()) || (description.getText().isEmpty())
							|| (quantity.getText().isEmpty()) || dailyConsume.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Faltan datos por rellenar!", "Oye!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Food foodToInsert = new Food();

						foodToInsert.setNameFo(name.getText());
						foodToInsert.setDescriptionFo(description.getText());
						foodToInsert.setQuantityFo(Integer.valueOf(quantity.getText()));
						foodToInsert.setDailyConsumeFo(Integer.valueOf(dailyConsume.getText()));

						if (null == managerFood) {
							managerFood = new ManagerFood();
						}
						if (!managerFood.checkFoodNameExist(foodToInsert)) {
							try {
								managerFood.insert(foodToInsert);

								JOptionPane.showMessageDialog(null, "Baya añadida correctamente!", "Oye!",
										JOptionPane.INFORMATION_MESSAGE);
								loadTableFoodData(tableFood);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null, "La baya ya existe!", "Oye!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnAddNewFood.setBounds(10, 336, 224, 23);
		panelAdminFood.add(btnAddNewFood);

		JButton btnModifyFood = new JButton("Modificar Comida");
		btnModifyFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food selectedFood = getSelectedFood();

				if (null != selectedFood) {
					JTextField name = new JTextField();
					name.setText(selectedFood.getNameFo());
					JTextField description = new JTextField();
					description.setText(selectedFood.getDescriptionFo());
					JTextField quantity = new JTextField();
					quantity.setText(Integer.toString(selectedFood.getQuantityFo()));
					JTextField dailyConsume = new JTextField();
					dailyConsume.setText(Integer.toString(selectedFood.getDailyConsumeFo()));

					if (null == managerFood) {
						managerFood = new ManagerFood();
					}

					Object[] message = { "Nombre: ", name, "Descripcion : ", description, "Cantidad:", quantity,
							"Consumo diario: ", dailyConsume };

					int option = JOptionPane.showConfirmDialog(null, message, "Modificar Baya",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						int confimation = JOptionPane.showConfirmDialog(null,
								"¿Estas seguro de que deseas realizar los cambios?", "Confirmacion",
								JOptionPane.OK_CANCEL_OPTION);
						if (confimation == JOptionPane.OK_OPTION) {
							selectedFood.setNameFo(name.getText());
							selectedFood.setDescriptionFo(description.getText());
							selectedFood.setQuantityFo(Integer.valueOf(quantity.getText()));
							selectedFood.setDailyConsumeFo(Integer.valueOf(dailyConsume.getText()));

							try {
								managerFood.update(selectedFood);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							loadTableFoodData(tableFood);
						}
					}
				}
			}
		});
		btnModifyFood.setBounds(245, 336, 224, 23);
		panelAdminFood.add(btnModifyFood);

		JButton btnDeleteFood = new JButton("Borrar Comida");
		btnDeleteFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food selectedFood = getSelectedFood();

				int confirmation = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar la baya?",
						"Confirmacion", JOptionPane.OK_CANCEL_OPTION);

				if (confirmation == JOptionPane.OK_OPTION) {
					deleteSelectedFood(selectedFood);

				}
			}
		});
		btnDeleteFood.setBounds(480, 336, 224, 23);
		panelAdminFood.add(btnDeleteFood);

		// FIN PANELES ADMIN
		lblInfoTabla = new JLabel("");
		lblInfoTabla.setBounds(42, 53, 135, 14);
		panelAdmin.add(lblInfoTabla);

		JButton btnLogOut = new JButton("Cerrar Sesion");
		btnLogOut.setBorderPainted(false);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeToClientZone();
				btnWorkerArea.setVisible(true);
				btnZooArea.setVisible(true);
				setAllButtonsBackgroundToWhite();
			}
		});
		btnLogOut.setBounds(0, 437, 117, 24);
		panelAdmin.add(btnLogOut);

		frame.getContentPane().add(panelWelcome);
		panelWelcome.setLayout(null);

		JLabel lblWelcome = new JLabel("");
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcome.setBounds(246, 10, 245, 105);
		panelWelcome.add(lblWelcome);

		JLabel lblWelcomeGif = new JLabel("");
		lblWelcomeGif.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWelcomeGif.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWelcomeGif.setBounds(0, 0, 734, 461);
		RSScaleLabel.setScaleLabel(lblWelcomeGif, "img/misc/openZoo.gif");
		panelWelcome.add(lblWelcomeGif);

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

		JLabel lblPasswd = new JLabel("Contraseña: ");
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
	/**
	 * Sets the background color of all Buttons in admin Panel to White
	 */
	private void setAllButtonsBackgroundToWhite() {
		btnEmployee.setBackground(Color.WHITE);
		btnCleaner.setBackground(Color.WHITE);
		btnCaretakers.setBackground(Color.WHITE);
		btnPokemon.setBackground(Color.WHITE);
		btnEnclosure.setBackground(Color.WHITE);
		btnFood.setBackground(Color.WHITE);
	}

	/**
	 * Switches the visible panel in the admin Zone
	 * 
	 * @param i depending on the value of i various JPanels are displayed
	 */
	private void switchAdminPanels(int i) {
		switch (i) {
		case 1:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(true);
			panelAdminCleaner.setVisible(false);
			panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(false);
			panelAdminEnclosure.setVisible(false);
			panelAdminFood.setVisible(false);
			break;
		case 2:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(true);
			panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(false);
			panelAdminEnclosure.setVisible(false);
			panelAdminFood.setVisible(false);
			break;
		case 3:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			panelAdminCaretaker.setVisible(true);
			panelAdminPokemon.setVisible(false);
			panelAdminEnclosure.setVisible(false);
			panelAdminFood.setVisible(false);

			break;
		case 4:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(true);
			panelAdminEnclosure.setVisible(false);
			panelAdminFood.setVisible(false);
			break;
		case 5:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(false);
			panelAdminEnclosure.setVisible(true);
			panelAdminFood.setVisible(false);
			break;
		case 6:
			panelAdminWelcome.setVisible(false);
			panelAdminEmployee.setVisible(false);
			panelAdminCleaner.setVisible(false);
			panelAdminCaretaker.setVisible(false);
			panelAdminPokemon.setVisible(false);
			panelAdminEnclosure.setVisible(false);
			panelAdminFood.setVisible(true);
			break;
		default:
			System.out.println("Error");
		}

	}

	/**
	 * Changes the current JPanel display to panelMain
	 */
	private void changeToClientZone() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(true);
		panelMap.setVisible(true);
		panelLogin.setVisible(false);
		panelAdmin.setVisible(false);
		panelAdminWelcome.setVisible(false);
		panelAdminEmployee.setVisible(false);
	}

	/**
	 * Changes the current JPanel display to panelLogin
	 */
	private void changeToWorkerZone() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(false);
		panelMap.setVisible(false);
		panelLogin.setVisible(true);
		panelAdmin.setVisible(false);
	}

	/**
	 * Changes the current JPanel display to panelAdminWelcome
	 */
	private void changeToAdminZone() {
		panelAdmin.setVisible(true);
		panelAdminWelcome.setVisible(true);
		panelWelcome.setVisible(false);
		panelMain.setVisible(false);
		panelMap.setVisible(false);
		panelLogin.setVisible(false);
	}

	/**
	 * Changes the current JPanel display in Client Zone to different sub JPanels
	 * that shows different information
	 * 
	 * @param panel The JPanel that is going to be displayed
	 */
	private void switchMainPanels(String panel) {
		switch (panel) {
		case "MAP":
			panelMap.setVisible(true);
			panelPokedex.setVisible(false);
			panelShop.setVisible(false);
			panelTickets.setVisible(false);
			lblAdd.setVisible(true);
			break;
		case "POKEDEX":
			panelMap.setVisible(false);
			panelPokedex.setVisible(true);
			panelShop.setVisible(false);
			panelTickets.setVisible(false);
			lblAdd.setVisible(true);
			break;
		case "SHOP":
			panelMap.setVisible(false);
			panelPokedex.setVisible(false);
			panelShop.setVisible(true);
			panelTickets.setVisible(false);
			lblAdd.setVisible(true);
			break;
		case "TICKETS":
			panelMap.setVisible(false);
			panelPokedex.setVisible(false);
			panelShop.setVisible(false);
			panelTickets.setVisible(true);
			lblAdd.setVisible(false);
			break;
		default:
			System.out.println("This is not supposed to happen");
		}
	}

// ----------------------------------------------------------------------------
	/**
	 * Delete from the database the Pokemon given in the method parameter and shows
	 * a Pop-Up of confirmation
	 * 
	 * @param selectedPokemon The Pokemon object to be deleted
	 */
	private void deleteSelectedPokemon(Pokemon selectedPokemon) {
		if (null == managerPokemon) {
			managerPokemon = new ManagerPokemon();
		}
		try {
			managerPokemon.delete(selectedPokemon);
			JOptionPane.showMessageDialog(null, "Pokemon borrado correctamente", "Correcto!",
					JOptionPane.PLAIN_MESSAGE);
			loadTablePokemonData(tablePokemon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the selected employee from the employee JTable row and shows a Pop-Up
	 * of confirmation
	 * 
	 * @param selectedEmployee Selected row data into Employee Object
	 */
	private void deleteSelectedEmployee(Employee selectedEmployee) {
		if (null == managerEmployee) {
			managerEmployee = new ManagerEmployee();
		}
		selectedEmployee.setIdEmployee(managerEmployee.getEmployeeIdByDni(selectedEmployee.getDni()));

		if (selectedEmployee.getUser().isAdmin()) {
			JOptionPane.showMessageDialog(null, "El usuario administrador no se puede Borrar !!!!", "Oye!!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				managerUser.delete(selectedEmployee.getUser());
				JOptionPane.showMessageDialog(null, "Empleado Borrado correctamente", "Correcto!",
						JOptionPane.PLAIN_MESSAGE);
				loadTableEmployeeData(tableEmployee);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Deletes the selected Enclosure from the Enclosure JTable row and shows a
	 * Pop-Up of confirmation
	 * 
	 * @param selectedEnclosure Selected row data into Enclosure Object
	 */
	private void deleteSelectedEnclosure(Enclosure selectedEnclosure) {
		if (null == managerEnclosure) {
			managerEnclosure = new ManagerEnclosure();
		}

		if (selectedEnclosure.getIdEnclosure() == 0) {
			JOptionPane.showMessageDialog(null, "Error !!!!", "Oye!!", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				managerEnclosure.delete(selectedEnclosure);
				JOptionPane.showMessageDialog(null, "Recinto Borrado correctamente", "Correcto!",
						JOptionPane.PLAIN_MESSAGE);
				loadTableEnclosureData(tableEnclosure);
			} catch (Exception e) {
				// Nothin
			}
		}
	}
	
	/**
	 * Deletes the selected food from the Food JTable row and shows a Pop-up of confirmation
	 *  
	 * @param selectedFood selected row data into Food Object 
	 */
	private void deleteSelectedFood(Food selectedFood) {
		if (null == managerFood) {
			managerFood = new ManagerFood();
		}
		try {
			managerFood.delete(selectedFood);
			JOptionPane.showMessageDialog(null, "Baya borrado correctamente", "Correcto!",
					JOptionPane.PLAIN_MESSAGE);
			loadTableFoodData(tableFood);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Blocks the selectedEmployee from the database
	 * 
	 * @param selectedEmployee Selected row data to the Employee Object
	 */
	private void blockSelectedEmployee(Employee selectedEmployee) {
		if (null == managerUser) {
			managerUser = new ManagerUser();
		}
		managerUser.blockUserByIdUser(selectedEmployee.getUser().getIdUser());
	}

	/**
	 * Adds rows to tableEmployee with the data returned from database
	 * 
	 * @param table to be changed
	 */
	private void loadTableEmployeeData(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		if (null == managerEmployee) {
			managerEmployee = new ManagerEmployee();
		}

		ArrayList<Employee> allEmployees = null;
		try {
			allEmployees = managerEmployee.selectAll();
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
	}

	/**
	 * Adds rows to tableCleaner with the data returned from database
	 * 
	 * @param tableCleaner table to be changed
	 */
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

	/**
	 * Adds rows to tableCaretaker with the data returned from database
	 * 
	 * @param tableCaretaker table to be changed
	 */
	private void loadTableCaretakerData(JTable tableCaretaker) {
		DefaultTableModel model = (DefaultTableModel) tableCaretaker.getModel();
		model.setRowCount(0);

		if (null == managerCaretaker) {
			managerCaretaker = new ManagerCaretaker();
		}

		ArrayList<Caretaker> allCaretakers = null;
		try {
			allCaretakers = managerCaretaker.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != allCaretakers) {
			for (Caretaker caretaker : allCaretakers) {
				String dni = caretaker.getDni();
				String name = caretaker.getNameWo();
				String surName = caretaker.getSurnameWo();
				String phone = caretaker.getPhoneWo();
				Boolean isBlocked = caretaker.getUser().getIsBlocked();
				String username = caretaker.getUser().getUsername();
				ArrayList<Food> allFood = caretaker.getFood();

				model.addRow(
						new String[] { dni, name, surName, phone, isBlocked.toString(), username, allFood.toString() });
			}
		}
	}

	/**
	 * Adds rows to tablePokemon with the data returned from database
	 * 
	 * @param tablePokemon table to be changed
	 */
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
				String idfood = Integer.toString(poke.getFood().getIdFood());

				model.addRow(new String[] { idPokemon, namePo, eggGroup, typeP, typeS, idfood });
			}
		}
	}

	/**
	 * Adds rows to tableEnclosure with the data returned from database
	 * 
	 * @param tableEnclosure table to be changed
	 */
	private void loadTableEnclosureData(JTable tableEnclosure) {
		DefaultTableModel model = (DefaultTableModel) tableEnclosure.getModel();
		model.setRowCount(0);

		if (null == managerEnclosure) {
			managerEnclosure = new ManagerEnclosure();
		}

		ArrayList<Enclosure> allEnclosures = null;
		try {
			allEnclosures = managerEnclosure.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != allEnclosures) {
			for (Enclosure enclo : allEnclosures) {
				String number = Integer.toString(enclo.getNumberEn());
				String type = enclo.getTypeEn();

				model.addRow(new String[] { number, type });
			}
		}
	}

	/**
	 * Adds rows to tableFood with the data returned from database
	 * 
	 * @param tableFood table to be changed
	 */
	private void loadTableFoodData(JTable tableFood) {
		DefaultTableModel model = (DefaultTableModel) tableFood.getModel();
		model.setRowCount(0);

		if (null == managerFood) {
			managerFood = new ManagerFood();
		}

		ArrayList<Food> allFood = null;
		try {
			allFood = managerFood.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != allFood) {
			for (Food food : allFood) {
				String name = food.getNameFo();
				String description = food.getDescriptionFo();
				String quantity = Integer.toString(food.getQuantityFo());
				String dailyConsume = Integer.toString(food.getDailyConsumeFo());

				model.addRow(new String[] { name, description, quantity, dailyConsume });
			}
		}
	}

	/**
	 * if tablePokemon has a selected row calls to managerPokemon with the id value
	 * from the table and gets a Pokemon Object
	 * 
	 * @return Pokemon Object if tablePokemon has a selected row, null if
	 *         tablePokemon doesn't have a selected row
	 */
	private Pokemon getSelectedPokemon() {
		Pokemon ret = null;
		if (tablePokemon.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para modificar.", "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			ret = new Pokemon();

			int row = tablePokemon.getSelectedRow();

			int id = Integer.valueOf((String) tablePokemon.getValueAt(row, 0));
			ret = managerPokemon.getPokemonById(id);
		}

		return ret;
	}

	/**
	 * if tableEmployee has a selected row calls to managerEmployee with the dni
	 * value from the table and gets a Employee Object
	 * 
	 * @return Employee Object if tableEmployee has a selected row, null if
	 *         tableEmployee doesn't have a selected row
	 * @throws EmployeeNotSelected tableEmployee doesn't have a selected row
	 */
	private Employee getSelectedEmployee() throws EmployeeNotSelected {
		Employee ret = null;
		if (tableEmployee.getSelectionModel().isSelectionEmpty()) {
			throw new EmployeeNotSelected("No hay empleado seleccionado");
		} else {
			ret = new Employee();

			int row = tableEmployee.getSelectedRow();

			String dni = (String) tableEmployee.getValueAt(row, 0);
			ret = managerEmployee.selectEmployeeByDni(dni);
		}

		return ret;
	}

	/**
	 * if tableCleaner has a selected row calls to managerCleaner with the dni value
	 * from the table and gets a Cleaner Object
	 * 
	 * @return Cleaner Object if tableCleaner has a selected row, null if
	 *         tableCleaner doesn't have a selected row
	 */
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

	/**
	 * if tableEnclosure has a selected row calls to managerEnclosure with the dni
	 * value from the table and gets a Enclosure Object
	 * 
	 * @return Enclosure Object if tableEnclosure has a selected row, null if
	 *         tableEnclosure doesn't have a selected row
	 */
	private Enclosure getSelectedEnclosure() {
		Enclosure ret = null;
		ManagerEnclosure managerEclosure = null;
		if (tableEnclosure.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para BORRAR.", "¡Error!",
					JOptionPane.ERROR_MESSAGE);
			return ret;
		} else {
			ret = new Enclosure();
		}
		int row = tableEnclosure.getSelectedRow();

		int number = Integer.valueOf((String) tableEnclosure.getValueAt(row, 0));
		if (null == managerEclosure) {
			managerEclosure = new ManagerEnclosure();
		}
		ret = managerEclosure.selectEnclosureByNumber(number);

		return ret;
	}
	
	/**
	 * if tableFood has a selected row calls to managerFood with the name value
	 * from the table and gets a Food Object
	 * 
	 * @return Food Object if tableFood has a selected row or null if
	 *         tableEnclosure does not have a selected row
	 */
	private Food getSelectedFood() {
		Food ret = null;
		if (tableFood.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para modificar.", "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			ret = new Food();

			int row = tableFood.getSelectedRow();

			String name = (String) tableFood.getValueAt(row, 0);
			ret = managerFood.selectFoodByName(name);

		}

		return ret;
	}

	/**
	 * method that takes the text from the paramerters and sends different options
	 * to loginOptions()
	 * 
	 * @param textFieldUserName   usename to be checked
	 * @param passwordFieldPasswd password of the username to be checked
	 */
	private void checkLogin(JTextField textFieldUserName, JPasswordField passwordFieldPasswd) {
		String userName = textFieldUserName.getText();
		String passwd = new String(passwordFieldPasswd.getPassword());

		if (null == managerUser) {
			managerUser = new ManagerUser();
		}
		int result = managerUser.checkUserExists(userName, passwd);
		loginOptions(result);
	}

	/**
	 * Shows different Pop-ups depending on the value of the param and loads different JPanels
	 * @param result if 0 user not exists, if 1 Employee zone, if 2 Admin zone, if 3 the user is blocked
	 */
	private void loginOptions(int result) {
		switch (result) {
		case 0:
			JOptionPane.showMessageDialog(null, "El usuario no existe o la contraseña es incorrecta", "Oye!",
					JOptionPane.ERROR_MESSAGE);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Paneles aun no implementados...", "Correcto!",
					JOptionPane.PLAIN_MESSAGE);
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

// Methods of Ticket Panel
	/**
	 * Adds 1 to the textFieldTicketQuantity if is possible
	 */
	private void quantityPlusOne() {
		int ticketQuantity = Integer.valueOf(textFieldTicketQuantity.getText());
		if (totalTicket != 0) {
			ticketQuantity++;
			totalTicket--;
		}
		Double total = ticketQuantity * ticketValue;
		textFieldTicketTotalPrice.setText(Double.toString(total));
		textFieldTicketQuantity.setText(Integer.toString(ticketQuantity));
		textFieldTotalTicket.setText(Integer.toString(totalTicket));
	}

	/**
	 * Subtracts 1 to the textFieldTicketQuantity if is possible
	 */
	private void quantityMinusOne() {
		int ticketQuantity = Integer.valueOf(textFieldTicketQuantity.getText());
		if (ticketQuantity != 0) {
			ticketQuantity--;
			totalTicket++;
		}
		Double total = ticketValue * ticketQuantity;
		textFieldTicketTotalPrice.setText(Double.toString(total));
		textFieldTicketQuantity.setText(Integer.toString(ticketQuantity));
		textFieldTotalTicket.setText(Integer.toString(totalTicket));
	}

	/**
	 * If textFieldTicketQuantity is > 0 buys the tickets and asks for recipe
	 */
	private void buyTicket() {
		if (Integer.parseInt(textFieldTicketQuantity.getText()) == 0) {
			JOptionPane.showMessageDialog(null, "No se han seleccionado entradas!!", "Oye!", JOptionPane.ERROR_MESSAGE);
		} else {
			if (totalTicket != 0) {
				JOptionPane.showMessageDialog(null, "Compra realizada con exito");

				Double totalReset = Double.valueOf(textFieldTicketTotalPrice.getText());
				int ticketDecreaser = Integer.valueOf(textFieldTotalTicket.getText());
				totalReset = 0.00;
				textFieldTotalTicket.setText(Integer.toString(ticketDecreaser));
				textFieldTicketTotalPrice.setText(Double.toString(totalReset));
			} else if (totalTicket <= 0) {
				JOptionPane.showMessageDialog(null, "No quedan entradas, vuelva mañana");
			}
			int resp = JOptionPane.showConfirmDialog(null, "¿Desea imprimir un recibo?", "Recibo",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

			if (resp == JOptionPane.YES_OPTION) {
				try {
					quantity = Integer.parseInt(textFieldTicketQuantity.getText());
					receiptMaker(quantity);
					quantity = 0;
					textFieldTicketQuantity.setText(Integer.toString(quantity));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Creates the recipe for the bought tickets
	 * @param quantity2 tickets that are going to be bought
	 * @throws IOException error occurs during the creation of the Recipe
	 */
	private void receiptMaker(int quantity2) throws IOException {
		if (null == managerFile) {
			managerFile = new ManagerFile();
		}

		managerFile.createFile(quantity2, ticketValue);
	}
}