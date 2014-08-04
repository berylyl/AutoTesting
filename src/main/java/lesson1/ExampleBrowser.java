package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExampleBrowser {

	public WebDriver driver;
	public String chromDriverPath = System.getProperty("user.dir") + "/drivers/" + "chromedriver";
	
	public ExampleBrowser(WebDriver driver) {
		this.driver = driver ;
	}
	
	public void open(){
		// 让浏览器访问 Baidu
		driver.get("http://www.baidu.com");
		
		// 获取 网页的 title
		System.out.println("1 Page title is: " + driver.getTitle());
		System.out.println(".......");
	}
	
	public void DoRequest() {


		// 通过 id 找到 input 的 DOM
		WebElement element = driver.findElement(By.id("kw1"));

		// 输入关键字
		element.sendKeys("zTree");

		// 提交 input 所在的 form
		element.submit();

		// 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
		(new WebDriverWait(driver, 100))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.getTitle().toLowerCase().startsWith("ztree");
					}
				});

		// 显示搜索结果页面的 title
		WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/span[1]/input"));
		System.out.println(element2.getLocation());
		System.out.println("2 Page title is: " + driver.getTitle());
		System.out.println("2 Page url is: " + driver.getCurrentUrl());


	}
	
	public void close(){
		// 关闭浏览器
		driver.quit();
	}

	public static void main(String[] args) {
		//ExampleBrowser  br = new ExampleBrowser(new ChromeDriver());
		/*ExampleBrowser  br = new ExampleBrowser(new FirefoxDriver());
		br.open();
		br.DoRequest();
		br.close();*/
		System.out.println("ddddddddddd");
	}
}