package forensic.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import forensic.main.Cmd;

public class GetPresentUser extends Cmd {

	public GetPresentUser(){
		super();
		super.setCommand("get-presentUser");
		super.setInstruction("현재 접속한 유저들의 정보를 출력합니다.");
	}

	@Override
	public void doing() {
		try{
			String s;
			Process b = new ProcessBuilder("w", "/usr/run/utmp").start();
			BufferedReader stdOut   = new BufferedReader(new InputStreamReader(b.getInputStream()));
		    BufferedReader stdError = new BufferedReader(new InputStreamReader(b.getErrorStream()));
		    s = stdOut.readLine();
		    System.out.println(s);
		    while((s = stdError.readLine())!=null) System.out.println(s);
		    stdOut.close();
		    stdError.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
