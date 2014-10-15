package beryl.lesson.system;

import java.util.Properties;

public class SystemExample {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println(properties);
        
        System.out.println("project path ="+System.getProperty("user.dir"));
        System.out.println("user name ="+System.getProperty("user.name"));
    }
}
