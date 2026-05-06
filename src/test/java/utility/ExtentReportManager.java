package utility;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentReports extent;
	ExtentTest test;
	
	
	public void onStart(ITestContext testContext) {
		
		String timestemp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName= "Test-Report"+timestemp+ ".html";
		
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(repName);
		sparkReporter.config().setDocumentTitle("AUtomation testing");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Functinal testing");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "content");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", System.getProperty("user.Name"));
		
		String os= testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operating System", "os");
		
		String browser= testContext.getCurrentXmlTest().getParameter("browser")	;
		extent.setSystemInfo("Browser","browser");
		
		
		List<String> includegroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includegroups.isEmpty()) {
			
			extent.setSystemInfo("Groups", includegroups.toString());

		}	
	}
	
	public void Pass(ITestResult result) {
		
		ExtentTest test= extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"Testcase pass");
		
		
	}
	
public void Fail(ITestResult result) {
		
		test= extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"Tets case failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		// need to add screenshot
		
		
	}

public void skip(ITestResult result) {
	test= extent.createTest(result.getClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.PASS, result.getName()+"Tets case Skip");
	test.log(Status.INFO, result.getThrowable().getMessage());
}

public void onFinish(ITestContext testContext) {
    extent.flush();
}

}
