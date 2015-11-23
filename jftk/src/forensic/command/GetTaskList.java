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
					String status;
					
					int taskId;
					String taskName;
					String taskPID;
					String taskPPID;
					
					taskId = Integer.parseInt(file.getName());
					
					status = FileReader.obj.read(file.getPath() + "/status");

					taskName = status.split("Name:	")[1].split("State")[0];
					
					taskPID = status.split("Pid:	")[1].split("PPid:")[0];
					
					taskPPID = status.split("PPid:	")[1].split("TracerPid:")[0];

					// taskId	: Task 아이디 ( Same taskPID )
					// taskName	: Task 이름
					// taskPID 	: Task Process ID 
					// taskPPID : Task Prarent Process ID
					
					System.out.println("[" + taskId + "]	(PPID " + taskPPID + ")	: " + taskName);
				} catch (NumberFormatException e)	{ }
			}
		} catch(Exception e)	{
			System.out.println("Exception!!");
		}
	}
}
