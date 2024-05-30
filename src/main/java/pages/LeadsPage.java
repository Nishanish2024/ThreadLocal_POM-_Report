package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.ProjectSpecificMethod;

public class LeadsPage extends ProjectSpecificMethod{

	

	public CreateLeadPage clickCreateLeadLink() throws IOException {
		try {
			getDriver().findElement(By.linkText("Create Lead")).click();
			reportStep("pass", "Create lead link clicked successfuly");
		} catch (Exception e) {
			reportStep("fail", "Unable to click create lead link "+e);
		}
		return new CreateLeadPage();
	}
	
	public void clickFindLeadLink() {
		
	}
	
	public void clickMergeLeadLink() {
		
	}
	
	
}
