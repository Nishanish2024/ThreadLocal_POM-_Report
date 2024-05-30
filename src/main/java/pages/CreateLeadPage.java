package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class CreateLeadPage extends ProjectSpecificMethod{

	

	public CreateLeadPage enterCompanyName(String cname) throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			reportStep("pass", "Company name entered as "+cname);
		} catch (Exception e) {
			reportStep("fail", "unable to enter the company name "+e);
		}
		return this;
	}
	
	public CreateLeadPage enterFirstName(String fname) throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			reportStep("pass", "first name entered as "+fname);
		} catch (Exception e) {
			reportStep("fail", "unable to enter the first name "+e);
		}
		return this;
	}
	
	public CreateLeadPage enterLastname(String lname) throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			reportStep("pass", "Last name entered as "+lname);
		} catch (Exception e) {
			reportStep("fail", "unabled to enter last name "+e);
		}
		return this;
	}
	
	public CreateLeadPage enterPhno(String phno) throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
			reportStep("pass", "Phno entered as "+phno);
		} catch (Exception e) {
			reportStep("fail", "unable to enter ph no "+e);
		}
		return this;
	}
	
	public ViewLeadPage clickCreateLeadBtn() throws IOException {
		try {
			getDriver().findElement(By.className("smallSubmit")).click();
			reportStep("pass", "create lead button clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "unable to click create lead button "+e);
		}
		return new ViewLeadPage();
	}
	
}
