package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumBasics extends Utils {


	private LoginPage loginPage;
	private HomePage homePage;

	@Test(description = "Verify that user can login with valid credentials")
	public void TC_01_Login_With_Valid_Credentials() {
		loginPage= new LoginPage(driver);
		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox( "secret_sauce");
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isProductHeaderDisplayed());
	}


	@Test(description = "Verify that user can login with Invalid credentials")
	public void TC_02_Login_With_inValid_Credentials() {
		loginPage= new LoginPage(driver);
		loginPage.enterToUsernameTextbox("incorrecUser");
		loginPage.enterToPasswordTextbox( "InCorrecPassword");
		loginPage.clickToLoginButton();
	}
}
