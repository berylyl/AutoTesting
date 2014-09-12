package beryl.lesson.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleForAjax  {
	
    static WebDriver driver;
    
    @BeforeClass
    public static void init() {
    	System.out.println("init...");
    	// 创建一个 FireFox 的浏览器实例
    	driver = new FirefoxDriver();
    }
	
    @Test
    public void test() {
    	// 让浏览器访问 zTree Demo
    	driver.get("http://www.ztree.me/v3/demo/cn/core/async.html");
    	
    	// 等待 zTree 初始化完毕，10秒内每隔500毫秒扫描1次页面变化
    	try {
    		(new WebDriverWait(driver, 10, 500)).until(new ExpectedCondition<Boolean>() {
    			public Boolean apply(WebDriver d) {
    				WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("return $('#treeDemo li').get(0);");
    				return element != null;
    			}
    		});
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	((JavascriptExecutor)driver).executeScript("window.zTreeObj = $.fn.zTree.getZTreeObj('treeDemo');");
    	
    	//判断节点总数
    	Long count =(Long) ((JavascriptExecutor)driver).executeScript("return window.zTreeObj.transformToArray(window.zTreeObj.getNodes()).length;");
    	
    	//利用 expandNode 方法展开第一个父节点
    	((JavascriptExecutor)driver).executeScript("window.zTreeNode = window.zTreeObj.getNodeByParam('isParent', true); window.zTreeObj.expandNode(window.zTreeNode, true);");
    	try {
    		(new WebDriverWait(driver, 10, 500)).until(new ExpectedCondition<Boolean>() {
    			public Boolean apply(WebDriver d) {
    				Boolean isAjaxing = (Boolean) ((JavascriptExecutor)driver).executeScript("return !!window.zTreeNode.isAjaxing;");
    				return !isAjaxing;
    			}
    		});
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	//判断节点总数
    	count =(Long) ((JavascriptExecutor)driver).executeScript("return window.zTreeObj.transformToArray(window.zTreeObj.getNodes()).length;");
    	
    	//模拟 click 事件 单击节点 +/- 号展开
    	WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("window.zTreeNode = window.zTreeNode.children[0]; return $('#' + window.zTreeNode.tId + '_switch').get(0);");
    	element.click();
    	
    	// 展开第一个子节点
    	((JavascriptExecutor)driver).executeScript("window.zTreeObj.expandNode(window.zTreeNode, true);");
    	try {
    		(new WebDriverWait(driver, 10, 500)).until(new ExpectedCondition<Boolean>() {
    			public Boolean apply(WebDriver d) {
    				Boolean isAjaxing = (Boolean) ((JavascriptExecutor)driver).executeScript("return !!window.zTreeNode.isAjaxing;");
    				return !isAjaxing;
    			}
    		});
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	//判断节点总数
    	count =(Long) ((JavascriptExecutor)driver).executeScript("return window.zTreeObj.transformToArray(window.zTreeObj.getNodes()).length;");
    	
    }
    
    @AfterClass
    public static void destory() {
    	System.out.println("destory...");
    	//关闭浏览器
    	driver.quit();
    }
}