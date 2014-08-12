package jm.lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FameStudy {

	
	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		String url =  System.getProperty("user.dir") +"/src/main/webapp/html/main.html";
		dr.get("file:///"+url);

		//在default content定位id="id1"的div
		//dr.findElement(By.id("id1"));
		//此时，没有进入到id="frame"的frame中时，以下两句会报错
		//dr.findElement(By.id("div1"));//报错
		//dr.findElement(By.id("input1"));//报错
		
		//进入id="frame"的frame中，定位id="div1"的div和id="input1"的输入框。
		dr.switchTo().frame("frame");	
		dr.findElement(By.id("div1"));
		//WebElement e = dr.findElement(By.id("input1"));
		WebElement e = dr.findElement(By.xpath("/html/body/input"));
		e.sendKeys("ddd");
		//此时，没有跳出frame，如果定位default content中的元素也会报错。
		//dr.findElement(By.id("id1"));//报错
		
		//跳出frame,进入default content;重新定位id="id1"的div
		dr.switchTo().defaultContent();
		dr.findElement(By.id("id1"));
	}

}