package forensic.command;

import forensic.main.Cmd;
import forensic.main.FileReader;

public class GetUpTime extends Cmd {
	public GetUpTime()	{
		super();
		super.setCommand("get-uptime");
		super.setInstruction("컴퓨터가 사용하는 장치들을 보여줍니다.");
	}
	
	public void doing()	{
		String value = "";

		value = FileReader.obj.read("/proc/uptime");
		value = value.split(" ")[0];
		
		int count = (int)Float.parseFloat(value);
				
		System.out.println("시스템 가동 : " + count + "초 지남, " + (count/60/60%60) + "시간 " + (count/60%60) + "분 " + (count%60) + "초");
	}
}
