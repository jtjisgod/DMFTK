package forensic.jtjsoft.com;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
	public static FileReader obj = new FileReader();
	private BufferedReader bf;
	private FileReader() {}

	public String read(String path)	{
		String row;
		String text = "";
		try {
			bf = new BufferedReader(new java.io.FileReader(path));		 
			while ((row = bf.readLine()) != null) {
				text += row;
			}
		} catch (IOException e) {
			System.out.println("파읽을 읽을 수 없습니다.");
		}
		return text;
	}
}
