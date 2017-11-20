package homework6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class hashSpencer {
	//main
	public static void main(String[] args) throws IOException {
		String pathname = "./input.txt";
		File file = new File(pathname);
		
		String[] names = new String[200];
		
		int i = 0; 
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) 
		{
			String line = null; // don't skip header
			while ((line = bufferedReader.readLine()) != null) 
			{
				names[i] = line;
				i++;
			}
		}
		//for (int k = 0; k < names.length; k++)
		for (int k = 0; k < 5; k++)
		{
			System.out.println(names[k].hashCode());
		}
		
	}
		
}
