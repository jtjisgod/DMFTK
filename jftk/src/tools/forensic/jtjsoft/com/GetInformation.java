package tools.forensic.jtjsoft.com;

import forensic.jtjsoft.com.Cmd;
import forensic.jtjsoft.com.ExecReader;
import forensic.jtjsoft.com.FileReader;

public class GetInformation extends Cmd {
	public GetInformation()	{
		super();
		super.setCommand("get-information");
		super.setInstruction("컴퓨터의 기본적인 정보들을 가지고 옵니다.");
	}
	
	public void doing()	{
		String cpu = "";
		String ram = "";
		String version = "";
		String bit = "";
		String value = "";
			    
	    value = FileReader.obj.read("/proc/cpuinfo");
		cpu = value.split("model name	: ")[1].split("stepping")[0].trim();

		value = FileReader.obj.read("/proc/meminfo");
		ram = value.split("MemTotal:")[1].split("kB")[0].trim();
		
		value = FileReader.obj.read("/proc/version");
		version = value.trim();
		
		bit = ExecReader.read("arch");

		System.out.println("CPU : " + cpu);
		System.out.println("RAM : " + (Integer.parseInt(ram)/1024) + "MB");
		System.out.println("VER : " + version);
		System.out.println("BIT : " + bit);
	}
}
