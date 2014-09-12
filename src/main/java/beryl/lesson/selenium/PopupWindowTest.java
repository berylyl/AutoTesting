package beryl.lesson.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupWindowTest {


	/**
	 * @author gongjf
	 */
	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		String url =  System.getProperty("user.dir") +"/src/main/webapp/html/main.html";
		dr.get("file:///"+url);
		dr.findElement(By.id("51")).click();
		//得到当前窗口的句柄
		String currentWindow = dr.getWindowHandle();
		//得到所有窗口的句柄
		Set<String> handles = dr.getWindowHandles();
		for(String o:handles){
			if (!currentWindow.equals(o)){
				WebDriver window = dr.switchTo().window(o);
				System.out.println("title,url = "+window.getTitle()+","+window.getCurrentUrl());				
			}
		}
	}

}
