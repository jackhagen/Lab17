package co.grandcircus;

import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		boolean userPressedQuit = false;
		do {
			String countryList = "1. Display a list of countries.";
			String userPrompt = "2. Enter a country to add to the list.";
			String userQuit = "3. Quit.";
			System.out.println("==================================================");
			System.out.println("Please choose an option: ");
			System.out.println(countryList);
			System.out.println(userPrompt);
			System.out.println(userQuit);
			System.out.println("==================================================");
			String fileName = "Countries.txt";
			Path filePath = Paths.get("resources", fileName);

			int userIntInput = Validator.getInt(scnr, "", 1, 3);
			// System.out.println(userIntInput);
			ArrayList<Country> countryArrList = new ArrayList<>();

			if (userIntInput == 1) {
				CountriesTextFile.readFromFile(filePath);
				for (Country c : countryArrList) {
					System.out.println(c);
				}

			} else if (userIntInput == 2) {
				System.out.println("What country do you want to add?");
				String userCountryAdd = scnr.nextLine();
				System.out.println("What's the population?");
				long userPopAdd = scnr.nextLong();
				BigInteger userPopBigInt = BigInteger.valueOf(userPopAdd);
				Country countryObj = new Country(userCountryAdd, userPopBigInt);
				countryArrList.add(countryObj);

				CountriesTextFile.writeCountriesToFile(filePath, countryArrList);

			} else
				userPressedQuit = true;

		} while (!userPressedQuit);
		System.out.println("Goodbye!");

	}

}
