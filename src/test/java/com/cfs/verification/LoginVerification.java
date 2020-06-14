package com.cfs.verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cfs.init.AbstractPage;
import com.cfs.init.Common;

public class LoginVerification extends AbstractPage {

	public LoginVerification(WebDriver driver) {
		super(driver);
	}

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//button[@value='Submit']")
	private WebElement btn_Login;

	@FindBy(xpath = ".//div/div[1]/a/span[@class='user-text']")
	private WebElement userName;

	/* -------------------- Verification methods -------------------- */

	public boolean dashboardVerification() {

		Common.pause(2);

		try {
			Common.waitForElementIsDisplayed(userName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return userName.isDisplayed();

	}

	public boolean logoutVerification() {

		return btn_Login.isDisplayed();

	}
}
