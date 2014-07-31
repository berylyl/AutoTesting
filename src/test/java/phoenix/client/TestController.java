package phoenix.client;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bean.User;
import dao.UserDao;

public class TestController {

	public static void main(String[] args) {
		ApplicationContext aContext = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		UserDao userMapper = aContext.getBean(UserDao.class);
		User user = userMapper.getUser("1");
		System.out.println(user.getUname());
	}
}