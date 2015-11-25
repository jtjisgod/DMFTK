package forensic.main;

import java.util.ArrayList;
import java.util.List;

import forensic.command.*;

public class CommandLoading {

	public static CommandLoading obj = new CommandLoading();
	private CommandLoading() {}

	public void Load()	{
		List<Cmd> commands = new ArrayList<Cmd>();
		commands.add(new GetInformation());
		commands.add(new GetDiskInfo());
		commands.add(new GetTaskList());
		commands.add(new GetUpTime());
		commands.add(new GenerateCore());
		commands.add(new Make());
		Command.obj.load(commands);
	}
}
