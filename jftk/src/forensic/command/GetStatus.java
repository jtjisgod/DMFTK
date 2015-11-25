package forensic.command;

import java.util.Scanner;

import forensic.main.Cmd;
import forensic.main.FileReader;
import forensic.main.TaskStat;

public class GetStatus extends Cmd {
	public GetStatus(){
		super();
		super.setCommand("get-status");
		super.setInstruction("지정한 PID를 가진 프로세스의 상태 정보를 가져옵니다.");
	}
	@Override
	public void doing() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input PID : ");
		int pid = sc.nextInt();
		
		TaskStat stat = new TaskStat(pid);
		stat.display();
	}
	
}
