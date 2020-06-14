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
import com.cfs.verification.ServiceRequestVerification;

public class ServiceRequestIndexpage extends AbstractPage {

	public ServiceRequestIndexpage(WebDriver driver) {
		super(driver);
	}

	/* -------------------- Declarations -------------------- */

	static PropertyLoader prop = new PropertyLoader();

	String bolNumber = (String) prop.getValue("BolNumber");
	String customerName = (String) prop.getValue("customerName");
	String ssrNr = (String) prop.getValue("ssrNumber");

	public static String customerMailAdd = (String) prop.getValue("emailAddress");
	public static String approvalRemarks = "This is auto generated remarks for Automation purpose.";
	public static String devanningRemarks = "This is auto generated devanning remarks for Automation purpose.";

	public static List<WebElement> lstContainerNr;
	public static List<String> lstNameContainer;

	public static String containerNr1;

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//aside[2]//a[contains(@href,'search-request')]")
	private WebElement selectSearchRequestScreen;

	@FindBy(xpath = ".//aside[2]/div/div[1]/div[3]/div/a[1]")
	private WebElement btnOpenCreateRequest;

	@FindBy(xpath = ".//div//div/button[@data-id='requestTypeCode']")
	private WebElement selectRequestType;

	@FindBy(xpath = ".//div//div//ul/li//span[contains(text(),'Devanning')]")
	private WebElement selectDevanning;

	@FindBy(xpath = ".//div//div//ul/li//span[contains(text(),'Delivery')]")
	private WebElement selectDelivery;

	@FindBy(xpath = ".//div//div/input[@name='customerCode']")
	private WebElement txtCustomerCode;

	@FindBy(xpath = ".//div//div//button[@data-id='invoiceOptionCode']")
	private WebElement lblInvoiceOption;

	@FindBy(xpath = ".//div//div//button[@data-id='requestByCode']")
	private WebElement drpdwnDocumentType;

	@FindBy(xpath = ".//div//div//button[@data-id='vesselVisitCode']")
	private WebElement drpdwnVesselVisitCode;

	@FindBy(xpath = ".//*[@name='requestTime']")
	private WebElement txtRequestDate;

	@FindBy(xpath = ".//div//div/input[@name='notificationEmail']")
	private WebElement txtEmailNotification;

	@FindBy(xpath = ".//*[@name='requestByNbr']")
	private WebElement txtRequestNumber;

	@FindBy(xpath = ".//button[@data-id='invoiceOptionCode']//span")
	private WebElement txtInvoiceOption;

	@FindBy(xpath = ".//select[@id='requestByCode']//option[@value='BOL']")
	private WebElement selectBOL;

	@FindBy(xpath = ".//body/div//ul/li/a/span[contains(text(),'Container')]")
	private WebElement selectContainer;

	@FindBy(xpath = ".//textarea[@name='remarks']")
	private WebElement txtRemarks;

	@FindBy(xpath = ".//textarea[@name='approverRemarks']")
	private WebElement txtDevanningRemarks;

	@FindBy(xpath = ".//div[contains(@class,'serviceDropdown')]//button")
	private WebElement drpdwnServiceName;

	@FindBy(xpath = ".//div[contains(@class,'uomDropdown')]//button")
	private WebElement drpdwnServiceUOM;

	@FindBy(xpath = ".//input[@name='quantity']")
	private WebElement txtSeviceQuantity;

	@FindBy(xpath = ".//a[contains(@class,'add-service')]")
	private WebElement btnAddService;

	@FindBy(xpath = ".//button[@name='btnSubmit']")
	private WebElement btnSave;

	@FindBy(xpath = ".//*[@id='conf-editWarning']//div[@class='alert-btn-popup']")
	private WebElement lblEditRequestWarning;

	@FindBy(xpath = ".//*[@id='yes']")
	private WebElement btnYes;

	@FindBy(xpath = ".//*[@id='no']")
	private WebElement btnNo;

	@FindBy(xpath = ".//*[@id='conf-editWarning']//div[@class='message-desc']")
	private WebElement lblWarningMsg;

	@FindBy(xpath = ".//*[@id='filter_form']//div/div/..//li/a/span[contains(text(),'Status')]")
	private WebElement selectStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//div/div/..//li/a/span[contains(text(),'SSR')]")
	private WebElement selectSSR;

