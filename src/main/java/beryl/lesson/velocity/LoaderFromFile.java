package beryl.lesson.velocity;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class LoaderFromFile {
    
    public static void main(String[] args) throws Exception{
        //初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为file
        properties.setProperty("resource.loader", "file");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);
        
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("username", "张三");
        context.put("password", "123456789");
        context.put("age", "20");
        context.put("address", "陕西西安"); 
        context.put("blog", "http://blogjava.net/sxyx2008");
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        //从vm目录下加载hello.vm模板,在eclipse工程中该vm目录与src目录平级
        velocityEngine.mergeTemplate("index.vm", "gbk", context, writer);
        System.out.println(writer.toString());
        
    }
}