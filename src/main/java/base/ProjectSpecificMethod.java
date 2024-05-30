package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.DataLibrary;

public class ProjectSpecificMethod {

	public static ExtentReports extent;
//	public static ExtentTest node;
	public String testcaseName, testcaseDescription, authorName, categoryName, excelFileName;
	
	
	private static final ThreadLocal<RemoteWebDriver> rd = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<String> testName = new ThreadLocal<String>();
	private static final ThreadLocal<ExtentTest> node = new ThreadLocal<ExtentTest>();
	
	public void setDriver() {
		rd.set(new ChromeDriver());
	}
	
	public RemoteWebDriver getDriver() {
		return rd.get();
	}
	
	
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
	}
	
	
	@BeforeClass
	public void setReport() {
	ExtentTest	test = extent.createTest(testcaseName, testcaseDescription);
		test.assignAuthor(authorName);
		test.assignCategory(categoryName);
		// Assign value for the parentTest
		parentTest.set(test);
		//Assign value for the testName
		testName.set(testcaseName);
		
		
		/*
		 * //set node, node will help to create sub folders for a single testcase node =
		 * test.createNode(testcaseName);
		 */	}
	
	
		public ExtentTest getTest() {
			return parentTest.get();
		}
		
		public String getTestName() {
			return testName.get();
		}
		
		public void setNode() {
			ExtentTest childNode = getTest().createNode(getTestName());
			node.set(childNode);
		}
		
		public ExtentTest getNode() {
			return node.get();
		}
		
	
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	
	
	public int takeSnap() throws IOException {
		int random = (int) ((Math.random())*999999);
		File src = getDriver().getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+random+".png");
		FileUtils.copyFile(src, desc);
		return random;
	}
	
	
	public void reportStep(String status, String desc) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			getNode().pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail")) {
			getNode().fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
	}
	
	
	
	
	
	@BeforeMethod
	public void preCondition() {
		setNode();
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get("http://leaftaps.com/opentaps");
		
	}
	
	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
	
	@DataProvider(name = "sendData", indices = {0,1} )
	public String[][] fetchData() throws IOException {
		return DataLibrary.excelData(excelFileName);
	}
	
}
