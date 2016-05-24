package alphaComponents;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WriterTest1 {

	public static void main(String[] args) {
		readLines(new File("./lib/log.txt"));
		/*try{
		    FileWriter fileWriter = new FileWriter(log, true);
		    FileReader reader = new FileReader(log);

		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


		    System.out.println("Done");
		} catch(IOException e) {
		    System.out.println("COULD NOT LOG!!");
		}*/
	}

	/**
	 * Inputs each word of file into a separate String ArrayList Element
	 * If the file does not exist, an empty Arraylist is returned.
	 * @param file
	 * @return
	 */
	public static List<String> readWords(File file) {
		Scanner s;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			s = new Scanner(file);

			while (s.hasNext()){
				list.add(s.next());
			}
			
			s.close();
			printList(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	
	/**
	 * Inputs each line of file into an ArrayList.
	 * Returns an empty arraylist if file does not exist.
	 * @param file
	 * @return
	 */
	public static List<String> readLines(File file) {
		Scanner s;
		ArrayList<String> list = new ArrayList<String>();
		try {
			s = new Scanner(file);

			while (s.hasNextLine()) {
				list.add(s.nextLine());
			}
			
			s.close();
			printList(list);//TESTING
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	
	public static void printList(List<String> list) {
		for (String line: list) {
			System.out.println(line);
		}
	}
}
