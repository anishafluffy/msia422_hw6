package homework6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class hashSpencer {
	//main
	public static void main(String[] args) throws IOException {
		String pathname = "./input.txt";
		File file = new File(pathname);
		
		//create names array
		String[] names = new String[200];
		int i = 0; 
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = null; // don't skip header
			while ((line = bufferedReader.readLine()) != null) {
				names[i] = line;
				i++;
				}
			}
		
		//create hash arraylist
		ArrayList<Integer> hash = new ArrayList<Integer>(); 
		for (int k = 0; k < names.length; k++) {
				hash.add(java.lang.Math.abs(names[k].hashCode() % 100)); 
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
		    hm.get(h).add(names[k]);
		    k++;
		}
		//System.out.println(hm);
		
        System.out.println((int) 'a');
		
	}
		
}
