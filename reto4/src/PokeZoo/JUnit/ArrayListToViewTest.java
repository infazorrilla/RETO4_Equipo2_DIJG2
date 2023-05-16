package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.manager.ManagerEmployee;
import PokeZoo.bbdd.pojo.Employee;

class ArrayListToViewTest {
	
	private JFrame frame = null;
	private JPanel panelAdminEmployee = null;
	private JTable tableTest = null;
	
	private ManagerEmployee managerEmployee = new ManagerEmployee();

	@Test
	void testArrayListToView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		panelAdminEmployee = new JPanel();
		panelAdminEmployee.setBounds(10, 68, 714, 370);
		panelAdminEmployee.setLayout(null);
		panelAdminEmployee.setVisible(true);

		JScrollPane scrollPaneTableEmployee = new JScrollPane();
		scrollPaneTableEmployee.setBounds(10, 11, 694, 321);
		panelAdminEmployee.add(scrollPaneTableEmployee);

		tableTest = new JTable();
		scrollPaneTableEmployee.setViewportView(tableTest);

		tableTest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTest.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "DNI", "Nombre", "Apellido", "Telf.", "Bloqueado", "usuario" }));
		tableTest.setDefaultEditor(Object.class, null);
		
		// aaaaaaaaaaaaaaa
		loadTableData(tableTest);
		
		ArrayList<Employee> expected = null;
		try {
			expected = managerEmployee.selectAll();
		} catch (Exception e) {
			// Nothing
		}	
				
		assertEquals(expected.size(), tableTest.getRowCount());
	}
	
	private void loadTableData(JTable table) {		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

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

}
