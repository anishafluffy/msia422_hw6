package homework6;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;


public class hashSpencer {
	//main
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.print("Specify size of array: ");
		int n = in.nextInt();

		String pathname = "./input.txt";
		File file = new File(pathname);
		
		//create names ArrayList
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
			//if there is no hash value, add an ArrayList
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
		
		
		//export text file and calculate load factor
		double counter = 0;
		FileWriter writer = new FileWriter("output2.txt"); 
		for (int i = 0; i < Array.getLength(output); i++) 
		{
			if (output[i] == null)
			{
				writer.write(i + " EMPTY LINE...");
				writer.write("\n");
				counter = counter + 1;
			}
			else
			{
				writer.write(i + " " + output[i]);
				writer.write("\n");
			}		  
		}
		
		System.out.print("Load Factor: " + (1 - counter/n));
		writer.close();
		in.close();
	}		
}
