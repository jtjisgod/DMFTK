package forensic.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecReader {
	public static String read(String cmd)	{
		String output = "";
	    Process p;
		try {
			p = Runtime.getRuntime().exec(cmd);
		    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String line = null;
		    while((line = br.readLine()) != null){
		       output += line;
		    }
		} catch (IOException e) {
			output = "IOException!!";
			e.printStackTrace();
		}

		return output;
	}
}
