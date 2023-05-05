package PokeZoo.bbdd.manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManagerFile {
	
	public void recipeMaker(int quantity2) throws IOException {
		String path = System.getProperty("user.home") + "/Desktop/";

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm");

		File file = new File(path + "Ticket " + formatter.format(date) + ".txt");
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		try {
			printWriter.println("Cantidad de entradas: " + quantity2 + "\n");
			printWriter.println("Precio: " + (quantity2 * 5) + "€");
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nothing
			}
		}
	}
	
	public void readFile() {
		
	}

}
