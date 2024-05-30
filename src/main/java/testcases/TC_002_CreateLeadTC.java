package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_002_CreateLeadTC extends ProjectSpecificMethod {

	@Test(dataProvider = "sendData")
	public void runCreateLead(String cname, String fname, String lname, String phno) throws IOException {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLoginBtn()
		.clickCrmsfa()
		.clickLeadsTab()
		.clickCreateLeadLink()
		.enterCompanyName(cname)
		.enterFirstName(fname)
		.enterLastname(lname)
		.enterPhno(phno)
		.clickCreateLeadBtn()
		.retriveLeadID();
		
		
		
	}
	
	
	
	@BeforeTest
	public void setData() {
		testcaseName = "Create lead testcase";
		testcaseDescription = "Create lead testcase with positive functionality";
		authorName = "Gokul";
		categoryName = "Regression";
		excelFileName ="CreateLead";
	}
}
