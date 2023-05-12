package PokeZoo.bbdd.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Class that contains the Methods for receipt of the purchase
 */
public class ManagerFile {
	/**
	 * Creates the receipt into the users desktop
	 * @param quantity of tickets to be bought
	 * @param ticketValue price of the tickets
	 * @return Created File
	 * @throws IOException Error on file creation
	 */
	public File createFile(int quantity, Double ticketValue) throws IOException {
		String path = System.getProperty("user.home") + "/Desktop/";

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm");

		File file = new File(path + "Ticket " + formatter.format(date) + ".txt");
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		try {
			printWriter.println("Cantidad de entradas: " + quantity + "\n");
			printWriter.println("Precio: " + (quantity * ticketValue) + "€");
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nothing
			}
		}
		return file;
	}

	/**
	 * Methods that reads the param file and returns it
	 * @param newFile File to be read
	 * @return String with all the data written in the param file
	 */
	public String readFile(File newFile) {
		String ret = "";
		try {
			Scanner myReader = new Scanner(newFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				ret += data;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
