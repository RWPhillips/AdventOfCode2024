package day1;

import java.io.*;
import java.util.*;

public class Day1 {

	public static void main(String[] args) {
		
		// Add two lists
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();	
    
		// Read in file and run solutions
		readFile(list1, list2);
		solutionOne(list1, list2);
		solutionTwo(list1, list2);
	}
	
	public static void solutionOne(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		
		// Define variable and sort lists
		int spaceBetween = 0;
		Collections.sort(list1);
		Collections.sort(list2);
		
		// Add up spaces between the two lists
		for (int i = 0; i < list1.size(); i++)
			spaceBetween += Math.abs(list1.get(i) - list2.get(i));
		
		// Print it out
		System.out.println("The Space Between: " + spaceBetween);	
	}
	
	public static void solutionTwo(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		
		// Variable for keeping tabs on total
		int total = 0;
		
		// Run frequency between the current number and the right list
		for (int i = 0; i < list1.size(); i++)
			total += list1.get(i) * Collections.frequency(list2, list1.get(i));
		
		// Print total
		System.out.println("Total Matches: " + total);
	}
	
	public static void readFile(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		
		// Get file
		File textFile = new File("C:\\eclipseJP-23\\eclipse-java-workspace\\AdventOfCode2024\\src\\day1\\file.txt");
		Scanner reader;
		
		try {
			// Read in each line and split it between the lists
			reader = new Scanner(textFile);	
			while (reader.hasNextLine()) {
			        String data = reader.nextLine();
			        String[] num = new String[2];
			        num = data.split("   ");
			        list1.add(Integer.parseInt(num[0]));
			        list2.add(Integer.parseInt(num[1]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
