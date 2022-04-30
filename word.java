
public class Word {

	//all words will be lower case, and captured from data files 
	String value;
	
	int countPT;//will hold the number of times a word was found in the panopto file;
	
	int countYT;//will hold the number of times a word was found in the Youtube file;
	
	
	public void setValue(String v)
	{
		this.value = v;
	}
	
	public void setCountYT(int y)
	{
		this.countYT = y;
	}
	
	public void setCountPT(int p)
	{
		this.countPT = p;
	}
	
	public String getValue() 
	{
		return value;
	}
	
	public int getCountYT()
	{
		return countYT;
	}
	
	public int getCountPT() 
	{
		return countPT;
	}
	
	
	public String toString()
	{
		String returner = "";
		
		System.out.println("----------");
		System.out.println(value);
		System.out.println(countPT);
		System.out.println(countYT);
		
		return returner;
	}
	
	
	
}
