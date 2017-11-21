package homework6;

import java.io.*;
import java.util.*;
import java.lang.*;

public class hashArray 
{
	public static void main(String[] args) throws IOException
	{
		// Extract data from text file
		int n = 100; 
		String path = "./input.txt";
		File file = new File(path);
		ArrayList<String> input = new ArrayList<>();
		ArrayList<Integer> hash = new ArrayList<>();
		String output[] = new String[n];
		

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) 
		{
			String line; 
			while ((line = bufferedReader.readLine()) != null) 
			{
				input.add(line);
				hash.add(java.lang.Math.abs(line.hashCode() % n));
			}
		}

		for (String s : input)
		{
			System.out.println(s);
			output[java.lang.Math.abs(s.hashCode() % n)] = s;
		}
		
		for (int i : hash)
		{
			System.out.println(i);
		}
		
		
		for (String s : output)
		{
			System.out.println(s);
		}
		
	}
}
