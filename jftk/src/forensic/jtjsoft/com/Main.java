package forensic.jtjsoft.com;

import java.util.Scanner;

public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String command = "";
		
		CommandLoading.obj.Load();

		System.out.println("< JTJ FORENSIC TOOL KIT >");
		System.out.println();
		
		do {
			System.out.print("\r\nCOMMAND >> ");

			command = scanner.nextLine();
			
			if("quit".equals(command) || "exit".equals(command) || "q".equals(command)){
				break;
			}

			try{
				Command.obj.excute(command);
			} catch(Exception e)	{
				System.out.println(e.getMessage());
			}
		} while(true);
		
		System.out.println("Bye");
	}
}