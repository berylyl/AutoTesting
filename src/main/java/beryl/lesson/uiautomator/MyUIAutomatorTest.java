package beryl.lesson.uiautomator;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import  com.android.uiautomator.testrunner.*;
public class MyUIAutomatorTest extends UiAutomatorTestCase{
	
	
	public MyUIAutomatorTest(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public void testDemo() throws UiObjectNotFoundException {

	    getUiDevice().pressHome();

	    UiObject allAppsButton = new UiObject(new UiSelector()
	        .description("Apps"));
	    allAppsButton.clickAndWaitForNewWindow();

	    // 进入设置菜单
	    UiObject settingApp = new UiObject(new UiSelector().text("Settings"));
	    settingApp.click();
	    //休眠3秒
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e1) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    // 进入语言和输入法设置
	    UiScrollable settingItems = new UiScrollable(new UiSelector().scrollable(true));

	    UiObject languageAndInputItem = settingItems.getChildByText(
	        new UiSelector().text("Language & input"), "Language & input", true);
	    languageAndInputItem.clickAndWaitForNewWindow();
	  }
	
	
	public static void main(String[] args) throws UiObjectNotFoundException {
		System.out.println("123");
		/*
		MyUIAutomatorTest test = new MyUIAutomatorTest();
		test.testDemo();*/
	}

}
