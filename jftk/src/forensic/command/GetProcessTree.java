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
					int taskId;
					taskId = Integer.parseInt(file.getName());
					taskList.add(new Task(taskId));

				} catch (NumberFormatException e)	{ }
			}
			for(Task t : taskList){
				if(t.isFlag()) continue;
				printList(taskList, t, 0);
			}
		} catch(Exception e)	{
			System.out.println("Exception!!");
		}
	}
	
	private void printList(List<Task> list, Task t, int cnt){
		for(int i=0; i<cnt; i++) {
			if((i+1)==cnt) System.out.printf(" └");
			else System.out.printf("   ");
		}
		t.display();
		for(int i=0; i<list.size(); i++){
			if(t.getPid()==(list.get(i)).getPpid()){
				list.get(i).setFlag(true);
				printList(list, list.get(i), cnt+1);
			}
		}
	}
}
