package jm.lesson1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ShotScreen {

	/**
	 * @author gongjf
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws Exception {

		WebDriver dr = new FirefoxDriver();
		dr.get("http://www.51.com");

		// 这里等待页面加载完成
		Thread.sleep(5000);
		// 下面代码是得到截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File("/images/test.png"));
	}
}
