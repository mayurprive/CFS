package com.cfs.indexpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cfs.init.AbstractPage;
import com.cfs.init.CFSCommon;
import com.cfs.init.Common;
import com.cfs.init.PropertyLoader;
import com.cfs.verification.JobVerification;
import com.cfs.verification.ServiceRequestVerification;

public class JobIndexpage extends AbstractPage {

	public JobIndexpage(WebDriver driver) {
		super(driver);
	}

	/* -------------------- Declarations -------------------- */

	static PropertyLoader prop = new PropertyLoader();

	String ssrNr = (String) prop.getValue("ssrNumber");
	String locationName = (String) prop.getValue("locationName");
	String resourceName = (String) prop.getValue("resourceName");

	static String seal1, seal2, seal3, seal4, quantity, weight, volume, marksAndLabel, addedLocation, plannedJobEndTime,
			actualJobEndTime;

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//aside[2]//a[contains(@href,'jobs')]")
	private WebElement selectJobScreen;

	@FindBy(xpath = ".//*[@id='filter_form']/div[3]/div/button[@type='submit']")
	private WebElement btnFilter;

	@FindBy(xpath = ".//*[@id='filter_form']/div[3]/div/button[@type='reset']")
	private WebElement btnResetFilter;

	@FindBy(xpath = ".//*[@id='filter_form']//div/div/button[@title='Select Field']")
	private WebElement addFileldFilter;

	@FindBy(xpath = ".//*[@id='filter_form']//div[@class='switch']/label[contains(text(),'ON')]")
	private WebElement switchON;

	@FindBy(xpath = ".//*[@id='filter_form']//div[@class='switch']/label[contains(text(),'OFF')]")
	private WebElement switchOFF;

	@FindBy(xpath = ".//section//div[contains(@class,'accordion')]//h3[contains(text(),'Filter')]")
	private WebElement filterAccordion;

	@FindBy(xpath = ".//*[@id='filter_form']//div/div/..//li/a/span[contains(text(),'SSR Number')]")
	private WebElement selectSSRNumber;

	@FindBy(xpath = ".//*[@id='filter_form']/div[1]/div/div[3]/div/div/input[@name='SSR_NBR']")
	private WebElement txtSSRName;

	@FindBy(xpath = ".//form//div//label[@for='jobNbr']")
	private WebElement lblJobNumber;

	@FindBy(xpath = ".//form//div//label[@for='jobStatus']")
	private WebElement lblJobStatus;

	@FindBy(xpath = ".//div[contains(@class,'panel-block-actions')]//a[1]")
	private WebElement btnList;

	@FindBy(xpath = ".//div[@id='JOB-TIMING-DOCKING-BAY']//a[contains(@title,'Edit Job timing')]")
	private WebElement btnEditJobTiming;

	@FindBy(xpath = ".//*[@name='plannedStartTime']")
	private WebElement txtEstStartTime;

	@FindBy(xpath = ".//*[@name='plannedEndTime']")
	private WebElement txtEstEndTime;

	@FindBy(xpath = ".//div[@id='JOB-TIMING-DOCKING-BAY']//section//button[@data-id='dockingSlotKey']")
	private WebElement drpdwnDockingBay;

	@FindBy(xpath = ".//button[@name='btnSubmit']")
	private WebElement btnSave;

	@FindBy(xpath = ".//form//div//label[@for='dockingSlot']")
	private WebElement lblDockingBay;

	@FindBy(xpath = ".//section//div[contains(@class,'accordion')]//h3[text()='Location']")
	private WebElement locationAccordion;

	@FindBy(xpath = ".//section//div[contains(@class,'accordion')]//h3[text()='Resources']")
	private WebElement resourceAccordion;

	@FindBy(xpath = ".//*[@id='LOCATION']//section//a[@title='Add']")
	private WebElement btnAddLocation;

	@FindBy(xpath = ".//input[@name='locationName']")
	private WebElement txtLocationName;

	@FindBy(xpath = ".//section//button[@data-id='bol']")
	private WebElement drpdwnBOL;

	@FindBy(xpath = ".//section//button[@data-id='locationType']")
	private WebElement drpdwnLocation;

	@FindBy(xpath = ".//form[contains(@name,'addLocation')]//button[@name='btnSubmit']")
	private WebElement btnSaveLocation;

