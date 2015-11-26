package forensic.command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import forensic.main.Cmd;
import forensic.main.FileReader;
import forensic.struct.Task;

public class GetProcessTree extends Cmd {
	
	public GetProcessTree(){
		super();
		super.setCommand("get-pstree");
		super.setInstruction("프로세스 목록을 트리 구조로 출력합니다.");
	}
	
	@Override
	public void doing() {
		// TODO Auto-generated method stub
		String value = "";
		String[] cutting;
		File f = null;
		File[] paths;
		List<Task> taskList = new ArrayList<Task>();
		
		try{
			f = new File("/proc");
			paths = f.listFiles();
			for(File file : paths)	{
				try{
					System.out.println(file.getName());
					int taskId;
					taskId = Integer.parseInt(file.getName());
					System.out.println(taskId);
					taskList.add(new Task(taskId));

				} catch (NumberFormatException e)	{ }
			}
			for(Task t : taskList){
				t.display();
				System.out.println("===============================");
			}
		} catch(Exception e)	{
			System.out.println("Exception!!");
		}
	}
	
}
