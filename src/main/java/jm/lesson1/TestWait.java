package jm.lesson1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWait {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = System.getProperty("user.dir") + "/src/main/webapp/html/wait.html";// "/Your/Path/to/main.html"
		driver.get("file:///"+url);

		driver.findElement(By.id("b")).click();

		WebElement wl = driver.findElement(By.cssSelector(".red_box"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid yellow'", wl);

	}

}
