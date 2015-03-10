package beryl.lesson.testng;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


public class CustomListener extends TestListenerAdapter {
    
    
    
    private int passCount=0;
    private int failCount=0;
    private int skipCount=0;
    private int sumCount=0;

    private VelocityEngine velocityEngine = new VelocityEngine();
    private StringWriter stringWriter = new StringWriter();
    private VelocityContext velocityContext = new VelocityContext();
    private Template template = null;
    
    private String  path = System.getProperty("user.dir")+ File.separator +"resume"+File.separator+"result.html";
    
    @Override
    public void onStart(ITestContext testContext) {
        velocityEngine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");  
        velocityEngine.setProperty("input.encoding", "UTF-8");
        velocityEngine.setProperty("output.encoding", "UTF-8");
        velocityEngine.init();
        template = velocityEngine.getTemplate("vms/result.vm");
        velocityContext.put("begin", getTime());
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        sumCount++;
    }

    
    @Override
    public void onTestFailure(ITestResult tr) {
        failCount++;
        Reporter.log(tr.getName()+"--Test method failed\n");
        
        String fileName = "../log/" + System.currentTimeMillis()+ ".jpg";
            Reporter.log("<a href="+fileName+">图片</a>");
        
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        skipCount++;
        Reporter.log(tr.getName() + "--Test method skipped\n");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        takeScreenShot(tr);
        passCount++;
        Reporter.log(tr.getName() + "--Test method success\n");
    }

    @Override
    public void onFinish(ITestContext testContext) {
    	Date startDate = testContext.getStartDate();
        velocityContext.put("end", getTime());
        //velocityContext.put("content", sb.toString());
        velocityContext.put("sumCount", sumCount);
        velocityContext.put("passCount", passCount);
        velocityContext.put("Reporter", Reporter.getOutput());
        velocityContext.put("percentage", (float)passCount/(float)sumCount);
        template.merge(velocityContext, stringWriter);
        List<String> output = Reporter.getOutput();
        testResult(path,stringWriter.toString());
    }
    
    public void testResult(String path,String cont){
        try {
            OutputStream outputStream = new FileOutputStream(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
            bw.write(cont);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private static  String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }
    
    /**
     * 自动截图，保存图片到本地以及html结果文件中
     * 
     * @param tr
     */
    private void takeScreenShot(ITestResult tr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String mDateTime = formatter.format(new Date());
        String fileName = mDateTime + "_" + tr.getName();
       // String filePath = OrangeiOS.driver.getScreenshotAs(fileName);
        String filePath = "/Users/yinlu/Desktop/JumeiCase/jumei/log/2015-1-26-10-10-48.jpg";
        Reporter.setCurrentTestResult(tr);
        Reporter.log(filePath);
               //这里实现把图片链接直接输出到结果文件中，通过邮件发送结果则可以直接显示图片
        Reporter.log("<img src=\"../" + filePath + "\"/>");

    }
}