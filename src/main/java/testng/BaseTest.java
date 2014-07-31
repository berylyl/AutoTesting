package testng;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

@ContextConfiguration(locations={"classpath:/Users/yinlu/Documents/workspace/phoenix.client/src/main/resources/applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {
  @Test
  public void test() {
	  System.out.println("I'm basic test");
  }
}
