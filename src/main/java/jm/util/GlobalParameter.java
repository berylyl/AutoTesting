package jm.util;

import java.io.File;

/**
 * 全局常量配置<br>
 * 采用相对路径。即工程所在的同级目录。这样做是为了将来编译成程序时，各种路径管理的方便.<br>
 * <em>日期：2014年9月27日</em>
 * @author yinlu
 * @version 1.0
 * 
 */
public class GlobalParameter {
	public static final String fileSeparator = System.getProperty("file.separator");
	
	//private static String CommonPath = System.getProperty("user.dir");
	private static String CommonPath = "/Users/yinlu/Documents/workspace/AutoTesting";
	public static String srcJavaPath = CommonPath+fileSeparator+"src/main/java";
	public static String srcResourcesPath = CommonPath+fileSeparator+"src/main/resources";
	public static String srcWebPath = CommonPath+fileSeparator+"webapp";
	public static String testDataPath = srcResourcesPath+fileSeparator+"testdate";
	
	
	
	/*
	public static String ConfigFilePath = CommonPath+"config"+fileSeparator;
	public static String ImagesPath = CommonPath+"images"+fileSeparator;
	public static String DriversPath = CommonPath+"drivers"+fileSeparator;
	public static String ScreenShotPath = CommonPath+"screenshot"+fileSeparator;
	public static String LogFolder = CommonPath+"logs"+fileSeparator;
	public static String TempCase = CommonPath+"tempCase"+fileSeparator;
	public static String CaseDataModel = CommonPath+"tempCase"+fileSeparator+"model"+fileSeparator;
	public static String LogPath = CommonPath+"logs"+fileSeparator+"Phoenix.log";
	public static String ReportPath = CommonPath+"report"+fileSeparator;
	public static String ReportCommonFile = CommonPath+"report"+fileSeparator+"common"+fileSeparator;
	public static String JavaDocFiles = CommonPath+"javadoc"+fileSeparator+"index.html";
	
	public static String ProductVersion = "1.1.15";
	public static String LastCompileDate = "2014.03.10";

	public static String myPath= CommonPath+"config"+fileSeparator;
	*/
	//jenkins-git
	public static String pluginGitClass = "hudson.plugins.git.GitSCM";
	public static String jenkinsConfigFile  = "config.xml";
	public static String jenkinsCredentFile  = "credentials.xml";
	
	public static void main(String[] args) {
		System.out.println("/Users/yinlu/Documents/workspace/AutoTesting/src/main/resources/testdate/");
		System.out.println(testDataPath);
	}
	

}
