package jm.lesson1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DialogsStudy {

	/**
	 * @author gongjf
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		String url = System.getProperty("user.dir") + "/src/main/webapp/html/Dialogs.html";// "/Your/Path/to/main.html"
		dr.get("file:///"+url);
		
		//点击第一个按钮，输出对话框上面的文字，然后叉掉
		dr.findElement(By.id("alert")).click();
		Thread.sleep(100);
		Alert alert = dr.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		Thread.sleep(100);
		alert.dismiss();
		
		//点击第二个按钮，输出对话框上面的文字，然后点击确认
		dr.findElement(By.id("confirm")).click();
		Alert confirm = dr.switchTo().alert();
		String text1 = confirm.getText();
		System.out.println(text1);
		Thread.sleep(100);
		confirm.accept();
		
		//点击第三个按钮，输入你的名字，然后点击确认，最后
		dr.findElement(By.id("prompt")).click();
		Alert prompt = dr.switchTo().alert();
		String text2 = prompt.getText();
		System.out.println(text2);
		Thread.sleep(100);
		prompt.sendKeys("jarvi");
		prompt.accept();
		
	}

}
