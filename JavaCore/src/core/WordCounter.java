package core;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Count total number of occurences of a String in a text file
 * 
 * @author no_name
 *
 */
public class WordCounter {

	public static void main(String[] args) {
//		if(args.length != 1){
//			System.out.println("Invalid number of arguments!");
//			return;
//		}
		
		String sourceFile = "test.txt";
		String searchFor = "good bye";
		int searchLength = searchFor.length();
		String thisLine;
		
		try {
			BufferedReader bout = new BufferedReader(new FileReader(sourceFile));
			String ffline = null; 
			int lcnt = 0;
			int searchCount = 0;
			
			while((ffline = bout.readLine()) != null){
				lcnt++;
				for(int searchIndex = 0; searchIndex < ffline.length(); ){
					int index = ffline.indexOf(searchFor, searchIndex);
					if(index != -1){
						System.out.println("Line number : " + lcnt);
						searchCount++;
						searchIndex += index + searchLength;
					}else{
						break;
					}
				}
			}
			System.out.println(searchCount);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
