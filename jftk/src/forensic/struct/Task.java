package forensic.struct;

import forensic.main.FileReader;

public class Task {
	private int pid;
	private int ppid;
	private String name;
	
	public Task(int pid){
		try{
			this.pid = pid;
			String data = FileReader.obj.read("/proc/"+pid+"/status");
			this.ppid = Integer.parseInt(data.split("PPid:	")[1].split("TracerPid:")[0]);
			this.name = data.split("Name:	")[1].split("State")[0];
		} catch(Exception e){
			System.out.println("Exception in Task");
			e.printStackTrace();
		}
	}
	
	public void display(){
		System.out.println("[" + this.pid + "]	(PPID " + this.ppid + ")	: " + this.name);
	}
	
}