	@FindBy(xpath = ".//form[contains(@name,'addResource')]//button[@name='btnSubmit']")
	private WebElement btnSaveResource;

	@FindBy(xpath = ".//*[@id='RESOURCES']//section//a[@title='Add']")
	private WebElement btnAddResource;

	@FindBy(xpath = ".//input[@name='resourceName']")
	private WebElement txtResource;

	@FindBy(xpath = ".//input[@name='qty']")
	private WebElement txtResourceQuantity;

	@FindBy(xpath = ".//div[contains(@class,'panel-block-actions')]//a[2]")
	private WebElement btnAllAction;

	@FindBy(xpath = ".//*[@id='action_popup']//a//span[contains(text(),'Confirm')]")
	private WebElement btnConfirmJob;

	@FindBy(xpath = ".//*[@id='conf-editWarning']//div[@class='alert-btn-popup']")
	private WebElement lblEditRequestWarning;

	@FindBy(xpath = ".//*[@id='yes']")
	private WebElement btnYes;

	@FindBy(xpath = ".//*[@id='no']")
	private WebElement btnNo;

	@FindBy(xpath = ".//*[@id='ok']")
	private WebElement btnOk;

	@FindBy(xpath = ".//*[@id='conf-editWarning']//div[@class='message-desc']")
	private WebElement lblWarningMsg;

	@FindBy(xpath = ".//*[@id='LOCATION']//div[@data-griddispkey='CFS-JOB-LOCATION']//a[contains(text(),'Remove')]")
	private WebElement btnDeleteLocation;

	@FindBy(xpath = ".//*[@id='RESOURCES']//div[@data-griddispkey='CFS-JOB-RESOURCE']//a[contains(text(),'Remove')]")
	private WebElement btnDeleteResource;

	@FindBy(xpath = ".//*[@id='filter_form']//select[@name='STATUS']/option[@value='CREATED']")
	private WebElement btnCreatedStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//select[@name='STATUS']/option[@value='READY_FOR_OPERATION']")
	private WebElement btnReadyOpStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//select[@name='STATUS']/option[@value='IN_PROGRESS']")
	private WebElement btnInProgressStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//div/div/..//li/a/span[contains(text(),'Status')]")
	private WebElement selectStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//div//button[@data-id='STATUS']")
	private WebElement btnSelectStatus;

	@FindBy(xpath = ".//input[@name='plannedStartTime']")
	private WebElement lblPlannedJobTime;

	@FindBy(xpath = ".//input[@name='actualStartTime']")
	private WebElement lblActualJobTime;

	@FindBy(xpath = ".//button[@name='btnNext']")
	private WebElement btnNext;

	@FindBy(xpath = ".//input[@name='seal1']")
	private WebElement txtSealOne;

	@FindBy(xpath = ".//input[@name='seal2']")
	private WebElement txtSealTwo;

	@FindBy(xpath = ".//input[@name='seal3']")
	private WebElement txtSealThree;

	@FindBy(xpath = ".//input[@name='seal4']")
	private WebElement txtSealFour;

	@FindBy(xpath = ".//*[@id='alert-exceptions']//div[@class='alert-btn-popup']")
	private WebElement lblErrorMessage;

	@FindBy(xpath = ".//*[@id='accordion-devanDetails']")
	private WebElement lblDevanScreen;

	@FindBy(xpath = ".//*[@id='accordion-devanDeclaredQuantity']//section//input[@name='quantity']")
	private WebElement lblQuantity;

	@FindBy(xpath = ".//*[@id='accordion-devanDeclaredQuantity']//section//input[@name='weight']")
	private WebElement lblWeight;

	@FindBy(xpath = ".//*[@id='accordion-devanDeclaredQuantity']//section//input[@name='volume']")
	private WebElement lblVolume;

	@FindBy(xpath = ".//*[@id='accordion-devanDeclaredQuantity']//section//input[@name='marksAndLabel']")
	private WebElement lblMarksAndLabel;

	@FindBy(xpath = ".//section//a[@data-accordionkey='devanReceivedQuantity']")
	private WebElement btnAddReceivedQuantity;

	@FindBy(xpath = ".//form[contains(@name,'createDevanRecordDetails')]//input[@name='quantity']")
	private WebElement txtPlannedQuantity;

