package com.cfs.verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cfs.indexpages.ServiceRequestIndexpage;
import com.cfs.init.AbstractPage;
import com.cfs.init.Common;

public class ServiceRequestVerification extends AbstractPage {

	public ServiceRequestVerification(WebDriver driver) {
		super(driver);
	}

	/* -------------------- Declarations -------------------- */

	public static String ssrNumber;

	WebElement lblssrNumber;

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//aside[2]/div/div[1]/div[2]")
	private WebElement lblServiceRequest;

	@FindBy(xpath = ".//div//div/input[@name='customerCode']")
	private WebElement txtCustomerCode;

	@FindBy(xpath = ".//div//div//button[@data-id='requestByCode']")
	private WebElement drpdwnDocumentType;

	@FindBy(xpath = ".//div//div//button[@data-id='vesselVisitCode']")
	private WebElement drpdwnVeeselVisitCode;

	@FindBy(xpath = ".//*[@name='requestTime']")
	private WebElement txtRequestDate;

	@FindBy(xpath = ".//div//div/input[@name='notificationEmail']")
	private WebElement txtEmailNotification;

	@FindBy(xpath = ".//div//div[@data-name='devanningLocation']")
	private WebElement chkGroupTargetLocation;

	@FindBy(xpath = ".//aside/div/div[2]/div[1]/div/div[2]/p[@class='alert-msg']")
	private WebElement lblInvalidBOLVerification;

	@FindBy(xpath = ".//section/aside[2]//p[contains(text(),'successfully')]")
	private WebElement lblSuccessServiceCreate;

	/* -------------------- Verification methods -------------------- */

	public boolean serviceRequestScreenVerification() throws InterruptedException {

		Common.waitForElementIsDisplayed(lblServiceRequest);

		return lblServiceRequest.getText().contains("Service Request");
	}

	public boolean createRequestVerification() throws InterruptedException {

		Common.waitForElementIsDisplayed(lblServiceRequest);

		return lblServiceRequest.getText().contains("Create Request");
	}

	public boolean devanningFieldsVerification() {

		Boolean bool = txtCustomerCode.isDisplayed() && drpdwnDocumentType.isDisplayed()
				&& drpdwnVeeselVisitCode.isDisplayed() && txtRequestDate.isDisplayed()
				&& txtEmailNotification.isDisplayed() && chkGroupTargetLocation.isDisplayed();

		return bool;
	}

	public boolean vesselVisitListVerification() throws InterruptedException {

		Common.pause(30);

		List<WebElement> lstElement = driver
				.findElements(By.xpath(".//section[2]//div[contains(@class,'group-row')]/div[1]"));

		Common.waitForElementIsDisplayed(lstElement.get(0));

		return lstElement.get(0).isDisplayed() && lstElement.get(1).isDisplayed() && lstElement.get(2).isDisplayed()
				&& lstElement.get(3).isDisplayed();
	}

	public boolean invalidBOLVerification() {

		log("Verification Message display for invalid BOL Number : <Strong><font color=#ff0000>"
				+ lblInvalidBOLVerification.getText() + "</strong></font>");

		return lblInvalidBOLVerification.isDisplayed();
	}

	public boolean additionalServiceVerification() {

		Boolean bool = false;

		List<WebElement> lstServices = driver
				.findElements(By.xpath(".//table[contains(@class,'ssr-additional-services')]/tbody/tr"));

		if (lstServices.size() > 0) {
			bool = true;
		} else {
			bool = false;
		}

		return bool;
	}

