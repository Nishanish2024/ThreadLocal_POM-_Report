package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class ViewLeadPage extends ProjectSpecificMethod {

	

	public void retriveLeadID() throws IOException {
		try {
			String leadId = getDriver().findElement(By.id("viewLead_companyName_sp")).getText();
			System.out.println(leadId);
			reportStep("pass", "Lead is "+leadId);
		} catch (Exception e) {
			reportStep("fail", "unable to retrive the lead id "+e);
		}
	}
	
	public void clickDuplicateLeadBtn() {
		
	}
	
	public void clickEditLeadBtn() {
		
	}
	
	public void clickDeleteLeadBtn() {
		
	}
	
}