	@FindBy(xpath = ".//form[contains(@name,'createDevanRecordDetails')]//input[@name='weight']")
	private WebElement txtPlannedWeight;

	@FindBy(xpath = ".//form[contains(@name,'createDevanRecordDetails')]//input[@name='volume']")
	private WebElement txtPlannedVolume;

	@FindBy(xpath = ".//input[@name='plannedEndTime']")
	private WebElement lblPlannedEndTime;

	@FindBy(xpath = ".//input[@name='actualEndTime']")
	private WebElement lblActualEndTime;

	/* -------------------- Indexpages Methods -------------------- */

	public JobVerification openJobScreen() {

		log("Step " + (LoginIndexpage.logstep++) + ": Open 'Job' screen.");

		Common.pause(2);

		Common.clickOn(driver, selectJobScreen);

		return new JobVerification(driver);
	}

	public JobVerification filterSSRNumber() {

		try {
			driver.findElement(By.xpath(".//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openFilterAccordion();

		}

		if (!btnFilter.isDisplayed()) {

			openFilterScreen();

			clickOnResetButton();

		}

		log("Step " + (LoginIndexpage.logstep++)
				+ ": Select SSR Number from dropdown and filter with entered SSR number : <font color=#9400D3>"
				+ ServiceRequestVerification.ssrNumber + "</font>");

		Common.jsClick(driver, addFileldFilter);

		Common.jsClick(driver, selectSSRNumber);

		try {
			if (ServiceRequestVerification.ssrNumber != null && !ServiceRequestVerification.ssrNumber.isEmpty()) {

				Common.type(txtSSRName, ServiceRequestVerification.ssrNumber);

			} else {

				Common.type(txtSSRName, ssrNr);

			}
		} catch (Exception e) {
			log("SSR Number Error!");
			e.printStackTrace();
		}

		Common.jsClick(driver, switchON);

		Common.jsClick(driver, addFileldFilter);

		Common.jsClick(driver, selectStatus);

		Common.clickOn(driver, btnSelectStatus);

		Common.clickOn(driver, btnCreatedStatus);

		Common.jsClick(driver, switchON);

		Common.jsClick(driver, btnFilter);

		Common.pause(3);

		return new JobVerification(driver);
	}

	public JobVerification filterSSRNumberwithOpr() {

		try {
			driver.findElement(By.xpath(".//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openFilterAccordion();

		}

		if (!btnFilter.isDisplayed()) {

			openFilterScreen();

			clickOnResetButton();

		}

		log("Step " + (LoginIndexpage.logstep++)
				+ ": Select SSR Number from dropdown and filter with entered SSR number : <font color=#9400D3>"
				+ ServiceRequestVerification.ssrNumber + "</font>");

		Common.jsClick(driver, addFileldFilter);

		Common.jsClick(driver, selectSSRNumber);

		try {
			if (ServiceRequestVerification.ssrNumber != null && !ServiceRequestVerification.ssrNumber.isEmpty()) {

				Common.type(txtSSRName, ServiceRequestVerification.ssrNumber);

			} else {

				Common.type(txtSSRName, ssrNr);

			}
		} catch (Exception e) {
			log("SSR Number Error!");
			e.printStackTrace();
		}

		Common.jsClick(driver, switchON);

		Common.jsClick(driver, addFileldFilter);

		Common.jsClick(driver, selectStatus);

		Common.clickOn(driver, btnSelectStatus);

		Common.clickOn(driver, btnReadyOpStatus);

		Common.jsClick(driver, switchON);

		Common.jsClick(driver, btnFilter);

		Common.pause(3);

		return new JobVerification(driver);
	}

	private void openFilterAccordion() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Filter' accordion.");

		Common.clickOn(driver, filterAccordion);

		Common.pause(1);
	}

	public void openFilterScreen() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Filter' button.");

		// Common.clickOn(driver, btn_selectFilter);

		Common.pause(3);

	}

	private void clickOnResetButton() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Reset' button. ");

		Common.jsClick(driver, btnResetFilter);
		Common.jsClick(driver, btnResetFilter);
	}

	public JobVerification selectAndViewJob(int i) {

		Common.pause(3);

		WebElement ele = driver.findElement(By.xpath(".//table/tbody/tr[" + i + "]/td[1]//label"));

		log("Step " + (LoginIndexpage.logstep++) + ": Select one of the job from the table and view.");

		Common.clickOn(driver, ele);

		Common.pause(1);

		WebElement btnViewIcon = driver.findElement(By.xpath(".//table/tbody/tr[" + i + "]/td[@class='view-icon']"));

		Common.clickOn(driver, btnViewIcon);

		Common.pause(10);

		return new JobVerification(driver);
	}

	public void restartThePage() {

		Common.pause(2);

		btnOk.click();

		Common.pause(3);

		openJobScreen();

		Common.pause(10);

		filterSSRNumber();

	}

	public JobVerification createdJobData() {

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Details of opened job. </strong>");

		log("Job Number : <font color=#9400D3>" + lblJobNumber.getText() + "</font>");

		log("Job Status : <font color=#9400D3>" + lblJobStatus.getText() + "</font>");

		Common.pause(5);

		return new JobVerification(driver);
	}

	private void clickOnListButton() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on List button from top right corner.");

		Common.clickOn(driver, btnList);

	}

