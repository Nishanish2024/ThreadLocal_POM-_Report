package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod{

	

	public LoginPage enterUsername() throws IOException {
		
		try {
			getDriver().findElement(By.id("username")).sendKeys("demosalesmanager");
//			File src = getDriver().getScreenshotAs(OutputType.FILE);
//			File desc = new File("./snaps/username.png");
//			FileUtils.copyFile(src, desc);
//			test.pass("username entered as demosalesmanager ", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/username.png").build());
			reportStep("pass", "Username entered as demosalesmanager");
		} catch (Exception e) {
//			File src = getDriver().getScreenshotAs(OutputType.FILE);
//			File desc = new File("./snaps/username.png");
//			FileUtils.copyFile(src, desc);
//			test.fail("Unable to enter username", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/username.png").build());
			reportStep("fail", "Unable to enter the username "+e);
		}
		
		return this;
	}
	
	public LoginPage enterPassword() throws IOException {
		try {
			getDriver().findElement(By.id("password")).sendKeys("crmsfa");
			reportStep("pass", "password entered as crmsfa");
		} catch (Exception e) {
			reportStep("fail", "unable to enter the password "+e);
		}
		return this;
	}
	
	public WelcomePage clickLoginBtn() throws IOException {
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
			reportStep("pass", "Login clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "failed to click login button "+e);
		}

		return new WelcomePage();
	}
	
}
