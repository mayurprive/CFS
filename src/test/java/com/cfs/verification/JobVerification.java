package com.cfs.verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cfs.init.AbstractPage;
import com.cfs.init.Common;

public class JobVerification extends AbstractPage {

	public JobVerification(WebDriver driver) {
		super(driver);
	}

	/* -------------------- Declarations -------------------- */

	public static int numberOfJobs;
	public static String searchJobHeader = "Search Job";

	/*
	 * -------------------- List of xpath for web elements --------------------
	 */

	@FindBy(xpath = ".//aside[2]/div/div[1]/div[2]")
	private WebElement lblJob;

	@FindBy(xpath = ".//section/aside[2]//p[contains(text(),'successfully')]")
	private WebElement lblSuccessServiceCreate;

	@FindBy(xpath = ".//form//div//label[@for='jobStatus']")
	private WebElement lblJobStatus;

	@FindBy(xpath = ".//input[@name='seal1']")
	private WebElement txtSealOne;

	@FindBy(xpath = ".//*[@id='alert-exceptions']//div[@class='alert-btn-popup']")
	private WebElement lblErrorMessage;

	@FindBy(xpath = ".//aside[2]/div/div[1]/div[2]")
	private WebElement lblJobSummary;

	/* -------------------- Verification methods -------------------- */

	public boolean jobScreenVerification() {

		try {
			Common.waitForElementIsDisplayed(lblJob);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return lblJob.getText().contains(searchJobHeader);
	}

	public boolean jobListVerification() {

		List<WebElement> lstJobs = driver.findElements(By.xpath(
				".//div[contains(@data-griddispkey,'CFS-JOB-GRID')]//table/tbody/tr[contains(@class,'rowModels')]"));

		numberOfJobs = lstJobs.size();

		log("<strong>Total created jobs found for filtered SSR number : " + numberOfJobs + "</strong>");

		return lstJobs.get(0).isDisplayed();

	}

	public boolean viewJobScreenVerification() {

		for (int i = 1; i <= 60; i++) {
			Common.pause(1);
			System.err.println(i);
		}

		try {

			if (lblErrorMessage.isDisplayed()) {

				log("Error message display.");

				jobIndexpage.restartThePage();
			}
		} catch (Exception e) {

		}

		try {
			Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//form//div//label[@for='jobNbr']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement jobNumber = driver.findElement(By.xpath(".//form//div//label[@for='jobNbr']"));
		// WebElement bolNumber =
		// driver.findElement(By.xpath(".//form//div//label[@for='bolNbr']"));
		WebElement jobStatus = driver.findElement(By.xpath(".//form//div//label[@for='jobStatus']"));

		Common.pause(3);

		return jobStatus.isDisplayed() && jobNumber.isDisplayed();
	}

	public boolean jobPlannedVerification() {

		/*
		 * try { Common.waitForElementIsDisplayed(lblSuccessServiceCreate);
		 * log("Success Message : <Strong><font color=#008000>" +
		 * lblSuccessServiceCreate.getText() + "</strong></font>");
		 * 
		 * Common.waitForElementIsDisplayed(lblJobStatus); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 */
		for (int i = 0; i < 20; i++) {
			Common.pause(1);
		}

		return lblJobStatus.getText().equals("Planned");
	}

	public boolean viewCutSealScreenVerification() {

		for (int i = 0; i < 20; i++) {
			Common.pause(1);
		}

		try {
			Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//input[@name='seal1']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Common.pause(10);

		return txtSealOne.isDisplayed();
	}

	public boolean viewDevanScreenVerification() {

		for (int i = 0; i < 20; i++) {
			Common.pause(1);
		}

		try {
			Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//button[@data-id='bol']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Common.pause(10);

		return driver.findElement(By.xpath(".//button[@data-id='bol']")).isDisplayed();
	}

	public boolean applySealScreenVerification() {

		for (int i = 0; i < 20; i++) {
			Common.pause(1);
		}

		try {
			Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//input[@name='seal1']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Common.pause(10);

		return txtSealOne.isDisplayed();

	}

	public boolean completeJobScreenVerification() {

		for (int i = 0; i < 20; i++) {
			Common.pause(1);
		}

		try {
			Common.waitForElementIsDisplayed(driver.findElement(By.xpath(".//input[@name='plannedEndTime']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Common.pause(10);

		return driver.findElement(By.xpath(".//input[@name='plannedEndTime']")).isDisplayed();
	}

	public boolean jobSummaryScreenVerification() {

		for (int i = 0; i < 60; i++) {
			Common.pause(1);
		}

		return lblJobSummary.getText().contains("Job Summary");

	}

}
