package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.ProjectSpecificMethod;

public class WelcomePage extends ProjectSpecificMethod{

	

	public HomePage clickCrmsfa() throws IOException {
		try {
			getDriver().findElement(By.linkText("CRM/SFA")).click();
			reportStep("pass", "CRMSFA link clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "Unable to click CRMSFA link "+e);
		}
		return  new HomePage();
	}
	
	public LoginPage clickLogoutBtn() {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new LoginPage();
	}
	
	
	
	
	
}
