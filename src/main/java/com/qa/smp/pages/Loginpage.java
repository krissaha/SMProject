package com.qa.smp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.smp.pages.CustomerCorporatePage;
import com.qa.smp.base.TestBase;


public class Loginpage extends TestBase
{
	// Page factory - OR
	
	@FindBy(name = "Email")
	WebElement email;
	
	@FindBy(name = "Password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[.//div[@class='companylogoarea']]//a[@class='logoarea']")
	WebElement logo;
	
	@FindBy(xpath = "//a[contains(text(),' Terms of Use.')]")
	WebElement termsofuse;
	
	// Initializing the page object
		public Loginpage() {
			PageFactory.initElements(driver, this);
		}
	
	// Business Components Methods
	public CustomerCorporatePage logIn(String em, String psd) throws Exception
	{
		email.sendKeys(em);
		password.sendKeys(psd);
		String hiddenCaptchaVal = driver.findElement(By.id("HiddenCaptcha")).getAttribute("value");
		driver.findElement(By.id("Captcha")).sendKeys(hiddenCaptchaVal);
		loginBtn.click();
		Thread.sleep(5000);
		return new CustomerCorporatePage();
	}
	
	// All Verifications and Validations
	public void verify_loginpage_title()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Login",title);
	}
	
	public void verify_logo_loginpage()
	{
		boolean l = logo.isDisplayed();
		Assert.assertEquals(l, true);
	}
	
	public void verify_termsofuse()
	{
		boolean tuse =termsofuse.isDisplayed();
		Assert.assertEquals(tuse, true);
		
	}
	
}
