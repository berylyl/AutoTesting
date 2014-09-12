package jm.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test {
	public static void main(String[] args){
		InputStream in = null;
		try {
			Process pro = Runtime.getRuntime().exec("pwd");
			pro.waitFor();
			in = pro.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(in));
			String result = read.readLine();
			System.out.println("INFO:"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}