	public boolean requestCreatedverification() {

		for (int i = 1; i <= 60; i++) {
			Common.pause(1);
			System.err.println(i);
		}

		try {
			Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//form//div//label[@for='ssrNbr']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String ssrStatus = driver.findElement(By.xpath(".//form//div//label[@for='ssrStatus']")).getText();

		ssrNumber = driver.findElement(By.xpath(".//form//div//label[@for='ssrNbr']")).getText();

		/*
		 * log("Success Message : <Strong><font color=#008000>" +
		 * lblSuccessServiceCreate.getText() + "</strong></font>");
		 * 
		 * ssrNumber = lblSuccessServiceCreate.getText().substring(19, 34);
		 */
		log("<strong>Request Number : </strong><font color=#9400D3>" + ssrNumber + "</font>");
		log("<strong>Request Status : </strong><font color=#9400D3>" + ssrStatus + "</font>");

		return ssrStatus.contains("CREATED");

	}

	public Boolean requestCreateEmailVerification() {

		Boolean bool = false;

		if (!(ssrNumber.isEmpty())) {

			try {
				Common.openMailinator(driver, ServiceRequestIndexpage.customerMailAdd);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (browserName.contains("ie")) {

				driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");

			}

			bool = checkMailinMailinator();

		} else {
			bool = false;
		}

		Common.pause(2);

		cleanResources();

		Common.pause(2);

		return bool;
	}

	private boolean checkMailinMailinator() {

		Common.pause(15);

		List<WebElement> listOfSubjects = driver.findElements(By.xpath(".//div[2]/div[5]/div"));

		if (listOfSubjects.isEmpty()) {

			System.err.println("empty");

			Common.pause(10);

			try {
				driver.navigate().refresh();

				Common.pause(10);

				driver.navigate().refresh();

				WebElement lblSubject;

				try {
					lblSubject = listOfSubjects.get(0);
				} catch (Exception e) {
					return false;
				}

				String subjectLine = lblSubject.getText();

				if (subjectLine.contains(ssrNumber)) {

					Common.clickOn(driver, lblSubject);

					log("<strong>Mail Subject : </strong>" + subjectLine);

				}

				return true;
			} catch (Exception e) {

				return false;
			}

		} else {

			WebElement lblSubject = listOfSubjects.get(0);

			String subjectLine = lblSubject.getText();

			if (subjectLine.contains(ssrNumber)) {

				Common.clickOn(driver, lblSubject);

				log("<strong>Mail Subject : </strong>" + subjectLine);

			} else {

			}

			return true;
		}

	}

	public boolean createdRequestVerification() throws InterruptedException {

		for (int i = 1; i <= 60; i++) {
			Common.pause(1);
			System.err.println(i);
		}

		Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//form//div//label[@for='ssrNbr']")));

		WebElement remarks = driver.findElement(By.xpath(".//form//div//label[@for='remarks']"));
		List<WebElement> containerNo = driver.findElements(By.xpath(".//div[@id='CONTAINER']//table//tbody/tr"));

		Common.pause(3);

		if (containerNo.size() == 0) {

			for (int i = 1; i <= 30; i++) {
				Common.pause(1);
				System.err.println(i);
			}

		} else {
			for (int i = 0; i < containerNo.size(); i++) {

				Common.pause(5);
				System.err.println(i);

			}

		}

		WebElement rqstNr = driver.findElement(By.xpath(".//form//div//label[@for='requestByNbr']"));

		Common.waitForElementIsDisplayed(containerNo.get(0));

		System.err.println(containerNo.get(0).getText());

		return remarks.isDisplayed() && containerNo.get(0).isDisplayed() && rqstNr.isDisplayed();

	}

	public boolean requestPlannedVerification() {

		log("Success Message : <Strong><font color=#008000>" + lblSuccessServiceCreate.getText() + "</strong></font>");

		ssrNumber = lblSuccessServiceCreate.getText().substring(11, 27);

		log("<strong>Planned Request Number : </strong><font color=#9400D3>" + ssrNumber + "</font>");

		return lblSuccessServiceCreate.isDisplayed();
	}

	public boolean requestPlanEmailVerification() {

		Boolean bool = false;

		if (!(ssrNumber.isEmpty())) {

			try {
				Common.openMailinator(driver, ServiceRequestIndexpage.customerMailAdd);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (browserName.contains("ie")) {

				driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");

			}

			bool = checkMailinMailinator();

		} else {
			bool = false;
		}

		Common.pause(2);

		cleanResources();

		Common.pause(2);

		return bool;

	}

	public boolean plannedRequestVerification() throws InterruptedException {

		for (int i = 1; i <= 60; i++) {
			Common.pause(1);
			System.err.println(i);
		}

		Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//form//div//label[@for='ssrNbr']")));

		WebElement remarks = driver.findElement(By.xpath(".//form//div//label[@for='remarks']"));
		List<WebElement> containerNo = driver.findElements(By.xpath(".//div[@id='CONTAINER']//table//tbody/tr"));

		if (containerNo.size() == 0) {

			for (int i = 1; i <= 30; i++) {
				Common.pause(1);
				System.err.println(i);
			}

		} else {
			for (int i = 0; i < containerNo.size(); i++) {

				Common.pause(5);
				System.err.println(i);

			}

		}

		WebElement rqstNr = driver.findElement(By.xpath(".//form//div//label[@for='requestByNbr']"));

		Common.waitForElementIsDisplayed(containerNo.get(0));

		System.err.println(containerNo.get(0).getText());

		return remarks.isDisplayed() && containerNo.get(0).isDisplayed() && rqstNr.isDisplayed();
	}

	public boolean requestApprovedVerification() {

		log("Success Message : <Strong><font color=#008000>" + lblSuccessServiceCreate.getText() + "</strong></font>");

		ssrNumber = lblSuccessServiceCreate.getText().substring(11, 27);

		log("<strong>Approved Request Number : </strong><font color=#9400D3>" + ssrNumber + "</font>");

		return lblSuccessServiceCreate.isDisplayed();
	}

	public boolean requestApprovedEmailVerification() {

		Boolean bool = false;

		if (!(ssrNumber.isEmpty())) {

			try {
				Common.openMailinator(driver, ServiceRequestIndexpage.customerMailAdd);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (browserName.contains("ie")) {

				driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");

			}

			bool = checkMailinMailinator();

		} else {
			bool = false;
		}

		Common.pause(2);

		cleanResources();

		Common.pause(2);

		return bool;
	}

	public boolean completedRequestVerification() {

		for (int i = 1; i <= 60; i++) {
			Common.pause(1);
			System.err.println(i);
		}

		try {
			Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//form//div//label[@for='ssrNbr']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement remarks = driver.findElement(By.xpath(".//form//div//label[@for='remarks']"));
		List<WebElement> containerNo = driver.findElements(By.xpath(".//div[@id='CONTAINER']//table//tbody/tr"));

		if (containerNo.size() == 0) {

			for (int i = 1; i <= 30; i++) {
				Common.pause(1);
				System.err.println(i);
			}

		} else {
			for (int i = 0; i < containerNo.size(); i++) {

				Common.pause(5);
				System.err.println(i);

			}

		}

		WebElement rqstNr = driver.findElement(By.xpath(".//form//div//label[@for='requestByNbr']"));

		try {
			Common.waitForElementIsDisplayed(containerNo.get(0));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println(containerNo.get(0).getText());

		return remarks.isDisplayed() && containerNo.get(0).isDisplayed() && rqstNr.isDisplayed();
	}

	/* -------------------- MISC methods -------------------- */

	private void cleanResources() {

		System.err.println("herre");

		Common.refresh(driver);

		Common.pause(2);

		List<WebElement> listOfSubjects = driver.findElements(By.xpath(".//div[2]/div[5]/div"));

		System.err.println("labels found");

		List<WebElement> listOfCheckBox = driver.findElements(By.xpath(".//div[1]/input[@type='checkbox']/../label"));

		WebElement lblSubject = listOfSubjects.get(0);

		String subjectLine = lblSubject.getText();

		if (subjectLine.contains(ssrNumber)) {

			for (WebElement chkbx : listOfCheckBox) {
				Common.clickOn(driver, chkbx);
				Common.pause(1);

			}

			WebElement mailinatorDeleteMail = driver.findElement(By.xpath(".//*[@id='public_delete_button']"));

			Common.clickOn(driver, mailinatorDeleteMail);

			Common.pause(2);

		}

	}

}