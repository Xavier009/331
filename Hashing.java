import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.util.HashSet;




public class Hashing {


	
	static ArrayList<Word> words = new ArrayList<Word>();
	static ArrayList<String> diffList = new ArrayList<String>();
	static ArrayList<String> equalList = new ArrayList<String>();
	
	
	Hashing()
	{
		//this.words = FileIO.arrayOfWordObjects;
	}
	
	
	public static void writeListEqual()
	{

		File file = new File("resultsListEqual.txt");
		FileWriter writer = null;
		try {writer = new FileWriter(file);

		
		for (int i = 0; i < words.size(); i++)
		{
			Word current = words.get(i);			
			if (current.getCountPT() == current.getCountYT())
			{				
				String add = current.getValue() + "\t\t" + current.getCountPT();				
				equalList.add(add);
			}
		}
		
		Collections.sort(equalList);
		
		for (int i = 0; i < equalList.size(); i++)
		{
			writer.write(equalList.get(i));
			writer.write("\n");
		}
		
		
		writer.close();
		} catch (IOException e) {System.out.println("File cannot be generated");}
	}
	
	
	
	public static void writeListDiff()
	{
		
		File file = new File("resultsListDiff.txt");
		FileWriter writer = null;
		try {writer = new FileWriter(file);
		
		
		for (int i = 0; i < words.size(); i++)
		{
			Word current = words.get(i);
			String add = "";
			if (current.getCountPT() > current.getCountYT())
			{
				String zero = "";
				if (current.getCountYT() == 0) {zero = " - ZERO";}
				
				add = current.getValue() + "\t\t" + "+" + (current.getCountPT() - current.getCountYT()) + "PT" + zero;
				diffList.add(add);
				//writer.write("\n");
			}
			else if (current.getCountPT() < current.getCountYT())
			{
				String zero = "";
				if (current.getCountPT() == 0) {zero = " - ZERO";}
				add = current.getValue() + "\t\t" + "+" + (current.getCountYT() - current.getCountPT()) + "YT" + zero;
				diffList.add(add);
				//writer.write("\n");
			}
			
			
			
			
		}
		
		Collections.sort(diffList);
		
		for (int j = 0; j < diffList.size(); j++)
		{
			writer.write(diffList.get(j));
			writer.write("\n");
		}
		writer.close();
		
		}catch (IOException e) {System.out.println("File cannot be generated");}
		
	}
	
	
	
	
	
	
	
	
}
