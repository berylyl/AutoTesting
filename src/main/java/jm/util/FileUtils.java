package jm.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FileUtils {

	public FileUtils() {
		// TODO Auto-generated constructor stub
	}

	// filter xml java ,jpg ...
	public static class FileFilter implements FilenameFilter {
		private String type;

		public FileFilter(String type) {
			this.type = type;
		}

		public boolean accept(File dir, String name) {
			return name.endsWith(type);
		}
	}

	// Get xmlfile names
	public static String[] xmlFilesInDir(String path) {
		File dir = new File(path);
		String[] xmlNames = null;
		if (dir.isDirectory()) {
			xmlNames = dir.list(new FileFilter(".xml"));
		} else {
			new JMException("err ,not a dir");
		}
		return xmlNames;
	}

	// Get dir names
	public static ArrayList<String> subDirs(String path) {
		ArrayList<String> list = new ArrayList<>();
		File dir = new File(path);
		if (dir.isDirectory()) {
			File[] listFiles = dir.listFiles();
			for (File f : listFiles) {
				if (f.isDirectory()) {
					list.add(f.getName());
				}
			}

		}else{
			System.out.println(dir.isDirectory());
		}
		return list;
	}
  
	//Get File createTime
	public static String getCreateTime(String path){
		File file = new File(path);
		Long time =file.lastModified();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
		String formatTime = sdf.format(new Date(time));
		return formatTime;
	}
	
	public static void main(String[] args) throws IOException {
		String property = System.getProperty("user.name");
		System.out.println(property);
		
		/*
		 ArrayList<String> subDirs = FileUtils.subDirs(GlobalParameter.testDataPath);
		 for(String str :subDirs){ 
			 System.out.println(str); 
		 }*/

		/*
		 * File dir = new File(GlobalParameter.testDataPath); File[] files =
		 * dir.listFiles(); for(File f: files){ if(f.isDirectory()){
		 * System.out.println(f); String proName = f.getName();
		 * System.out.println(proName);
		 * 
		 * } }
		 */

	}
}
