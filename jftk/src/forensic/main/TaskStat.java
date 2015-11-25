package forensic.main;

public class TaskStat {
	private String data;
	private String splitData;
	private int dataPid;
	private String dataComm;
	private String dataState;
	private int dataPpid;
	private int dataPgid;
	private int dataSession;
	private int dataThreadNum;
	private int dataStartStack;
	
	public TaskStat(int pid){
		String data = FileReader.obj.read("/proc/"+pid+"/stat");
		String[] splitData = data.split(" ");
	
		dataPid = Integer.parseInt(splitData[0]);
		dataComm = splitData[1];
		dataState = splitData[2];
		
		switch(dataState){
		case "R":
		case "r":
			dataState = "Running";
			break;
		case "S":
		case "s":
			dataState = "Interruptible Wait";
			break;
		case "D":
		case "d":
			dataState = "Uninterruptible Disk Sleep";
			break;
		case "Z":
		case "z":
			dataState = "Zombie";
			break;
		case "T":
		case "t":
			dataState = "Traced";
			break;
		case "w":
		case "W":
			dataState = "Paging";
			break;
		}
		
		// One character from the string "RSDZTW" where R is running, S is sleeping in an interruptible wait, D is waiting in uninterruptible disk sleep, Z is zombie, T is traced or stopped (on a signal), and W is paging.
		
		dataPpid = Integer.parseInt(splitData[3]);
		dataPgid = Integer.parseInt(splitData[4]);
		dataSession = Integer.parseInt(splitData[5]);
		dataThreadNum = Integer.parseInt(splitData[19]);
		dataStartStack = Integer.parseInt(splitData[27]);
	}
	
	public void display(){
		System.out.println("PID : "+dataPid);
		System.out.println("PPID : "+dataPpid);
		System.out.println("PGID : "+dataPgid);
		System.out.println("Command : "+dataComm);
		System.out.println("State : "+dataState);
		System.out.println("Session : "+dataSession);
		System.out.println("Number of Thread : "+dataThreadNum);
		System.out.printf("Start of Stack : 0x%8x\n", dataStartStack);
	}
}
