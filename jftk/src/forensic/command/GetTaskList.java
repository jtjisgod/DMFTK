package forensic.command;

import java.io.File;

import forensic.main.Cmd;
import forensic.main.ExecReader;
import forensic.main.FileReader;

public class GetTaskList extends Cmd {
	public GetTaskList()	{
		super();
		super.setCommand("get-taskList");
		super.setInstruction("실행 되고 있는 task 목록을 가지고 옵니다.");
	}
	
	public void doing()	{
		String value = "";
		String[] cutting;
		File f = null;
		File[] paths;
		try{
			f = new File("/proc");
			paths = f.listFiles();
			for(File file : paths)	{
				try{
					Integer.parseInt(file.getName());
					System.out.println(file.getPath());
				} catch (NumberFormatException e)	{ }
			}
		} catch(Exception e)	{
			System.out.println("Exception!!");
		}
	}
}
