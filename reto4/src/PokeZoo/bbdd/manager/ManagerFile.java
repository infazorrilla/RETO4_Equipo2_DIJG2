package PokeZoo.bbdd.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import PokeZoo.bbdd.pojo.Food;

public class ManagerFile {

	public File createFile(int quantity2, Double ticketValue) throws IOException {
		String path = System.getProperty("user.home") + "/Desktop/";

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm");

		File file = new File(path + "Ticket " + formatter.format(date) + ".txt");
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		try {
			printWriter.println("Cantidad de entradas: " + quantity2 + "\n");
			printWriter.println("Precio: " + (quantity2 * ticketValue) + "€");
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
	
	public File createFileTestFood(ArrayList<Food> allFood) throws IOException {
		if(null == allFood) {
			return null;
		}
		String path = System.getProperty("user.home") + "/Desktop/";

		File ret = new File(path + "Ticket pruebaFood.txt");
		FileWriter fileWriter = new FileWriter(ret);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		try {
			for(Food food : allFood) {
				printWriter.println("	idFood: " + food.getIdFood() + "\n");
				printWriter.println("	quantityFo: " + food.getQuantityFo() + "\n");
				printWriter.println("	dailyConsumeFo: " + food.getDailyConsumeFo() + "\n");
				printWriter.println("	nameFo: " + food.getNameFo() + "\n");
				printWriter.println("	descriptionFo: " + food.getDescriptionFo() + "\n");
				printWriter.println("\n");				
			}		
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nothing
			}
		}
		return ret;
	}

}

