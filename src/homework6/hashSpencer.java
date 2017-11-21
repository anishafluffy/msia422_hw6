package homework6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class hashSpencer {
	//main
	public static void main(String[] args) throws IOException {
		int n = 100;
		String pathname = "./input.txt";
		File file = new File(pathname);
		
		//create names arraylist
		ArrayList<String> names = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line; 
			while ((line = bufferedReader.readLine()) != null) {
				names.add(line);
				}
			}		
		
		//create hash ArrayList
		ArrayList<Integer> hash = new ArrayList<Integer>(); 
		for (int k = 0; k < names.size(); k++) {
				hash.add(java.lang.Math.abs(names.get(k).hashCode() % n)); 
				}
		
		//create map with key value pairs
		Map<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
		int k = 0;
		for (Integer h : hash) {
			//if there is no hash value, add an array list
			if(!hm.containsKey(h)) {
		        hm.put(h, new ArrayList<String>());
		    	}
			//next, add the name to the array list
		    hm.get(h).add(names.get(k));
		    k++;
		}
		
		//create output array
		String output[] = new String[n];
		for (int key : hm.keySet())
		{
			output[key] = hm.get(key).toString().replace("[", "").replace("]","").trim();
		}
		
		//export text file
		FileWriter writer = new FileWriter("output2.txt"); 
		for (int i = 0; i < Array.getLength(output); i++) 
		{
			if (output[i] == null)
			{
				writer.write(i + " EMPTY LINE...");
				writer.write("\n");
			}
			else
			{
				writer.write(i + " " + output[i]);
				writer.write("\n");
			}		  
		}
		writer.close();
	}		
}
