package com.cfs.indexpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cfs.init.AbstractPage;
import com.cfs.init.Common;
import com.cfs.init.SeleniumInit;
import com.cfs.verification.LoginVerification;

public class LoginIndexpage extends AbstractPage {

	public LoginIndexpage(WebDriver driver) {
		super(driver);
	}

	/* -------------------- Declarations -------------------- */

	public static int logstep;

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//*[@name='email']")
	private WebElement txt_username;

	@FindBy(xpath = ".//*[@name='password']")
	private WebElement txt_password;

	@FindBy(xpath = ".//button[@value='Submit']")
	private WebElement btn_Login;

	@FindBy(xpath = ".//*[@id='frmLogin']/div[3]/div/div")
	private WebElement selectLanguage;

	@FindBy(xpath = ".//*[@id='frmLogin']/div[4]/div/div")
	private WebElement selectSite;

	@FindBy(xpath = ".//*[@id='frmLogin']/div[4]/div//ul/li//span[contains(text(),'MICT')]")
	private WebElement selectMICT;

	@FindBy(xpath = ".//*[@id='frmLogin']/div[4]/div//ul/li//span[contains(text(),'LCIT')]")
	private WebElement selectLCIT;

	@FindBy(xpath = ".//*[@id='frmLogin']/div[4]/div//ul/li//span[contains(text(),'Select Site')]")
	private WebElement noSiteSelection;

	@FindBy(xpath = ".//div//div[1]/a/span[@class='user-text']")
	private WebElement userAccount_drpdwn;

	@FindBy(xpath = ".//div//div[1]/div/ul/li[1]/a[contains(text(),'Logout')]")
	private WebElement btn_logout;

	@FindBy(xpath = ".//header/div/div/p[@class='version']")
	private WebElement lblTestVersion;

	/* -------------------- Indexpages Methods -------------------- */

	public LoginVerification login(String loginUserName, String loginPassword, String loginLanguage, String loginSite) {

		log("Step " + (logstep++) + ": Enter Username: <font color=#9400D3>" + loginUserName + "</font>");

		Common.type(txt_username, loginUserName);

		log("Step " + (logstep++) + ": Enter password: <font color=#9400D3>" + loginPassword + "</font>");

		Common.type(txt_password, loginPassword);

		log("Step " + (logstep++) + ": Select language: <font color=#9400D3>" + loginLanguage + "</font>");

		log("Step " + (logstep++) + ": Select site: <font color=#9400D3>" + loginSite + "</font>");

		selectSite(loginSite);

		log("Step " + (logstep++) + ": Click on 'Login' button.");

		Common.clickOn(driver, btn_Login);

		Common.pause(3);

		return new LoginVerification(driver);

	}

	public LoginVerification selectSite(String site) {

		Common.pause(2);

		Common.jsClick(driver, selectSite);

		Common.pause(2);

		switch (site) {
		case "MICT":
			Common.jsClick(driver, selectMICT);
			break;
		case "LCIT":
			Common.jsClick(driver, selectLCIT);
			break;
		case "Global":
			Common.jsClick(driver, noSiteSelection);
			break;
		default:
			Common.jsClick(driver, noSiteSelection);

		}

		return new LoginVerification(driver);
	}

	public LoginVerification openURL() {

		logstep = 1;

		try {
			if (lblTestVersion.isDisplayed()) {
				log("--- <strong> Site/Build Version being Test : " + lblTestVersion.getText() + "</strong> ---");
				log("Step " + (logstep++) + ": Open url: <a href='" + testUrl + "'>" + testUrl + "</a>");
			} else {

			}
		} catch (Exception e) {
			log("--- <strong> Site/Build Version being Test : None Detected </strong> ---");
			log("Step " + (logstep++) + ": Open url: <a href='" + testUrl + "'>" + testUrl + "</a>");
		}

		return new LoginVerification(driver);

	}

	public LoginVerification logout() {

		log("Step " + (logstep++) + ": Click on '" + SeleniumInit.userName + "' drop down.");
		Common.jsClick(driver, userAccount_drpdwn);

		Common.pause(1);

		log("Step " + (logstep++) + ": Click on 'Logout' button.");
		Common.jsClick(driver, btn_logout);

		Common.pause(2);

		return new LoginVerification(driver);
	}

}