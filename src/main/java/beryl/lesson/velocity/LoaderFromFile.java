package beryl.lesson.velocity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class LoaderFromFile {

	public static void main(String[] args) throws Exception {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty("input.encoding", "UTF-8");
		velocityEngine.setProperty("output.encoding", "UTF-8");
		velocityEngine.init();
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("name", getDate());
		FileWriter fileWriter = new FileWriter(new File("C:/Users/Beryl/git/AutoTesting/resume/index.html"));
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		velocityEngine.mergeTemplate("vms/index.vm", "utf-8", velocityContext, bufferedWriter);
		bufferedWriter.flush();
		bufferedWriter.close();
	}  

	public static String getDate() {

		return "aaassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "end";
	}
}