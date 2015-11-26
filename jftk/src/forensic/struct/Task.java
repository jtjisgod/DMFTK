package forensic.struct;

import forensic.main.FileReader;

public class Task {
	private int pid;
	private int ppid;
	private String name;
	private boolean flag=false;
	
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
		System.out.println("[" + this.pid + "] (PPID " + this.ppid + ") : " + this.name);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPpid() {
		return ppid;
	}

	public void setPpid(int ppid) {
		this.ppid = ppid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
