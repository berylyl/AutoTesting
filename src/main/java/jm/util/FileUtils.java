package jm.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileUtils {
	static File dir = new File(GlobalParameter.testDataPath);

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

	public static String[] XMLFilesInDir(String path) {
		File dir = new File(path);
		String[] xmlNames = null;
		if (dir.isDirectory()) {
			xmlNames = dir.list(new FileFilter(".xml"));
		} else {
			new JMException("err ,not a dir");
		}
		return xmlNames;
	}

	public static void main(String[] args) throws IOException {
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
