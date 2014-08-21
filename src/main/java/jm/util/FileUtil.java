package jm.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {
	static File dir = new File(GlobalParameter.testDataPath);
	public static void main(String[] args) throws IOException {
		File dir = new File(GlobalParameter.testDataPath);
		File[] files = dir.listFiles();
		for(File f: files){
			if(f.isDirectory()){
				System.out.println(f);
				String proName = f.getName();
				System.out.println(proName);
				
			}
		}
		
	}
}
