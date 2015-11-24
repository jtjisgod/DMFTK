package forensic.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * forensic.main
 *  ㄴTask
 * </pre>
 * @author : 장태진
 * @version: 1.0
 */
public class Task {
	public static List getList()	{
		List<Integer> taskArr = new ArrayList<>();

		File f = null;
		File[] paths;
		try{
			f = new File("/proc");
			paths = f.listFiles();
			for(File file : paths)	{
				try{
					int taskId;
					taskId = Integer.parseInt(file.getName());
					taskArr.add(taskId);
				} catch (NumberFormatException e)	{ }
			}
		} catch(Exception e)	{
			System.out.println("Exception!!");
		}
		
		return taskArr;
	}
}