	@FindBy(xpath = ".//*[@id='filter_form']/div[1]/div/div[3]/div/div/input[@name='SSR_NBR']")
	private WebElement txtSSRName;

	@FindBy(xpath = ".//*[@id='filter_form']//select[@name='STATUS']/option[@value='CREATED']")
	private WebElement btnCreatedStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//select[@name='STATUS']/option[@value='PLANNED']")
	private WebElement btnPlannedStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//select[@name='STATUS']/option[@value='COMPLETED']")
	private WebElement btnCompletedStatus;

	@FindBy(xpath = ".//*[@id='filter_form']//div//button[@data-id='STATUS']")
	private WebElement btnSelectStatus;

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

	@FindBy(xpath = ".//form//div//label[@for='ssrNbr']")
	private WebElement lblRequestNumber;

	@FindBy(xpath = ".//form//div//label[@for='ssrStatus']")
	private WebElement lblRequestStatus;

	@FindBy(xpath = ".//form//div//label[@for='invoiceOptionCode']")
	private WebElement lblRequestInvoiceOption;

	@FindBy(xpath = ".//form//div//label[@for='remarks']")
	private WebElement lblRequestRemarks;

	@FindBy(xpath = ".//form//div//label[@for='requestByNbr']")
	private WebElement lblRequestBOL;

	@FindBy(xpath = ".//form//div//label[@for='carrierVisitCode']")
	private WebElement lblRequestVisit;

	@FindBy(xpath = ".//form//div//label[@for='notificationEmail']")
	private WebElement lblRequestEmail;

	@FindBy(xpath = ".//section//div[contains(@class,'accordion')]//h3[contains(text(),'Filter')]")
	private WebElement containerAccordion;

	@FindBy(xpath = ".//div//div/button[@data-id='devanningLocation']")
	private WebElement btnTargetLocation;

	@FindBy(xpath = ".//div[@data-name='invoiceOptionCode']//button")
	private WebElement btnUpdateInvoice;

	@FindBy(xpath = ".//div[contains(@class,'panel-block-actions')]//a[2]")
	private WebElement btnAllAction;

	@FindBy(xpath = ".//*[@id='action_popup']//a//span[contains(text(),'Plan')]")
	private WebElement btnPlanRequest;

	@FindBy(xpath = ".//*[@id='action_popup']//a//span[contains(text(),'Approve')]")
	private WebElement btnApproveRequest;

	@FindBy(xpath = ".//div[@id='DEVANNING-DETAILS']//a[@title='Edit Details']")
	private WebElement btnEditDevanningDetails;

	@FindBy(xpath = ".//div[@id='DEVANNING-REMARKS']//a[@title='Edit Remarks']")
	private WebElement btnEditDevanningRemarks;

	@FindBy(xpath = ".//section/aside[2]//p[contains(text(),'successfully')]")
	private WebElement lblSuccessContainerSave;

	@FindBy(xpath = ".//div[@id='CONTAINER']//a[text()='Edit Container']")
	private WebElement btnEditContainer;

	@FindBy(xpath = ".//form//div[@data-name='cheTypeCode']//button")
	private WebElement btnCHEOption;

	@FindBy(xpath = ".//div[@data-element='approverRemarks']//label[@for='approverRemarks']")
	private WebElement lblApproverRemarks;

	/* -------------------- Indexpages Methods -------------------- */

	public ServiceRequestVerification openServiceRequestScreen() {

		log("Step " + (LoginIndexpage.logstep++) + ": Open \"Search Request\" screen.");

		Common.clickOn(driver, selectSearchRequestScreen);

		return new ServiceRequestVerification(driver);
	}

