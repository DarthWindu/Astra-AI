//Imports
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class tempoDeneb
{
	//Class variables
	private static ArrayList <String> people = new ArrayList();
	private static String name;
	private static ArrayList <String> finalStrings = new ArrayList();

	/**
	 * returnList scans the text document for the copy-and-pasted bracket scores.
	 * It puts them into the arrayList people for further usage.
	 * @returns unformatted list
	 */
	public static ArrayList <String> returnList(){
		int counter = 0;
		try {
			Scanner input = new Scanner(System.in);
			File file = new File("./lib/newFile.txt");
			input = new Scanner(file);

			while (input.hasNextLine()) {
				counter++;
				name = input.nextLine();
				people.add(name);
			}
			input.close();

		} catch (Exception ex) {
			System.out.println("Didn't find file.");
		}
		return people;
	}

	/**
	 * formatList formats the players into more readable format using a switch case method
	 * it returns the formatted arrayList (no spaces, no titles.)
	 * @return
	 */
	public static ArrayList <String> formatList(){


		try
		{
			for (int i = 0;i< people.size(); i++){
				//0,1,2,3,4,6,8,12,16,24,32,48,64,96,128	
				String person = people.get(i);
				switch (i) {

				case 0: 
					person = people.get(i);
					person = person.substring(18);
					finalStrings.add(person);
					break;
				case 1: 
					person = people.get(i);
					person = person.substring(18);
					finalStrings.add(person);
					break;
				case 2:
					person = people.get(i);
					person = person.substring(17);
					finalStrings.add(person);
					break;
				case 3:
					person = people.get(i);
					person = person.substring(11);
					finalStrings.add(person);
					break;
				case 4:
					person = people.get(i);
					person = person.substring(15);
					finalStrings.add(person);
					break;
				case 6:
					person = people.get(i);
					person = person.substring(15);
					finalStrings.add(person);
					break;
				case 8:
					person = people.get(i);
					person = person.substring(15);
					finalStrings.add(person);
					break;
				case 12:
					person = people.get(i);
					person = person.substring(16);
					finalStrings.add(person);
					break;
				case 16:
					person = people.get(i);
					person = person.substring(16);
					finalStrings.add(person);
					break;
				case 24:
					person = people.get(i);
					person = person.substring(16);
					finalStrings.add(person);
					break;
				case 32:
					person = people.get(i);
					person = person.substring(16);
					finalStrings.add(person);
					break;
				case 48:
					person = people.get(i);
					person = person.substring(16);
					finalStrings.add(person);
					break;
				case 64:
					person = people.get(i);
					person = person.substring(16);
					finalStrings.add(person);
					break;
				default:
					person = people.get(i);
					finalStrings.add(person);
				} 

			}
		} catch (Exception exe) {
			System.out.println("Failed to calculate");
		}
		return finalStrings;
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String [] args)
	{
		returnList();
		formatList();
		String filePath = "./res/Points.txt";
		File file = new File(filePath);

		try{
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("exists");
		}

		try{
			String path = file.getCanonicalPath();
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i< finalStrings.size();i++){
				String calculate = finalStrings.get(i)+ " got "+Databasia.calculateLargeBrackets(i, finalStrings.size(), finalStrings.get(i));
				System.out.println(calculate);
				bw.write(calculate);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
