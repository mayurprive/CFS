package com.cfs.verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cfs.init.AbstractPage;
import com.cfs.init.Common;

public class GateVerification extends AbstractPage {

	public GateVerification(WebDriver driver) {
		super(driver);
	}

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//aside[2]/div/div[1]/div[2]")
	private WebElement lblContainerArrival;

	@FindBy(xpath = ".//section/aside[2]//p[@class='alert-msg']")
	private WebElement lblSuccessContainerArrival;

	/* -------------------- Verification methods -------------------- */

	public boolean containerArrivalScreenVerification() {

		try {
			Common.waitForElementIsDisplayed(lblContainerArrival);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return lblContainerArrival.getText().contains("Container Arrival");
	}

	public boolean successContainerArrivalVerification() {

		Boolean bool = false;

		if (lblSuccessContainerArrival.getText().contains("successfully")) {
			log("Message : <Strong><font color=#9400D3>" + lblSuccessContainerArrival.getText() + "</strong></font>");
			bool = true;
		} else {
			log("Message : <Strong><font color=#9400D3>" + lblSuccessContainerArrival.getText() + "</strong></font>");
			bool = false;
		}

		return bool;

	}
}
