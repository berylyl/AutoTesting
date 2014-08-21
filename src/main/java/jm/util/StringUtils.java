package jm.util;


public class StringUtils {
	public static String join(String tag,String... strs){
		StringBuffer sb = new StringBuffer();
		for(String str:strs){
			sb.append(str).append(tag);
		}
		return sb.toString();
		
	}
	public static void main(String[] args) {
	}
}
