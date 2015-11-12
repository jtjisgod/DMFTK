package tools.forensic.jtjsoft.com;

import java.util.Scanner;

import forensic.jtjsoft.com.Cmd;
import forensic.jtjsoft.com.ExecReader;
import forensic.jtjsoft.com.FileReader;

public class Make extends Cmd {
	private Scanner scanner;

	public Make()	{
		super();
		super.setCommand("make");
		super.setInstruction("make가 없을 때 사용합니다.");
	}
	
	public void doing()	{
		String value = "";
		
		scanner = new Scanner(System.in);
		
		System.out.print("\nMake할 폴더를 입력 하세요 : ");
		
		value = ExecReader.read(scanner.nextLine());
		System.out.println("[" + value + "]");
	}
}
