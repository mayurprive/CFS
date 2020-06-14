package com.cfs.indexpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cfs.init.AbstractPage;
import com.cfs.init.Common;
import com.cfs.init.PropertyLoader;
import com.cfs.verification.GateVerification;

public class GateIndexpage extends AbstractPage {

	public GateIndexpage(WebDriver driver) {
		super(driver);
	}

	/* -------------------- Declarations -------------------- */

	static PropertyLoader prop = new PropertyLoader();

	String containerNr = (String) prop.getValue("containerNumber");

	public static List<WebElement> lstContainerName;

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//aside[2]//a[contains(@href,'gate')]")
	private WebElement selectGateScreen;

	@FindBy(xpath = ".//aside[2]//a[contains(@href,'container-arrival')]")
	private WebElement selectContainerArrival;

	@FindBy(xpath = ".//input[@name='containerNbr']")
	private WebElement txtContainerNr;

	@FindBy(xpath = ".//button[@name='btnSubmit']")
	private WebElement btnConfirm;

	/* -------------------- Indexpages Methods -------------------- */

	public GateVerification openGateScreen() {

		log("Step " + (LoginIndexpage.logstep++) + ": Open 'Gate' screen.");

		Common.clickOn(driver, selectGateScreen);

		return new GateVerification(driver);
	}

	public GateVerification openContainerArrivalScreen() {

		log("Step " + (LoginIndexpage.logstep++) + ": Open 'Container Arrival' screen.");

		Common.clickOn(driver, selectContainerArrival);

		return new GateVerification(driver);
	}

	public GateVerification enterAndConfirmContainerNumber() {

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Container Number in field : "
				+ ServiceRequestIndexpage.containerNr1);

		String containerNumber = ServiceRequestIndexpage.containerNr1;

		try {
			if (containerNumber != null && !containerNumber.isEmpty()) {

				Common.type(txtContainerNr, containerNumber);

			} else {

				Common.type(txtContainerNr, containerNr);

			}
		} catch (Exception e) {
			log("Container Number Error!");
			e.printStackTrace();
		}

		Common.pause(1);

		clickOnConfirmButton();

		return new GateVerification(driver);
	}

	private void clickOnConfirmButton() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Confirm button.");

		Common.clickOn(driver, btnConfirm);

	}

	/*
	 * public GateVerification findListOfJobs() {
	 * 
	 * jobIndexpage.openJobScreen();
	 * 
	 * Common.pause(2);
	 * 
	 * jobIndexpage.filterSSRNumber();
	 * 
	 * Common.pause(2);
	 * 
	 * lstContainerName =
	 * driver.findElements(By.xpath(".//table/tbody/tr/td[4]"));
	 * 
	 * }
	 */

}
