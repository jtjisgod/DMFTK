package forensic.command;

import forensic.main.Cmd;
import forensic.main.FileReader;

public class GetDeviceInfo extends Cmd {
	public GetDeviceInfo()	{
		super();
		super.setCommand("get-diskInfo");
		super.setInstruction("컴퓨터의 디스크 정보들을 가지고 옵니다.");
	}
	
	public void doing()	{
		String kwKind = "";
		String value = "";
		String[] cutting;

		value = FileReader.obj.read("/proc/scsi/scsi");
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
