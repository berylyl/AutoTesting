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
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("input.encoding", "UTF-8");
        velocityEngine.setProperty("output.encoding", "UTF-8");
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("index.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("packageName", "dddd");
        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
    }
}