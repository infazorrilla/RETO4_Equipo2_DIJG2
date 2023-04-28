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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import PokeZoo.bbdd.manager.ManagerDependent;
import PokeZoo.bbdd.manager.ManagerEmployee;
import PokeZoo.bbdd.manager.ManagerUser;
import PokeZoo.bbdd.pojo.Dependent;
import PokeZoo.bbdd.pojo.Employee;
import PokeZoo.bbdd.pojo.User;

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

	// Labels
	private JLabel lblInfoTabla = null;

	// Managers
	private ManagerUser managerUser = null;
	private ManagerEmployee managerEmployee = null;
	private ManagerDependent managerDependent = null;

	private JTable tableEmployee;

	/**
	 * Create the application.
	 */
	public Views() {
		initialize();
		this.frame.setTitle("Poke-Zoo");
		ImageIcon img = new ImageIcon(Views.class.getResource("/varios/Logo.png"));
		this.frame.setIconImage(img.getImage());
		// TODO CAMBIAR ICONO DE ARRIBA A LA DERECHA E ICONO ED APP
		this.frame.setVisible(true);		
		this.frame.setResizable(false);
		// TODO BORRAR MAS TARDE SOLO PARA DEBUG
		changeToAdminZone();
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
		lbllogo2.setIcon(new ImageIcon(Views.class.getResource("/varios/Logo.png")));
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

		panelAdminEmployee = new JPanel();
		panelAdminEmployee.setBounds(10, 68, 714, 370);
		panelAdmin.add(panelAdminEmployee);
		panelAdminEmployee.setLayout(null);

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

				int option = JOptionPane.showConfirmDialog(null, message, "Resgistrar nuevo Oficinista",
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
							
							if(null == managerUser) {
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

				// TODO Borrar el employee sekeccionado
			}
		});
		btnDeleteEmployee.setBounds(399, 336, 141, 23);
		panelAdminEmployee.add(btnDeleteEmployee);

		JButton btnBlockEmployee = new JButton("Bloquear Empleado");
		btnBlockEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee selectedEmployee = getSelectedEmployee();

				// TODO Bloquear al employee seleccioando
			}
		});
		btnBlockEmployee.setBounds(563, 336, 141, 23);
		panelAdminEmployee.add(btnBlockEmployee);

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
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Logo.png")).getImage()
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

		JTextField textPokemonName = new JTextField();
		textPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonName.setBounds(131, 15, 139, 30);
		panelPokedex.add(textPokemonName);

		JLabel lblInfoAlias = new JLabel("Alias :");
		lblInfoAlias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoAlias.setBounds(20, 50, 85, 30);
		panelPokedex.add(lblInfoAlias);

		JTextField textPokemonAlias = new JTextField();
		textPokemonAlias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonAlias.setBounds(131, 50, 139, 30);
		panelPokedex.add(textPokemonAlias);

		JLabel lblInfoTypes = new JLabel("Tipo/s :");
		lblInfoTypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoTypes.setBounds(20, 90, 85, 30);
		panelPokedex.add(lblInfoTypes);

		JTextField textPokemonTypeP = new JTextField();
		textPokemonTypeP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonTypeP.setBounds(131, 90, 139, 30);
		panelPokedex.add(textPokemonTypeP);

		JTextField textPokemonTypeS = new JTextField();
		textPokemonTypeS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPokemonTypeS.setBounds(281, 90, 122, 30);
		panelPokedex.add(textPokemonTypeS);

		JLabel lblDescription = new JLabel("Descripcion :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(20, 120, 200, 44);
		panelPokedex.add(lblDescription);

		JTextArea textPokemonDescription = new JTextArea();
		textPokemonDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPokemonDescription.setBounds(20, 160, 423, 100);
		panelPokedex.add(textPokemonDescription);

		JTextField textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textSearch.setBounds(100, 268, 150, 40);
		panelPokedex.add(textSearch);

		JButton btnSearch = new JButton();
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(250, 268, 40, 40);
		btnSearch.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/PokeLupa.png")).getImage()
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textSearch.getText().equalsIgnoreCase("Charizard") || textSearch.getText().equalsIgnoreCase("6")) {
					textPokemonName.setText("Charizard");
					textPokemonAlias.setText("Chorizo");
					textPokemonTypeP.setText("Fuego");
					textPokemonTypeS.setText("Volador");
					textPokemonDescription.setText(
							"Escupe un fuego tan caliente que funde las rocas. \nCausa incendios forestales sin querer.");
					lblSelectedPokemonImage
							.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Charizard.png"))
									.getImage().getScaledInstance(140, 110, Image.SCALE_SMOOTH)));
				} else if (textSearch.getText().equalsIgnoreCase("Venusaur")
						|| textSearch.getText().equalsIgnoreCase("3")) {
					textPokemonName.setText("Venusaur");
					textPokemonAlias.setText("Venardo");
					textPokemonTypeP.setText("Planta");
					textPokemonTypeS.setText("Veneno");
					textPokemonDescription.setText(
							"La planta florece cuando absorbe energía solar, \nlo cual le obliga a buscar siempre la luz del sol.");
					lblSelectedPokemonImage
							.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Venusaur.png"))
									.getImage().getScaledInstance(140, 110, Image.SCALE_SMOOTH)));
				} else if (textSearch.getText().equalsIgnoreCase("Blastoise")
						|| textSearch.getText().equalsIgnoreCase("9")) {
					textPokemonName.setText("Blastoise");
					textPokemonAlias.setText("Blas");
					textPokemonTypeP.setText("Agua");
					textPokemonTypeS.setText("");
					textPokemonDescription.setText(
							"Para acabar con su enemigo, lo aplasta con el peso de su cuerpo. \nEn momentos de apuro, se esconde en el caparazón.");
					lblSelectedPokemonImage
							.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Blastoise.png"))
									.getImage().getScaledInstance(140, 110, Image.SCALE_SMOOTH)));
				} else {
					textPokemonName.setText("");
					textPokemonAlias.setText("");
					textPokemonTypeP.setText("");
					textPokemonTypeS.setText("");
					textPokemonDescription.setText("");
					lblSelectedPokemonImage.setIcon(null);
				}
			}
		});
		panelPokedex.add(btnSearch);

		JLabel lblPokedexImage = new JLabel();
		lblPokedexImage.setBounds(0, 0, 714, 314);
		lblPokedexImage.setIcon(new ImageIcon(new ImageIcon(Views.class.getResource("/varios/Pokedex.png")).getImage()
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

		for (Employee employee : allEmployees) {
			String dni = employee.getDni();
			String name = employee.getNameWo();
			String surName = employee.getSurnameWo();
			String phone = employee.getPhoneWo();
			Boolean isBlocked = employee.getUser().getIsBlocked();
			String username = employee.getUser().getUsername();

			model.addRow(new String[] { dni, name, surName, phone, isBlocked.toString(), username});
		}

		for (Dependent dependant : allDependant) {
			String dni = dependant.getDni();
			String name = dependant.getNameWo();
			String surName = dependant.getSurnameWo();
			String phone = dependant.getPhoneWo();
			Boolean isBlocked = dependant.getUser().getIsBlocked();

			model.addRow(new String[] { dni, name, surName, phone, isBlocked.toString() });
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
