package consol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import utility.Directory;
import utility.Service;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static StringTokenizer token;
	
	public static void main(String[] args) {
		//
		Date date=java.util.Calendar.getInstance().getTime();
		Directory root = new Directory("root", null, date,"root");
		Directory current = root;
		String path = current.getPath();
		//
		boolean flag=true;
		while(flag){
			String command = getCommand(path);
			List<String> arrayCommands= tokenizeString(command);
			if( (!("mkdir".equals(arrayCommands.get(0)))) && arrayCommands.size()>2 ){
				System.out.println("This Opeartion Doesn't Support Multiple Value");
				arrayCommands.set(0, "NA");
			}
			if(("ls".equals(arrayCommands.get(0)) || "bk".equals(arrayCommands.get(0)) ||
					"tree".equals(arrayCommands.get(0))) && arrayCommands.size()>1 ){
				System.out.println("Invalid Entry");
				arrayCommands.set(0, "NA");
			}
			switch(arrayCommands.get(0)){
				case "mkdir" : 
					boolean val = Service.createDir(arrayCommands.subList(1, arrayCommands.size()), current);
					System.out.println(val);
					break;
				case "ls" : 
					System.out.println(Service.getDirList(current));
					break;
				case "cd":
					current = Service.changeDir(arrayCommands.get(1), current );
					path = current.getPath();
					break;
				case "bk":
					current = Service.parentDir(current);
					path = current.getPath();
					break;
				case "find":
					System.out.println(Service.findDir(arrayCommands.get(1), current));
					break;
				case "tree":
					System.out.println(Service.dirTree(current));
					break;
				case "exit": flag = false;
					break;
				default :
					System.out.println("Please Enter A Valid Command");
			}
		}
	}
	private static List<String> tokenizeString(String command) {
		List<String> list = new ArrayList<String>();
		token = new StringTokenizer(command);
		while(token.hasMoreTokens()){
			list.add(token.nextToken());
		}
		return list;
	}
	public static String getCommand(String path){
		System.out.print(path+" :>");
		return scan.nextLine();
	}
}
