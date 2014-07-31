package testng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import service.UserService;
import bean.User;

@ContextConfiguration(locations = { "applicationContext.xml" })
public class TestUser extends AbstractTestNGSpringContextTests {

	@Autowired
	UserService userService;

	@Test
	public void test_save_user() {
		User user = new User();
		user.setPasswd("123456");
		userService.save(user);
	}

	@Test
	public void test_inject_factory() {
		Assert.assertNotNull(userService);
	}
}