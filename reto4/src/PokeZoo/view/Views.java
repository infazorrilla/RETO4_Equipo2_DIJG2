package PokeZoo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

<<<<<<< HEAD
=======
import PokeZoo.bbdd.manager.ManagerUser;

>>>>>>> branch 's2' of https://github.com/infazorrilla/RETO4_Equipo2_DIJG2.git
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

	private JPanel panelLogin = null;

	private JPanel panelAdmin = null;

	// Managers
	private ManagerUser managerUser = null;

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
				changeToClientZone();
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
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToWorkerZone();
			}
		});
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Logo.png")).getImage()
				.getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
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
		lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap.png")).getImage()
				.getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
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
				if (textFieldAllPokemons.getText().equalsIgnoreCase("charmander")) {
					lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap2.png"))
							.getImage().getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
				} else if (textFieldAllPokemons.getText().equalsIgnoreCase("charizard")) {
					lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap3.png"))
							.getImage().getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
				} else {
					lblMapa.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokemonMap.png"))
							.getImage().getScaledInstance(636, 217, Image.SCALE_SMOOTH)));
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
<<<<<<< HEAD
		
		JLabel lblSelectedPokemonImage = new JLabel();
		lblSelectedPokemonImage.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Charizard.png")).getImage().getScaledInstance(140, 110, Image.SCALE_DEFAULT)));
		lblSelectedPokemonImage.setForeground(new Color(0, 0, 0));
		lblSelectedPokemonImage.setBackground(new Color(255, 255, 255));
		lblSelectedPokemonImage.setBounds(531, -50, 173, 222);
=======

		JScrollPane scrollPaneAllPokemons = new JScrollPane();
		scrollPaneAllPokemons.setBounds(29, 11, 197, 303);
		panelPokedex.add(scrollPaneAllPokemons);

		JLabel lblSelectedPokemonImage = new JLabel("(imagen del Pokemon aqui)");
		lblSelectedPokemonImage.setBounds(531, 11, 173, 222);
>>>>>>> branch 's2' of https://github.com/infazorrilla/RETO4_Equipo2_DIJG2.git
		panelPokedex.add(lblSelectedPokemonImage);

		JLabel lblInfoName = new JLabel("Nombre :");
		lblInfoName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoName.setBounds(20, 11, 85, 30);
		panelPokedex.add(lblInfoName);
<<<<<<< HEAD
		
		JTextField textPokemonName = new JTextField("Charizard");
		textPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonName.setBounds(131, 15, 139, 30);
		panelPokedex.add(textPokemonName);
		
		JLabel lblInfoAlias = new JLabel("Alias :");
		lblInfoAlias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoAlias.setBounds(20, 50, 85, 30);
		panelPokedex.add(lblInfoAlias);
		
		JTextField textPokemonAlias = new JTextField("Chorizo");
		textPokemonAlias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonAlias.setBounds(131, 50, 139, 30);
		panelPokedex.add(textPokemonAlias);
		
=======

		JLabel lblPokemonName = new JLabel("NamePo");
		lblPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPokemonName.setBounds(382, 11, 139, 44);
		panelPokedex.add(lblPokemonName);

>>>>>>> branch 's2' of https://github.com/infazorrilla/RETO4_Equipo2_DIJG2.git
		JLabel lblInfoTypes = new JLabel("Tipo/s :");
		lblInfoTypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoTypes.setBounds(20, 90, 85, 30);
		panelPokedex.add(lblInfoTypes);
<<<<<<< HEAD
		
		JTextField textPokemonType = new JTextField("Fuego");
		textPokemonType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonType.setBounds(131, 90, 115, 30);
		panelPokedex.add(textPokemonType);
		
		JTextField textPokemonType2 = new JTextField("Volador");
		textPokemonType2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonType2.setBounds(271, 90, 122, 30);
		panelPokedex.add(textPokemonType2);
		
