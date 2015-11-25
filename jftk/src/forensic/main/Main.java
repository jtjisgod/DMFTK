package forensic.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String command = "";
		
		CommandLoading.obj.Load();

		System.out.print("\033[H\033[2J");
		System.out.flush();
		//
		System.out.println("\n			< DiMigo FORENSIC TOOL KIT >\n");
		System.out.println("		██████╗ ███╗   ███╗███████╗████████╗██╗  ██╗");
		System.out.println("		██╔══██╗████╗ ████║██╔════╝╚══██╔══╝██║ ██╔╝");
		System.out.println("		██║  ██║██╔████╔██║█████╗     ██║   █████╔╝ ");
		System.out.println("		██║  ██║██║╚██╔╝██║██╔══╝     ██║   ██╔═██╗ ");
		System.out.println("		██████╔╝██║ ╚═╝ ██║██║        ██║   ██║  ██╗");
		System.out.println("		╚═════╝ ╚═╝     ╚═╝╚═╝        ╚═╝   ╚═╝  ╚═╝");
		
		System.out.println();
				
		do {
			System.out.print("\r\nCOMMAND >> ");

			String scannedString = scanner.nextLine();
			command = scannedString.split(" ")[0];
			String commandList[] = scannedString.split(" ");
					
			if("quit".equals(command) || "exit".equals(command) || "q".equals(command)){
				break;
			}

			try{
				Command.obj.excute(command, commandList);
			} catch(Exception e)	{
				System.out.println(e.getMessage());
			}
		} while(true);
		
		System.out.println("Bye");
	}
}