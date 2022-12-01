package labb4;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		while(true) {
			System.out.println("Enter command");
			String[] commands = get3ValidInputs();
			
			String action = commands[0];
			String pattern = commands[1];
			String file = commands[2];
			
			switch(action){
			case "search":
				System.out.println(returnFilteredText(pattern, file));
				break;
			default:
				System.out.println(action +" is not a valid action");
			}
			System.out.println("-----");
		}
				
		
		
		
		

	}
	
	public static String returnFilteredText(String filter, String fileAdress) {
		try {
			Scanner file = openFile(fileAdress);
			
			return filterFile(filter,file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return "could not find file";
			
		}
	}
	
	public static String filterFile(String filter, Scanner file) {
		StringBuilder sb = new StringBuilder();
		int row=1;
			while(file.hasNextLine()) {
				String nextLine = file.nextLine();
				if(nextLine.contains(filter)) {
					sb.append("row "+ row +": "+nextLine +" \n");
				}
				row++;
			}
			if(!sb.toString().isEmpty()) {
				sb.deleteCharAt(sb.length()-1);
			}
			else {
				return "file does not contain: " + filter;
			}
		
		return sb.toString();
	}
	
	public static String[] get3ValidInputs(){
		Scanner scan = new Scanner(System.in);
		while(true){
			try {
				String input = scan.nextLine();
				String[] validInputs = input.split(" ");
				if (validInputs.length != 3) {
					throw new Exception("wrong input format,try again. (<action> <pattern> <file>");
				}
				else {
					
					return validInputs;
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		
	}
	
	public static Scanner openFile(String file) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file));
		return scan;
	}
	


}
