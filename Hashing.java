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
import java.util.Hashtable;




public class Hashing {


	
	static ArrayList<String> diffList = new ArrayList<String>();
	static ArrayList<String> simList = new ArrayList<String>();

	
	
	//static ArrayList<Word> array = new ArrayList<Word>();
	
	static ArrayList<Word> words2= new ArrayList<Word>();
	static ArrayList<Word> words = new ArrayList<Word>();
	
	static Hashtable<Integer, ArrayList<Word>> table = new Hashtable<Integer, ArrayList<Word>>();
	
	
	static int previousKey = 0;
	static int repetition = 0;
	static int key = 0;
	
	
	
	Hashing()
	{
		//this.words = FileIO.arrayOfWordObjects;
	}
	
	public static boolean hashTabler(ArrayList<Word> name, int currentKey) {
	
		//base case
				if((currentKey >= name.size()))//by this point you are at the last word in the arrayOfWordObjetcs
				{
					for (int i = 0; i < words2.size(); i++)
					{
						words2.get(0).addToList(words2.get(i));				
					}			
					
					table.put(previousKey, words2.get(0).thisWordList);
					words2.clear();
					return false;
				}
				

					key = name.get(currentKey).getKey();//get key for table.get(i).get(j) word
					
					if (previousKey != key && repetition != 0)
					{			
						for (int i = 0; i < words2.size(); i++)
						{
							words2.get(0).addToList(words2.get(i));				
						}
						
						table.put(previousKey, words2.get(0).thisWordList);
						
						words2.clear();	
					}
					
					previousKey = key;				
					Word w = name.get(currentKey);		
					words2.add(w);
					repetition++;					
					hashTabler(name, (currentKey + 1));
					return true;
					
					
					
	}
	
	
	public static void writeListEqual()
	{
		hashTabler(words, 0);

		
		
		
		
		
		
		
		File file = new File("resultsListEqual.txt");
		FileWriter writer = null;
		try {writer = new FileWriter(file);	
		for (int i = 0; i < 130; i++)
		{
			String add = "";	
			if(table.get(i) != null)
			{
				for(int j = 0; j < table.get(i).size(); j++)
				{
					if (table.get(i).get(j).getCountPT() == table.get(i).get(j).getCountYT())
					{
						add = table.get(i).get(j).getValue() + "\t\t" + table.get(i).get(j).getCountYT();
						simList.add(add);
					}
				}			
			}
			
		}
		
		
		Collections.sort(simList);
		
		for (int j = 0; j < simList.size(); j++)
		{
			writer.write(simList.get(j));
			writer.write("\n");
		}
		writer.close();
		
		}catch (IOException e) {System.out.println("File cannot be generated");}			
	}	
		
		

	
	public static void writeListDiff()
	{
		File file = new File("resultsListDiff.txt");
		FileWriter writer = null;
		try {writer = new FileWriter(file);	
		for (int i = 0; i < 130; i++)
		{
			String add = "";	
			if(table.get(i) != null)
			{
				for(int j = 0; j < table.get(i).size(); j++)
				{
					if (table.get(i).get(j).getCountPT() > table.get(i).get(j).getCountYT())
					{
						String zero = "";
						if (table.get(i).get(j).getCountYT() == 0) {zero = " - ZERO";}
						
						add = table.get(i).get(j).getValue() + "\t\t" + "+" + (table.get(i).get(j).getCountPT() - table.get(i).get(j).getCountYT()) + "PT" + zero;//+ "\t\t\t\tPT: " + table.get(i).get(j).getCountPT() + " YT:" + table.get(i).get(j).getCountYT();
						diffList.add(add);
					}
					else if (table.get(i).get(j).getCountPT() < table.get(i).get(j).getCountYT())
					{
						String zero = "";
						if (table.get(i).get(j).getCountPT() == 0) {zero = " - ZERO";}
						add = table.get(i).get(j).getValue() + "\t\t" + "+" + (table.get(i).get(j).getCountYT() - table.get(i).get(j).getCountPT()) + "YT" + zero;// + "\t\t\t\tPT: " + table.get(i).get(j).getCountPT() + " YT:" + table.get(i).get(j).getCountYT();
						diffList.add(add);
					}
				}			
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
