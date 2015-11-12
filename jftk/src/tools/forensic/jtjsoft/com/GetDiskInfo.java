package tools.forensic.jtjsoft.com;

import forensic.jtjsoft.com.Cmd;
import forensic.jtjsoft.com.FileReader;

public class GetDiskInfo extends Cmd {
	public GetDiskInfo()	{
		super();
		super.setCommand("get-deviceInfo");
		super.setInstruction("컴퓨터가 사용하는 장치들을 보여줍니다.");
	}
	
	public void doing()	{
		String kwKind = "";
		String value = "";
		String[] cutting;

		value = FileReader.obj.read("/proc/devices");
		cutting = value.split("Model: ");
		int i = 0;
		for(String string : cutting)	{
			i ++;
			if(i == 1) continue;
			kwKind += (i-1) + ". " + string.split(" ")[0] + "\n";
		}

		System.out.println("디스크 종류(SSD/HDD/CDROM/DVDROM)\n" + kwKind);
	}
}
