package forensic.main;

import java.util.ArrayList;
import java.util.List;

public class Command {

	public static Command obj = new Command();
	private Command() {}
	
	private List<Cmd> commands = new ArrayList<Cmd>();
	
	public void excute(String command) throws Exception	{
		if("".equals(command.trim()))	{
			return;
		}
		if("help".equals(command.trim()))	{
			help();
			return;
		}
		if("clear".equals(command.trim()))	{
			ExecReader.read("clear");
			return;
		}
		Cmd cmd = search(command);
		cmd.doing();
	}
	
	public Cmd search(String command) throws Exception	{
		for(Cmd cmd : commands)	{
			if(cmd.getCommand().equals(command)) {
				return cmd;
			}
		}
		throw new Exception("'" + command + "' 는/은 존재하지 않는 명령어 입니다.\r\n'help' 명령어를 통해 명령어를 확인하세요!\r\n");
	}

	public void help()	{
		for(Cmd cmd : commands)	{
			System.out.println(cmd);
		}
	}
	
	public void load(List<Cmd> commands)	{
		this.commands = commands;
	}
}
