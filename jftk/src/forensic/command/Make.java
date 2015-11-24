package forensic.command;

import java.util.Scanner;

import forensic.main.Cmd;
import forensic.main.ExecReader;
import forensic.main.FileReader;

public class Make extends Cmd {
	private Scanner scanner;

	public Make()	{
		super();
		super.setCommand("make");
		super.setInstruction("make가 없을 때 사용합니다.");
	}
	
	public void doing()	{
		System.out.println();
//		String value = "";
//		
//		scanner = new Scanner(System.in);
//		
//		System.out.print("\nMake할 폴더를 입력 하세요 : ");
//		
//		value = ExecReader.read(scanner.nextLine());
//		System.out.println("[" + value + "]");
	}
}