	private void clickOnNextButton() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Next button.");

		Common.clickOn(driver, btnNext);

	}

	public JobVerification editJobTimingsandDockingBay() {

		clickOnEditJobTimings();

		Common.pause(3);

		try {

			Common.waitForElementIsDisplayed(txtEstStartTime);

			enterDockingStartDate();

			enterDockingEndDate();

			selectDockingBay();

			clickOnSaveButton();

			Common.pause(3);

			System.err.println("after save");

			try {

				if (lblEditRequestWarning.isDisplayed()) {

					log("Warning message display.");

					clickOnYes();
				}
			} catch (Exception e) {
				System.err.println("catch");
			}

			System.err.println("left try catch");

			Common.pause(5);

			System.err.println("waiting");
			Common.waitForElementIsDisplayed(lblDockingBay);

			System.err.println("found");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new JobVerification(driver);

	}

	private void clickOnSaveButton() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Save button.");

		Common.clickOn(driver, btnSave);

	}

	private void selectDockingBay() {

		Common.clickOn(driver, driver.findElement(By.xpath(".//*[@id='SHUTTLING']/div/section")));

		Common.pause(1);

		Common.clickOn(driver, drpdwnDockingBay);

		Common.pause(1);

		List<WebElement> lstDockbay = driver.findElements(By.xpath(".//form//select[@id='dockingSlotKey']//option"));

		System.err.println(lstDockbay.size());

		if (lstDockbay.size() > 2) {

			int index = CFSCommon.getRandomNumber(3, lstDockbay.size() - 1);
			System.err.println(index);

			WebElement ele = driver.findElement(By.xpath(".//body/div//ul[@role='menu']/li[" + index + "]/a/span[1]"));

			log("Step " + (LoginIndexpage.logstep++) + ": Click and Select Docking Bay : <font color=#9400D3>"
					+ ele.getText() + "</font>");

			ele.click();

		} else {

		}

	}

	private void enterDockingStartDate() {

		Common.clickOn(driver, txtEstStartTime);

		Common.pause(1);

		String estStartDate = CFSCommon.getRandomFutureDate(3);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Estimated Start Date/Time in field : <font color=#9400D3>"
				+ estStartDate + "</font>");

		Common.type(txtEstStartTime, estStartDate);

	}

	private void enterDockingEndDate() {

		Common.clickOn(driver, txtEstStartTime);

		Common.pause(1);

		String estEndDate = CFSCommon.getRandomFutureDate(5);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Estimated End Date/Time in field : <font color=#9400D3>"
				+ estEndDate + "</font>");

		Common.type(txtEstEndTime, estEndDate);

	}

	private void clickOnEditJobTimings() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Edit button from Job Timings/Docking Bay accordion.");

		Common.clickOn(driver, btnEditJobTiming);

	}

	public JobVerification addLocationsAndResources() {

		try {
			driver.findElement(By.xpath(".//div[@data-accordionkey='LOCATION']//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openLocationAccordion();

		}

		addLocation();

		Common.pause(5);

		try {
			driver.findElement(By.xpath(".//div[@data-accordionkey='RESOURCES']//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openResourceAccordion();

		}

		addResource();

		return new JobVerification(driver);

	}

	private void addResource() {

		checkExistsResource();

		Common.pause(2);

		Common.clickOn(driver, btnAddResource);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Add' button.");

		Common.pause(5);

		try {
			Common.waitForElementIsDisplayed(txtResource);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Common.type(txtResource, resourceName);

		Common.pause(5);

		List<WebElement> lstResourceList = driver.findElements(By.xpath(".//ul[@data-element-auto='resourceName']/li"));

		int num = CFSCommon.getRandomNumber(0, lstResourceList.size() - 1);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Resource Name : <font color=#9400D3>"
				+ lstResourceList.get(num).getText() + "</font>");

		Common.clickOn(driver, lstResourceList.get(num));

		Common.pause(2);

		Common.clickOn(driver, btnSaveResource);

		Common.pause(5);

		try {

			if (lblEditRequestWarning.isDisplayed()) {

				log("Warning message display.");

				clickOnYes();
			}
		} catch (Exception e) {

		}

		Common.pause(5);

	}

	private void openResourceAccordion() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Resource' accordion.");

		Common.clickOn(driver, resourceAccordion);

		Common.pause(1);

	}

	private void addLocation() {

		checkExistsLocation();

		Common.pause(2);

		Common.clickOn(driver, btnAddLocation);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Add' button.");

		Common.pause(5);

		try {
			Common.waitForElementIsDisplayed(txtLocationName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Common.clickOn(driver, drpdwnBOL);

		Common.pause(1);

		List<WebElement> lstBOL = driver.findElements(By.xpath(".//body/div//ul[@role='menu']/li/a/span[1]"));

		System.err.println(lstBOL.size());

		if (lstBOL.size() > 0) {

			int index = CFSCommon.getRandomNumber(2, lstBOL.size());
			System.err.println(index);

			WebElement ele = driver.findElement(By.xpath(".//body/div//ul[@role='menu']/li[" + index + "]/a/span[1]"));

			log("Step " + (LoginIndexpage.logstep++) + ": Click and Select BOL : <font color=#9400D3>" + ele.getText()
					+ "</font>");

			ele.click();

		} else {

		}

		Common.pause(2);

		Common.clickOn(driver, drpdwnLocation);

		Common.pause(1);

		List<WebElement> lstLocation = driver.findElements(By.xpath(".//body/div//ul[@role='menu']/li/a/span[1]"));

		System.err.println(lstLocation.size());

		if (lstLocation.size() > 0) {

			int index = CFSCommon.getRandomNumber(2, lstLocation.size());
			System.err.println(index);

			WebElement ele = driver.findElement(By.xpath(".//body/div//ul[@role='menu']/li[" + index + "]/a/span[1]"));

			log("Step " + (LoginIndexpage.logstep++) + ": Click and Select Location Type : <font color=#9400D3>"
					+ ele.getText() + "</font>");

			ele.click();

		} else {

		}

		Common.pause(1);

		Common.type(txtLocationName, locationName);

		Common.pause(5);

		List<WebElement> lstLocationList = driver.findElements(By.xpath(".//ul[@data-element-auto='locationName']/li"));

		int num = CFSCommon.getRandomNumber(0, lstLocationList.size() - 1);

		addedLocation = lstLocationList.get(num).getAttribute("data-value");

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Location Name : <font color=#9400D3>" + addedLocation
				+ "</font>");

		Common.clickOn(driver, lstLocationList.get(num));

		Common.pause(2);

		Common.clickOn(driver, btnSaveLocation);

		Common.pause(5);

	}

	private void checkExistsLocation() {

		List<WebElement> lstLocations = driver
				.findElements(By.xpath(".//div[@id='LOCATION']//table/tbody/tr/td[1]//label"));

		if (lstLocations.size() > 0) {

			for (WebElement e : lstLocations) {

				Common.checkChkBox(e);

				Common.pause(1);

			}

			Common.clickOn(driver, btnDeleteLocation);

			Common.pause(3);

			List<WebElement> lstYes = driver.findElements(By.xpath(".//*[@id='yes']"));

			for (WebElement e : lstYes) {

				if (e.isDisplayed()) {
					Common.clickOn(driver, e);

					Common.pause(2);
				}

			}

			Common.pause(10);

		}

	}

	private void checkExistsResource() {

		List<WebElement> lstResources = driver
				.findElements(By.xpath(".//div[@id='RESOURCES']//table/tbody/tr/td[1]//label"));

		if (lstResources.size() > 0) {

			for (WebElement e : lstResources) {

				Common.checkChkBox(e);

				Common.pause(1);

			}

			Common.clickOn(driver, btnDeleteResource);

			Common.pause(3);

			List<WebElement> lstYes = driver.findElements(By.xpath(".//*[@id='yes']"));

			for (WebElement e : lstYes) {

				if (e.isDisplayed()) {
					Common.clickOn(driver, e);

					Common.pause(2);
				}

			}

			Common.pause(10);

		}

	}

	private void openLocationAccordion() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Location' accordion.");

		Common.clickOn(driver, locationAccordion);

		Common.pause(1);

	}

	public JobVerification confirmPlannedJob() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on All action icon from the top right corner. ");

		Common.clickOn(driver, btnAllAction);

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Confirm' from the menu. ");

		Common.clickOn(driver, btnConfirmJob);

		return new JobVerification(driver);

	}

	private void clickOnYes() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Yes button.");

		List<WebElement> lstYes = driver.findElements(By.xpath(".//*[@id='yes']"));

		for (WebElement e : lstYes) {

			if (e.isDisplayed()) {
				Common.clickOn(driver, e);

				Common.pause(2);
			}

		}

	}

	public JobVerification goToList() {

		try {
			if (btnList.isDisplayed()) {
				System.err.println("button found");
				clickOnListButton();
			} else {

				System.err.println("no button");
			}
		} catch (Exception e) {

		}

		return new JobVerification(driver);

	}

	public JobVerification viewStartJobTiming() {

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Details of start job. </strong>");

		log("Planned Start Date/Time : <font color=#9400D3>" + lblPlannedJobTime.getAttribute("value") + "</font>");

		log("Actual Start Date/TIme : <font color=#9400D3>" + lblActualJobTime.getAttribute("value") + "</font>");

		Common.pause(5);

		clickOnNextButton();

		Common.pause(5);

		return new JobVerification(driver);

	}

	public JobVerification enterCutSealAndSave() {

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Enter seal details for Cut Seal. </strong>");

		seal1 = CFSCommon.getRandomNumber(100000, 999999) + "";
		seal2 = CFSCommon.getRandomNumber(100000, 999999) + "";
		seal3 = CFSCommon.getRandomNumber(100000, 999999) + "";
		seal4 = CFSCommon.getRandomNumber(100000, 999999) + "";

		log("Seal 1 : <font color=#9400D3>" + seal1 + "</font>");
		log("Seal 2 : <font color=#9400D3>" + seal2 + "</font>");
		log("Seal 3 : <font color=#9400D3>" + seal3 + "</font>");
		log("Seal 4 : <font color=#9400D3>" + seal4 + "</font>");

		Common.type(txtSealOne, seal1);
		Common.pause(1);

		Common.type(txtSealTwo, seal2);
		Common.pause(1);

		Common.type(txtSealThree, seal3);
		Common.pause(1);

		Common.type(txtSealFour, seal4);
		Common.pause(1);

		clickOnSaveButton();

		try {

			if (lblEditRequestWarning.isDisplayed()) {

				log("Warning message display.");

				clickOnYes();
			}
		} catch (Exception e) {

		}

		return new JobVerification(driver);
	}

	public JobVerification filterSSRNumberwithInProgress() {

		try {
			driver.findElement(By.xpath(".//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openFilterAccordion();

		}

		if (!btnFilter.isDisplayed()) {

			openFilterScreen();

			clickOnResetButton();

		}

		log("Step " + (LoginIndexpage.logstep++)
				+ ": Select SSR Number from dropdown and filter with entered SSR number : <font color=#9400D3>"
				+ ServiceRequestVerification.ssrNumber + "</font>");

		Common.jsClick(driver, addFileldFilter);

		Common.jsClick(driver, selectSSRNumber);

		try {
			if (ServiceRequestVerification.ssrNumber != null && !ServiceRequestVerification.ssrNumber.isEmpty()) {

				Common.type(txtSSRName, ServiceRequestVerification.ssrNumber);

			} else {

				Common.type(txtSSRName, ssrNr);

			}
		} catch (Exception e) {
			log("SSR Number Error!");
			e.printStackTrace();
		}

		Common.jsClick(driver, switchON);

		Common.jsClick(driver, addFileldFilter);

		Common.jsClick(driver, selectStatus);

		Common.clickOn(driver, btnSelectStatus);

		Common.clickOn(driver, btnInProgressStatus);

		Common.jsClick(driver, switchON);

		Common.jsClick(driver, btnFilter);

		Common.pause(3);

		return new JobVerification(driver);

	}

	public JobVerification goToDevanningSection() {

		clickOnNextButton();

		try {

			if (lblEditRequestWarning.isDisplayed()) {

				log("Warning message display.");

				clickOnYes();
			}
		} catch (Exception e) {
			System.err.println("catch");
		}

		Common.pause(30);

		try {
			Common.waitForElementIsDisplayed(lblDevanScreen);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new JobVerification(driver);
	}

	private void getDeclaredQuantity() {

		quantity = lblQuantity.getAttribute("value");
		weight = lblWeight.getAttribute("value");
		volume = lblVolume.getAttribute("value");
		marksAndLabel = lblMarksAndLabel.getAttribute("value");

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Declared Quantity </strong>");

		log("Quantity : <font color=#9400D3>" + quantity + "</font>");

		log("Weight : <font color=#9400D3>" + weight + "</font>");

		log("Volume : <font color=#9400D3>" + volume + "</font>");

		log("Marks & Label : <font color=#9400D3>" + marksAndLabel + "</font>");

	}

	public JobVerification enterDevanningDetail() {

		List<WebElement> lstBOLDetails = driver.findElements(By.xpath(".//select[@name='bol']/option"));

		System.err.println(lstBOLDetails.size());

		lstBOLDetails.remove(0);
		lstBOLDetails.remove(0);

		int num = CFSCommon.getRandomNumber(0, lstBOLDetails.size() - 1);

		log("Step " + (LoginIndexpage.logstep++) + ": Select BOL Number from dropdown : <font color=#9400D3>"
				+ lstBOLDetails.get(num).getAttribute("value") + "</font>");

		Common.clickOn(driver, lstBOLDetails.get(num));

		Common.pause(30);

		List<WebElement> lstCommodityDetails = driver.findElements(By.xpath(".//select[@name='commodity']/option"));

		System.err.println(lstCommodityDetails.size());

		lstCommodityDetails.remove(0);
		lstCommodityDetails.remove(0);

		int num1 = CFSCommon.getRandomNumber(0, lstCommodityDetails.size() - 1);

		log("Step " + (LoginIndexpage.logstep++) + ": Select Commodity : <font color=#9400D3>"
				+ lstCommodityDetails.get(num1).getText() + "</font>");

		Common.clickOn(driver, lstCommodityDetails.get(num1));

		Common.pause(5);

		getDeclaredQuantity();

		return new JobVerification(driver);
	}

	public JobVerification enterReceivedQuantity() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Add' button.");

		Common.clickOn(driver, btnAddReceivedQuantity);

		Common.pause(5);

		try {
			Common.waitForElementIsDisplayed(txtPlannedQuantity);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> lstLocations = driver.findElements(By.xpath(".//select[@name='plannedLocation']/option"));

		System.err.println(lstLocations.size());

		lstLocations.remove(0);
		lstLocations.remove(0);

		for (WebElement e : lstLocations) {

			System.err.println(e.getText());

			if (addedLocation == null) {

				WebElement other = driver
						.findElement(By.xpath(".//select[@name='plannedLocation']/option[@value='OTHERS']"));

				Common.clickOn(driver, other);

				Common.pause(3);

				WebElement txtLocName = driver.findElement(By.xpath(".//input[@name='otherLocationCode']"));

				Common.type(txtLocName, "QAW100");

			} else if (e.getText().contains(addedLocation)) {

				log("Step " + (LoginIndexpage.logstep++) + ": Select Location : <font color=#9400D3>" + e.getText()
						+ "</font>");
				Common.clickOn(driver, e);

				break;

			}

		}

		Common.pause(3);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Quantity : <font color=#9400D3>" + quantity + "</font>");
		Common.type(txtPlannedQuantity, quantity);

		Common.pause(10);

		List<WebElement> lstPackageType = driver.findElements(By.xpath(".//select[@name='packageType']/option"));

		System.err.println(lstPackageType.size());

		lstPackageType.remove(0);
		lstPackageType.remove(0);

		int num = CFSCommon.getRandomNumber(0, lstPackageType.size() - 1);

		log("Step " + (LoginIndexpage.logstep++) + ": Select Package Type : <font color=#9400D3>"
				+ lstPackageType.get(num).getAttribute("data-init-value") + "</font>");

		Common.clickOn(driver, lstPackageType.get(num));

		Common.pause(7);

		log("Step " + (LoginIndexpage.logstep++) + ": Entered Weight : <font color=#9400D3>"
				+ txtPlannedWeight.getAttribute("data-init-value") + "</font>");
		// Common.type(txtPlannedWeight, weight);

		Common.pause(5);

		log("Step " + (LoginIndexpage.logstep++) + ": Entered Volume : <font color=#9400D3>"
				+ txtPlannedVolume.getAttribute("data-init-value") + "</font>");
		// Common.type(txtPlannedVolume, volume);

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Save button.");

		WebElement btnSaveMove = driver.findElement(
				By.xpath(".//form[contains(@name,'createDevanRecordDetails')]//button[@name='btnSubmit']"));

		Common.clickOn(driver, btnSaveMove);

		Common.pause(30);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Next button.");

		WebElement btnNextMove = driver
				.findElement(By.xpath(".//form[@name='save-wizard']//button[@name='btnSubmit']"));

		Common.clickOn(driver, btnNextMove);

		return new JobVerification(driver);
	}

	public JobVerification enterApplySealAndSave() {

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Enter seal details for Apply Seal. </strong>");

		seal1 = CFSCommon.getRandomNumber(100000, 999999) + "";
		seal2 = CFSCommon.getRandomNumber(100000, 999999) + "";
		seal3 = CFSCommon.getRandomNumber(100000, 999999) + "";
		seal4 = CFSCommon.getRandomNumber(100000, 999999) + "";

		log("Seal 1 : <font color=#9400D3>" + seal1 + "</font>");
		log("Seal 2 : <font color=#9400D3>" + seal2 + "</font>");
		log("Seal 3 : <font color=#9400D3>" + seal3 + "</font>");
		log("Seal 4 : <font color=#9400D3>" + seal4 + "</font>");

		Common.type(txtSealOne, seal1);
		Common.pause(1);

		Common.type(txtSealTwo, seal2);
		Common.pause(1);

		Common.type(txtSealThree, seal3);
		Common.pause(1);

		Common.type(txtSealFour, seal4);
		Common.pause(1);

		clickOnSaveButton();

		try {

			if (lblEditRequestWarning.isDisplayed()) {

				log("Warning message display.");

				clickOnYes();
			}
		} catch (Exception e) {

		}

		clickOnNextButton();

		return new JobVerification(driver);
	}

	public JobVerification getJobDetails() {

		plannedJobEndTime = lblPlannedEndTime.getAttribute("value");
		actualJobEndTime = lblActualEndTime.getAttribute("value");

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Received Quantity </strong>");

		List<WebElement> lstReceivedQuantity = driver
				.findElements(By.xpath(".//div[@data-griddispkey='SUMMARY-DEVAN-GRID']//table/tbody//tr"));

		for (int i = 1; i <= lstReceivedQuantity.size(); i++) {

			List<WebElement> lstReceivedQuantityValue = driver.findElements(
					By.xpath(".//div[@data-griddispkey='SUMMARY-DEVAN-GRID']//table/tbody//tr[" + i + "]//td"));

			List<WebElement> lstReceivedQuantityHeader = driver.findElements(By.xpath(
					".//div[@data-griddispkey='SUMMARY-DEVAN-GRID']//table/thead//tr//th//span[@class='table-title']"));

			for (int j = 0; j < lstReceivedQuantityHeader.size(); j++) {

				log(lstReceivedQuantityHeader.get(j).getText() + " : <font color=#9400D3>"
						+ lstReceivedQuantityValue.get(j + 1).getText() + "</font>");

			}

		}

		return new JobVerification(driver);
	}

	public JobVerification completeJob() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Complete Job button.");

		Common.clickOn(driver, btnSave);

		return new JobVerification(driver);
	}
}