	public ServiceRequestVerification openCreateRequestScreen() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on \"Create Request\" button.");

		Common.clickOn(driver, btnOpenCreateRequest);

		Common.pause(2);

		return new ServiceRequestVerification(driver);

	}

	public ServiceRequestVerification selectDevanningRequest() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on \"Request Type\" drop down.");

		Common.clickOn(driver, selectRequestType);

		Common.pause(2);

		log("Step " + (LoginIndexpage.logstep++) + ": Select Devanning from Request Type option.");

		Common.clickOn(driver, selectDevanning);

		return new ServiceRequestVerification(driver);
	}

	public ServiceRequestVerification enterInformationForRequest() {

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Customer Name : <font color=#9400D3>" + customerName
				+ "</font>");

		getCustomer(customerName);

		try {
			Common.pause(10);
			Common.waitForElementIsDisplayed(drpdwnDocumentType);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		selectDocumentType("BOL");

		enterBOLNum(bolNumber);

		checkInvoiceOption();

		return new ServiceRequestVerification(driver);

	}

	private void getCustomer(String customerName2) {

		Common.type(txtCustomerCode, customerName.substring(0, 3));

		Common.pause(5);

		List<WebElement> lstCustomers = driver.findElements(By.xpath(".//ul[@data-element-auto='customerCode']/li"));

		for (WebElement ele : lstCustomers) {

			if (ele.getAttribute("data-value").contains(customerName)) {
				Common.clickOn(driver, ele);
			}

		}

		Common.pause(5);

		try {
			Common.waitForElementIsDisplayed(lblInvoiceOption);
		} catch (InterruptedException e) {
			Common.pause(5);
		}

	}

	private void enterBOLNum(String bolNumber) {

		log("Step " + (LoginIndexpage.logstep++) + ": Enter BOL Number :<font color=#9400D3>" + bolNumber + "</font>");

		Common.type(txtRequestNumber, bolNumber);

		Common.clickOn(driver, txtCustomerCode);

		waitForBOLLoad();
	}

	private void waitForBOLLoad() {

		Common.pause(5);

		List<WebElement> lstVessles = driver.findElements(By.xpath(".//select[@name='vesselVisitCode']/option"));

		if (lstVessles.size() > 2) {

			log("Step " + (LoginIndexpage.logstep++) + ": Vessel Visits found for BOL.");

			lstVessles.remove(0);
			lstVessles.remove(0);

			for (WebElement e : lstVessles) {

				log(e.getText());
			}

		} else {

			log("Step " + (LoginIndexpage.logstep++) + ": No Vessel Visit found.");

		}

	}

	private void selectDocumentType(String type) {

		Common.pause(2);

		Common.clickOn(driver, drpdwnDocumentType);

		if (selectBOL.isDisplayed()) {
			System.err.println("element foubnd");
		} else {
			System.err.println("not found");
		}
		Common.pause(1);

		switch (type) {
		case "BOL":
			Common.clickOn(driver, selectBOL);
			log("Step " + (LoginIndexpage.logstep++) + ": Select Document Type : <font color=#9400D3>BOL</font>");
			break;
		case "Container":
			Common.clickOn(driver, selectContainer);
			log("Step " + (LoginIndexpage.logstep++) + ": Select Document Type : <font color=#9400D3>"
					+ selectContainer.getText() + "</font>");
			break;

		}

		Common.pause(1);

	}

	private void checkInvoiceOption() {

		System.err.println(lblInvoiceOption.getAttribute("title"));

		if (lblInvoiceOption.getAttribute("title").equals("Prepaid")
				|| lblInvoiceOption.getAttribute("title").equals("Postpaid")
				|| lblInvoiceOption.getAttribute("title").equals("Not Applicable")) {

			log("Step " + (LoginIndexpage.logstep++) + ": Customer Invoice Option : <font color=#9400D3>"
					+ lblInvoiceOption.getAttribute("title") + "</font>");

		} else {
			log("Step " + (LoginIndexpage.logstep++) + ": Customer Invoice Option : Not Found");
		}

	}

	public ServiceRequestVerification selectVesselVisit() {

		Common.pause(5);

		try {
			Common.waitForElementIsDisplayed(drpdwnVesselVisitCode);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Common.clickOn(driver, drpdwnVesselVisitCode);

		List<WebElement> lstVessles = driver.findElements(By.xpath(".//select[@id='vesselVisitCode']//option"));

		System.err.println(lstVessles.size());

		if (lstVessles.size() > 2) {

			System.err.println(lstVessles.size());

			int index = CFSCommon.getRandomNumber(3, lstVessles.size());
			System.err.println(index);

			WebElement ele = driver.findElement(By.xpath(".//select[@id='vesselVisitCode']//option[" + index + "]"));

			log("Step " + (LoginIndexpage.logstep++) + ": Click on Vessel Visit : <font color=#9400D3>" + ele.getText()
					+ "</font>");

			ele.click();

		} else {

		}

		Common.pause(5);

		return new ServiceRequestVerification(driver);

	}

	public ServiceRequestVerification enterInvalidBOL() {

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Customer Name : <font color=#9400D3>" + customerName
				+ "</font>");

		getCustomer(customerName);

		Common.clickOn(driver, txtRequestNumber);

		Common.pause(7);

		checkInvoiceOption();

		Common.pause(1);

		selectDocumentType("BOL");

		enterBOLNum(CFSCommon.randomChar(3) + CFSCommon.getRandomNumber(100000, 999999));

		return new ServiceRequestVerification(driver);
	}

	public ServiceRequestVerification getBOLDetails() {

		List<WebElement> lstBOLNumber = driver
				.findElements(By.xpath(".//section[2]//div//input[contains(@class,'bolNo')]"));

		List<WebElement> lstAuthNumber = driver
				.findElements(By.xpath(".//section[2]//div//input[contains(@class,'authNo')]"));

		List<WebElement> lstContainerNumber = driver
				.findElements(By.xpath(".//section[2]//div//input[contains(@class,'containerCode')]"));

		log("<strong>BOL Info : " + lstBOLNumber.size() + "</strong>");

		for (int i = 0; i < lstBOLNumber.size(); i++) {

			log("BOL Number : <font color=#9400D3>" + lstBOLNumber.get(i).getAttribute("value")
					+ "</font> | Auth No. : <font color=#9400D3>" + lstAuthNumber.get(i).getAttribute("value")
					+ "</font>");

		}

		log("<strong>Container(s) : " + lstContainerNumber.size() + "</strong>");

		return new ServiceRequestVerification(driver);
	}

	public ServiceRequestVerification fillCompleteForm() {

		log("Step " + (LoginIndexpage.logstep++) + ": Selected Request Date : <font color=#9400D3>"
				+ txtRequestDate.getAttribute("value") + "</font>");

		selectTargetLocation();

		enterEmailAddress();

		selectContainerListforRequest();

		return new ServiceRequestVerification(driver);

	}

	private void selectContainerListforRequest() {

		List<WebElement> lstCheckContainer = driver.findElements(By
				.xpath(".//section[2]//div[contains(text(),'Container')]/..//div[contains(@class,'checkbox')]/input"));

		List<WebElement> lstContainerStatus = driver.findElements(By
				.xpath(".//section[2]//div[contains(text(),'Container')]/..//div[contains(@class,'checkbox')]/label"));

		for (int i = 0; i < lstCheckContainer.size(); i++) {

			if (lstCheckContainer.get(i).isSelected()) {
				Common.checkChkBox(lstContainerStatus.get(i));
				System.err.println(lstCheckContainer.get(i).isSelected());
			}

		}

		log("Step " + (LoginIndexpage.logstep++) + ": Select Containers for Request.");

		int rand = CFSCommon.getRandomNumber(0, lstCheckContainer.size() - 1);

		if (!lstContainerStatus.get(rand).isSelected()) {
			Common.checkChkBox(lstContainerStatus.get(rand));

		}

	}

	private void enterEmailAddress() {

		Common.type(txtEmailNotification, customerMailAdd);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Email for update : <font color=#9400D3>" + customerMailAdd
				+ "</font>");

	}

	private void selectTargetLocation() {

		Common.clickOn(driver, btnTargetLocation);

		Common.pause(1);

		List<WebElement> lstTargetLocations = driver
				.findElements(By.xpath(".//select[@id='devanningLocation']//option"));

		WebElement targetLocation = lstTargetLocations.get(CFSCommon.getRandomNumber(3, lstTargetLocations.size() - 1));

		log("Step " + (LoginIndexpage.logstep++) + ": Select Target location : <font color=#9400D3>"
				+ targetLocation.getText() + "</font>");

		Common.clickOn(driver, targetLocation);

	}

	public ServiceRequestVerification addAdditionalServiceandRemarks() {

		selectAdditionalService();

		addRemarks();

		return new ServiceRequestVerification(driver);

	}

	private void selectAdditionalService() {

		Common.pause(1);

		Common.clickOn(driver, drpdwnServiceName);

		List<WebElement> lstServices = driver
				.findElements(By.xpath(".//div[contains(@class,'serviceDropdown')]//ul/li//span[1]"));

		System.err.println(lstServices.size());

		if (lstServices.size() > 0) {

			int index = CFSCommon.getRandomNumber(2, lstServices.size());
			System.err.println(index);

			WebElement ele = driver
					.findElement(By.xpath(".//div[contains(@class,'serviceDropdown')]//ul/li[" + index + "]//span[1]"));

			log("Step " + (LoginIndexpage.logstep++) + ": Select Additional Service.: <font color=#9400D3>"
					+ ele.getText() + "</font>");

			ele.click();

		} else {

		}

		Common.pause(1);

		String serviceQuantity = "" + CFSCommon.getRandomNumber(1, 20);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Quantity : <font color=#9400D3>" + serviceQuantity
				+ "</font>");

		Common.type(txtSeviceQuantity, serviceQuantity);

		Common.pause(1);

		selectQuantityUOM();

		Common.pause(1);

		clickOnAddService();

	}

	private void clickOnAddService() {

		Common.clickOn(driver, btnAddService);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Add Service button. ");

	}

	private void selectQuantityUOM() {

		Common.pause(1);

		Common.clickOn(driver, drpdwnServiceUOM);

		List<WebElement> lstUOM = driver
				.findElements(By.xpath(".//div[contains(@class,'uomDropdown')]//ul/li//span[1]"));

		System.err.println(lstUOM.size());

		if (lstUOM.size() > 0) {

			int index = CFSCommon.getRandomNumber(2, lstUOM.size());
			System.err.println(index);

			WebElement ele = driver
					.findElement(By.xpath(".//div[contains(@class,'uomDropdown')]//ul/li[" + index + "]//span[1]"));

			log("Step " + (LoginIndexpage.logstep++) + ": Select UOM: <font color=#9400D3>" + ele.getText()
					+ "</font>");

			ele.click();

		} else {

		}

	}

	private void addRemarks() {

		Common.type(txtRemarks, approvalRemarks);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Remarks : <font color=#9400D3>" + approvalRemarks
				+ "</font>");

	}

	public ServiceRequestVerification saveCreatedRequest() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Save button. ");

		Common.clickOn(driver, btnSave);

		try {

			if (lblEditRequestWarning.isDisplayed()) {

				log("Warning message display.");

				clickOnYes();
			}
		} catch (Exception e) {

		}

		return new ServiceRequestVerification(driver);
	}

	private void clickOnYes() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on Yes button.");

		Common.clickOn(driver, btnYes);
	}

	public ServiceRequestVerification openCreatedRequest() {

		filterCreatedRequest();

		Common.pause(2);

		selectRequestandView();

		return new ServiceRequestVerification(driver);

	}

	private void selectRequestandView() {

		Common.pause(3);

		WebElement ele = driver.findElement(By.xpath(".//table/tbody/tr[1]/td[1]//label"));

		log("Step " + (LoginIndexpage.logstep++) + ": Select one of the request from the table and view.");

		Common.clickOn(driver, ele);

		Common.pause(1);

		WebElement btnViewIcon = driver.findElement(By.xpath(".//table/tbody/tr[1]/td[@class='view-icon']"));

		Common.clickOn(driver, btnViewIcon);

		Common.pause(10);

	}

	public void filterCreatedRequest() {

		try {
			driver.findElement(By.xpath(".//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openFilterAccordion();

		}

		if (!btnFilter.isDisplayed()) {

			openFilterScreen();

			clickOnResetButton();

		}

		log("Step " + (LoginIndexpage.logstep++) + ": Select Status from dropdown and filter with created request.");

		Common.clickOn(driver, addFileldFilter);

		Common.clickOn(driver, selectStatus);

		Common.clickOn(driver, btnSelectStatus);

		Common.clickOn(driver, btnCreatedStatus);

		Common.clickOn(driver, switchON);

		Common.clickOn(driver, addFileldFilter);

		Common.clickOn(driver, selectSSR);

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

		Common.clickOn(driver, switchON);

		Common.clickOn(driver, btnFilter);

		Common.pause(3);
	}

	private void openFilterAccordion() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on \"Filter\" accordion.");

		Common.clickOn(driver, filterAccordion);

		Common.pause(1);
	}

	public void openFilterScreen() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on \"Filter\" button.");

		// Common.clickOn(driver, btn_selectFilter);

		Common.pause(3);

	}

	private void clickOnResetButton() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Reset' button. ");

		Common.clickOn(driver, btnResetFilter);
		Common.clickOn(driver, btnResetFilter);
	}

	public ServiceRequestVerification getCreatedRequestData() {

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Details of opened request. </strong>");

		log("Request Number : <font color=#9400D3>" + lblRequestNumber.getText() + "</font>");

		log("Request Status : <font color=#9400D3>" + lblRequestStatus.getText() + "</font>");

		log("Invoice Option : <font color=#9400D3>" + lblRequestInvoiceOption.getText() + "</font>");

		log("Vessel Visit : <font color=#9400D3>" + lblRequestVisit.getText() + "</font>");

		log("Email address : <font color=#9400D3>" + lblRequestEmail.getText() + "</font>");

		log("Requestor Remarks : <font color=#9400D3>" + lblRequestRemarks.getText() + "</font>");

		return new ServiceRequestVerification(driver);

	}

	public ServiceRequestVerification changeRequestDataAndPlan() {

		if (!(lblRequestInvoiceOption.getText().equals("Postpaid"))) {

			log("Changing Request Invoice option to Postpaid.");

			Common.clickOn(driver, btnEditDevanningDetails);

			Common.pause(10);

			try {
				Common.waitForElementIsDisplayed(btnUpdateInvoice);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Common.clickOn(driver, btnUpdateInvoice);

			Common.pause(1);

			WebElement ele = driver
					.findElement(By.xpath(".//body/div//ul[@role='menu']/li/a/span[contains(text(),'Postpaid')]"));

			Common.clickOn(driver, ele);

			Common.pause(2);

			Common.clickOn(driver, btnSave);

			Common.pause(10);

			try {
				Common.waitForElementIsDisplayed(lblRequestInvoiceOption);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Common.pause(10);
		}

		System.err.println("we are here1");

		changeContainerCHE();

		System.err.println("we are here2");

		addPlanRemarks();

		planRequest();

		return new ServiceRequestVerification(driver);
	}

	private void changeContainerCHE() {

		System.err.println("we are here");

		List<WebElement> lstEditContainer = driver.findElements(By.xpath(".//div[@id='CONTAINER']//table//tbody/tr"));

		lstContainerNr = driver.findElements(By.xpath(".//div[@id='CONTAINER']//table//tbody/tr//td[3]"));

		containerNr1 = lstContainerNr.get(0).getText();

		System.err.println(
				lstEditContainer.size() + "-----====-----" + lstEditContainer + lstContainerNr.size() + containerNr1);

		for (int i = 1; i <= lstEditContainer.size(); i++) {

			Common.pause(10);

			WebElement checkContainer = driver
					.findElement(By.xpath(".//div[@id='CONTAINER']//table//tbody/tr[" + i + "]//label"));

			Common.checkChkBox(checkContainer);

			Common.pause(1);

			Common.clickOn(driver, btnEditContainer);

			try {
				Common.waitForElementIsDisplayed(btnCHEOption);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Common.clickOn(driver, btnCHEOption);

			Common.pause(2);

			List<WebElement> lstCHEOption = driver
					.findElements(By.xpath(".//form//div[2]//select[@id='cheTypeCode']//option"));

			System.err.println(lstCHEOption.size());

			for (WebElement e : lstCHEOption) {
				System.err.println(e.getText());
			}

			if (lstCHEOption.size() > 2) {

				int num = CFSCommon.getRandomNumber(3, lstCHEOption.size() - 1);

				System.err.println("ches" + num);

				log("Step " + (LoginIndexpage.logstep++) + ": Select CHE Option : <font color=#9400D3>"
						+ lstCHEOption.get(num).getText() + "</font>");

				Common.clickOn(driver, lstCHEOption.get(num));
			}

			Common.pause(1);

			log("Step " + (LoginIndexpage.logstep++) + ": Click on Save button");

			Common.clickOn(driver, btnSave);

			Common.pause(40);

		}

	}

	private void addPlanRemarks() {

		Common.pause(2);

		Common.clickOn(driver, btnEditDevanningRemarks);

		Common.pause(20);

		Common.type(txtDevanningRemarks, devanningRemarks);

		log("Step " + (LoginIndexpage.logstep++) + ": Enter Devanning Remarks : <font color=#9400D3>" + devanningRemarks
				+ "</font>");

		Common.pause(1);

		Common.clickOn(driver, btnSave);

		Common.pause(30);

		try {

			Common.waitForElementIsDisplayed(lblApproverRemarks);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void planRequest() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on All action icon from the top right corner. ");

		Common.clickOn(driver, btnAllAction);

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Plan' from the menu. ");

		Common.clickOn(driver, btnPlanRequest);

	}

	public ServiceRequestVerification openPlannedRequest() {

		filterPlannedRequest();

		Common.pause(2);

		selectRequestandView();

		return new ServiceRequestVerification(driver);
	}

	public void filterPlannedRequest() {

		try {
			driver.findElement(By.xpath(".//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openFilterAccordion();

		}

		if (!btnFilter.isDisplayed()) {

			openFilterScreen();

			clickOnResetButton();

		}

		log("Step " + (LoginIndexpage.logstep++) + ": Select Status from dropdown and filter with planned request.");

		Common.clickOn(driver, addFileldFilter);

		Common.clickOn(driver, selectStatus);

		Common.clickOn(driver, btnSelectStatus);

		Common.clickOn(driver, btnPlannedStatus);

		Common.clickOn(driver, switchON);

		Common.clickOn(driver, addFileldFilter);

		Common.clickOn(driver, selectSSR);

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

		Common.clickOn(driver, switchON);

		Common.clickOn(driver, btnFilter);

		Common.pause(3);
	}

	public ServiceRequestVerification changeRequestDataAndApprove() {

		approveRequest();

		return new ServiceRequestVerification(driver);

	}

	private void approveRequest() {

		log("Step " + (LoginIndexpage.logstep++) + ": Click on All action icon from the top right corner. ");

		Common.clickOn(driver, btnAllAction);

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": Click on 'Approve' from the menu. ");

		Common.clickOn(driver, btnApproveRequest);
	}

	public ServiceRequestVerification openCompletedRequest() {

		filterCompletedRequest();

		Common.pause(2);

		selectRequestandView();

		return new ServiceRequestVerification(driver);

	}

	private void filterCompletedRequest() {

		try {
			driver.findElement(By.xpath(".//section[contains(@class,'active')]"));

		} catch (Exception e) {

			openFilterAccordion();

		}

		if (!btnFilter.isDisplayed()) {

			openFilterScreen();

			clickOnResetButton();

		}

		log("Step " + (LoginIndexpage.logstep++) + ": Select Status from dropdown and filter with completed request.");

		Common.clickOn(driver, addFileldFilter);

		Common.clickOn(driver, selectStatus);

		Common.clickOn(driver, btnSelectStatus);

		Common.clickOn(driver, btnCompletedStatus);

		Common.clickOn(driver, switchON);

		Common.clickOn(driver, addFileldFilter);

		Common.clickOn(driver, selectSSR);

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

		Common.clickOn(driver, switchON);

		Common.clickOn(driver, btnFilter);

		Common.pause(3);
	}

	public ServiceRequestVerification getCompletedRequestData() {

		Common.pause(1);

		log("Step " + (LoginIndexpage.logstep++) + ": <Strong>Details of completed request. </strong>");

		log("Request Number : <font color=#9400D3>" + lblRequestNumber.getText() + "</font>");

		log("Request Status : <font color=#9400D3>" + lblRequestStatus.getText() + "</font>");

		log("Invoice Option : <font color=#9400D3>" + lblRequestInvoiceOption.getText() + "</font>");

		log("Vessel Visit : <font color=#9400D3>" + lblRequestVisit.getText() + "</font>");

		log("Email address : <font color=#9400D3>" + lblRequestEmail.getText() + "</font>");

		log("Requestor Remarks : <font color=#9400D3>" + lblRequestRemarks.getText() + "</font>");

		return new ServiceRequestVerification(driver);

	}

}