=======

		JLabel lblPokemonTypeP = new JLabel("typeP");
		lblPokemonTypeP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPokemonTypeP.setBounds(382, 78, 139, 44);
		panelPokedex.add(lblPokemonTypeP);

		JLabel lblPokemonTypeS = new JLabel("typeS");
		lblPokemonTypeS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPokemonTypeS.setBounds(382, 135, 139, 44);
		panelPokedex.add(lblPokemonTypeS);

>>>>>>> branch 's2' of https://github.com/infazorrilla/RETO4_Equipo2_DIJG2.git
		JLabel lblDescription = new JLabel("Descripcion :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(20, 120, 200, 44);
		panelPokedex.add(lblDescription);
<<<<<<< HEAD
		
		JTextField textPokemonDescription = new JTextField();
		textPokemonDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPokemonDescription.setBounds(20, 160, 423, 100);
		panelPokedex.add(textPokemonDescription);
		
		JLabel lblPokedexImage = new JLabel();
		lblPokedexImage.setBounds(0, 0, 714, 314);
		lblPokedexImage.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Pokedex.png")).getImage().getScaledInstance(714, 314, Image.SCALE_DEFAULT)));
		panelPokedex.add(lblPokedexImage);
		
=======

		JLabel lbldescripcion = new JLabel("DescriptionPo");
		lbldescripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldescripcion.setBounds(281, 244, 423, 70);
		panelPokedex.add(lbldescripcion);

>>>>>>> branch 's2' of https://github.com/infazorrilla/RETO4_Equipo2_DIJG2.git
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

		panelAdmin = new JPanel();
		panelAdmin.setVisible(false);
		panelAdmin.setBounds(0, 0, 734, 461);
		frame.getContentPane().add(panelAdmin);
		panelAdmin.setLayout(null);

		JButton btnZooArea = new JButton("Zoo");

		JButton btnWorkerArea = new JButton("Trabajadores");
		btnWorkerArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO ocultar btnWorkerArea y mostrar los 3 botones hijos
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

		JPanel panelAdminWelocome = new JPanel();
		panelAdminWelocome.setBounds(10, 57, 714, 393);
		panelAdmin.add(panelAdminWelocome);
		panelAdminWelocome.setLayout(null);

		JLabel lblImageWorkers = new JLabel("(worker image)");
		lblImageWorkers.setBounds(10, 11, 265, 371);
		panelAdminWelocome.add(lblImageWorkers);

		JLabel lbllogo2 = new JLabel("Logo");
		lbllogo2.setIcon(new ImageIcon(Views.class.getResource("/varios/Logo.png")));
		lbllogo2.setBounds(285, 154, 116, 73);
		panelAdminWelocome.add(lbllogo2);

		JLabel lblImageZoo = new JLabel("(zoo image)");
		lblImageZoo.setBounds(411, 11, 293, 371);
		panelAdminWelocome.add(lblImageZoo);

		JButton btnEmployee = new JButton("Oficinistas");
		btnEmployee.setBackground(Color.WHITE);
		btnEmployee.setBounds(0, 0, 117, 46);
		panelAdmin.add(btnEmployee);

		JButton btnCleaner = new JButton("Limpiadores");
		btnCleaner.setBackground(Color.WHITE);
		btnCleaner.setBounds(118, 0, 135, 46);
		panelAdmin.add(btnCleaner);

		JButton btnCaretakers = new JButton("Cuidadores");
		btnCaretakers.setBackground(Color.WHITE);
		btnCaretakers.setBounds(253, 0, 117, 46);
		panelAdmin.add(btnCaretakers);

		JButton btnPokemon = new JButton("Pokemons");
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
	}

// --------------------------------------------------------------------------------------
//PANELS METHODS		
	private void changeToClientZone() {
		panelWelcome.setVisible(false);
		panelMain.setVisible(true);
		panelMap.setVisible(true);
		panelLogin.setVisible(false);
		panelAdmin.setVisible(false);
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
			changeToAdminZone();
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
