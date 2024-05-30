package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {

	

	public LeadsPage clickLeadsTab() throws IOException {
		try {
			getDriver().findElement(By.linkText("Leads")).click();
			reportStep("pass", "Leads tab clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "Unable to click leads tab "+e);
		}
		return new LeadsPage();
	}
	
}
