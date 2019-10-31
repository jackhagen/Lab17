package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;

public class CountriesTextFile {

	public static boolean writeCountriesToFile(Path filePath, ArrayList<Country> countries) {

		File file = filePath.toFile();

		try (PrintWriter output = new PrintWriter(new FileOutputStream(file, true));) {

			for (Country c : countries) {
				output.println(c);
			}
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("The file >>" + filePath + "<< does not exist.");
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<Country> readFromFile(Path filePath) {
		ArrayList<Country> countriesInFile = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				Country newCountry = Country.fromString(line);
				countriesInFile.add(newCountry);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {

		} finally {

		}
		return countriesInFile;
	}
}
