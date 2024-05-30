package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_001_LoginTC  extends ProjectSpecificMethod{

	@Test
	public void runLogin() throws IOException {
		
		LoginPage lp = new LoginPage(); 
		
		lp.enterUsername()
		.enterPassword()
		.clickLoginBtn()
		.clickCrmsfa();
		
	
	}
	
	@BeforeTest
	public void setData() {
		testcaseName = "Login testcase";
		testcaseDescription = "Login testcase with positive functionality";
		authorName = "Gokul";
		categoryName = "Smoke";
	}
	
}
