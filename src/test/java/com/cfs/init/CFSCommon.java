package com.cfs.init;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CFSCommon {

	static Random ran = new Random();

	public static String randomChar(int length) {
		String firName = RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
		return firName;
	}

	public static int getRandomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}

	public static void selectPaginationValue(WebDriver driver, int recordNum) {

		Common.jsClick(driver, driver.findElement(By.xpath(".//*[@id='panel-grid-content']/div[1]/div[1]/div[2]/div")));

		Common.pause(1);

		Common.jsClick(driver,
				driver.findElement(
						By.xpath(".//*[@id='panel-grid-content']/div[1]/div[1]/div[2]//ul/li//span[contains(text(),'"
								+ recordNum + "')]")));

		Common.pause(5);
	}

	public static String getRandomDeviceSerialNo(WebDriver driver) {

		String numString = Integer.toString(getRandomNumber(100000, 999999));

		return "KQRDID" + numString;

	}

	public static String getRandomContainerNo(WebDriver driver) {

		String numString = Integer.toString(getRandomNumber(100000, 999999));

		return "CNT" + numString;

	}

	public static String getRandomTOSCycleID(WebDriver driver) {

		String numString = Integer.toString(getRandomNumber(100000, 999999));

		return "TOS" + numString;

	}

	public static String getRandomDeviceName(WebDriver driver) {

		return "KQRDNM" + getRandomNumber(100000, 999999);
	}

	/*
	 * public static WebElement getCertifyingStatus(WebDriver driver) {
	 * 
	 * List<WebElement> listCertStatus = driver .findElements(By .xpath(
	 * ".//*[@id='addDevice']/div[1]//div/button/span[contains(text(),'Certifying Status')]/../../div//li//span[@class='text']"
	 * ));
	 * 
	 * int random_cert = randBetween(1, listCertStatus.size());
	 * 
	 * WebElement certStatus = driver .findElement(By .xpath(
	 * ".//*[@id='addDevice']/div[1]//div/button/span[contains(text(),'Certifying Status')]/../../div//li["
	 * + random_cert + "]//span[@class='text']"));
	 * 
	 * return certStatus; }
	 */

	public static String getUOM(WebDriver driver) {

		String[] uom = { "Kilogram", "Pound", "MatricTon" };

		String random_uom = uom[ran.nextInt(uom.length)];

		return random_uom;
	}

	public static String getTerminalInfo(WebDriver driver) {

		return randomChar(20);
	}

	public static String getRandomDate(int start, int end) {

		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(start, end);

		gc.set(Calendar.YEAR, year);

		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		int month = (gc.get(Calendar.MONTH) + 1);

		System.err.println(dayOfMonth + "----------------" + month);

		String strDayOfMonth = null;
		String strMonth = null;

		if (gc.get(Calendar.DAY_OF_MONTH) < 10 || (gc.get(Calendar.MONTH) + 1) < 10) {
			strDayOfMonth = String.format("%02d", dayOfMonth);
			strMonth = String.format("%02d", month);

			System.err.println(strDayOfMonth + "----------------" + strMonth);

		} else {
			strDayOfMonth = dayOfMonth + "";
			strMonth = month + "";

			System.err.println(strDayOfMonth + "----------------" + strMonth);
		}

		System.out.println(gc.get(Calendar.YEAR) + "-" + strMonth + "-" + gc.get(Calendar.DAY_OF_MONTH));

		String date = strDayOfMonth + "/" + strMonth + "/" + gc.get(Calendar.YEAR);

		return date;

	}

	public static String getRandomTime() {

		Date d = new Date(getRandomNumber(1, 99999) * 1000L);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		String time = df.format(d);

		return time;
	}

	public static String getRandomFutureDate(int days) {

		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days); // number of days to add
		String newDate = (String) (formattedDate.format(c.getTime()));
		System.out.println("New date is " + newDate);

		return newDate.toString();
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static double getRandomGrossMass() {

		return getRandomNumber(200000, 999999);
	}

	public static void getColumnNumber(WebDriver driver, String columnName) {

		List<WebElement> columns = driver.findElements(By.xpath(".//table/thead/tr/th//span"));

		System.err.println(columns.size());

		int columnNumber = 0;

		for (WebElement e : columns) {

			System.out.println(
					e.getText() + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + columnNumber);

			columnNumber++;
			/*
			 * if(e.getText().contains(columnName)){
			 * 
			 * System.out.println(e.getText() +
			 * "-------------------------------------------------------------");
			 * 
			 * break; }
			 */

		}

	}

	public static void manageRule1Column(WebDriver driver) {

		WebElement manageColumns = driver.findElement(By.xpath(".//div[1]/div[2]/a[contains(text(),'Manage')]"));

		Common.jsClick(driver, manageColumns);

		Common.pause(1);

		WebElement Rule1Status = driver.findElement(By.xpath(".//*[@id='visible-columns']/div/div[1]/li[18]"));

		Common.jsClick(driver, Rule1Status);

		Common.pause(1);

		WebElement moveUp = driver.findElement(By.xpath(".//*[@id='manage-columns']/div//div/span[3]/a"));

		for (int i = 0; i <= 25; i++) {

			Common.jsClick(driver, moveUp);
		}

		WebElement applyButton = driver
				.findElement(By.xpath(".//*[@id='manage-columns']/div//button[contains(text(),'Apply')]"));

		Common.jsClick(driver, applyButton);

		Common.pause(5);

		WebElement alert = driver
				.findElement(By.xpath(".//aside[2]/div/div[2]/div[1]/div/div[2]/p[@class='alert-msg']"));

		Common.waitForElement(driver, alert);
	}

	public static void manageRule2Column(WebDriver driver) {

		WebElement manageColumns = driver.findElement(By.xpath(".//div[1]/div[2]/a[contains(text(),'Manage')]"));

		Common.jsClick(driver, manageColumns);

		Common.pause(1);

		WebElement Rule2Status = driver.findElement(By.xpath(".//*[@id='visible-columns']/div/div[1]/li[19]"));

		Common.jsClick(driver, Rule2Status);

		Common.pause(1);

		WebElement moveUp = driver.findElement(By.xpath(".//*[@id='manage-columns']/div//div/span[3]/a"));

		for (int i = 0; i <= 25; i++) {

			Common.jsClick(driver, moveUp);
		}

		WebElement applyButton = driver
				.findElement(By.xpath(".//*[@id='manage-columns']/div//button[contains(text(),'Apply')]"));

		Common.jsClick(driver, applyButton);

		Common.pause(5);

		WebElement alert = driver
				.findElement(By.xpath(".//aside[2]/div/div[2]/div[1]/div/div[2]/p[@class='alert-msg']"));

		Common.waitForElement(driver, alert);
	}

	public static void manageRule3Column(WebDriver driver) {

		WebElement manageColumns = driver.findElement(By.xpath(".//div[1]/div[2]/a[contains(text(),'Manage')]"));

		Common.jsClick(driver, manageColumns);

		Common.pause(1);

		WebElement Rule3Status = driver.findElement(By.xpath(".//*[@id='visible-columns']/div/div[1]/li[20]"));

		Common.jsClick(driver, Rule3Status);

		Common.pause(1);

		WebElement moveUp = driver.findElement(By.xpath(".//*[@id='manage-columns']/div//div/span[3]/a"));

		for (int i = 0; i <= 25; i++) {

			Common.jsClick(driver, moveUp);
		}

		WebElement applyButton = driver
				.findElement(By.xpath(".//*[@id='manage-columns']/div//button[contains(text(),'Apply')]"));

		Common.jsClick(driver, applyButton);

		Common.pause(5);

		WebElement alert = driver
				.findElement(By.xpath(".//aside[2]/div/div[2]/div[1]/div/div[2]/p[@class='alert-msg']"));

		Common.waitForElement(driver, alert);

	}

	public static void manageRule4Column(WebDriver driver) {

		WebElement manageColumns = driver.findElement(By.xpath(".//div[1]/div[2]/a[contains(text(),'Manage')]"));

		Common.jsClick(driver, manageColumns);

		Common.pause(1);

		WebElement Rule4Status = driver.findElement(By.xpath(".//*[@id='visible-columns']/div/div[1]/li[21]"));

		Common.jsClick(driver, Rule4Status);

		Common.pause(1);

		WebElement moveUp = driver.findElement(By.xpath(".//*[@id='manage-columns']/div//div/span[3]/a"));

		for (int i = 0; i <= 25; i++) {

			Common.jsClick(driver, moveUp);
		}

		WebElement applyButton = driver
				.findElement(By.xpath(".//*[@id='manage-columns']/div//button[contains(text(),'Apply')]"));

		Common.jsClick(driver, applyButton);

		Common.pause(5);

		WebElement alert = driver
				.findElement(By.xpath(".//aside[2]/div/div[2]/div[1]/div/div[2]/p[@class='alert-msg']"));

		Common.waitForElement(driver, alert);

	}

	public static void scrollToElement(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		Common.pause(1);
	}

	public static String getDeviceType(WebDriver driver) {

		String[] deviceList = { "Yard Crane", "External Tractor", "Tractor", "Quay Crane", "RTG", "Gantry Shore Crane",
				"Mobile Shore Crane", "Handheld", "RMG", "Top Loader", "Reach Stacker", "Weighbridge",
				"Weighing Device" };

		String randomType = deviceList[ran.nextInt(deviceList.length)];

		return randomType;
	}

	public static String getCertifyingStatus(WebDriver driver) {

		String[] statusList = { "CERTIFIED", "NORMAL", "UNTRUSTED" };

		String randomType = statusList[ran.nextInt(statusList.length)];

		return randomType;
	}

	public static String getAcccuracyType(WebDriver driver) {

		String[] statusList = { "Percentage", "Absolute" };

		String randomType = statusList[ran.nextInt(statusList.length)];

		return randomType;
	}

	public static String getAPIDateFormat(String stringName) {

		String string = stringName;
		String[] parts = string.split("/");
		String day = parts[0];
		String month = parts[1];
		String year = parts[2];

		String reverse = year + "-" + month + "-" + day + "T" + getRandomTime() + ".00+05:30";

		return reverse;
	}

	public static int returnNumber(int number) {

		int outNum;

		if (number == 1) {
			outNum = number + 1;
		} else if (number % 2 == 0) {
			outNum = number;
		} else {
			outNum = number - 1;
		}

		return outNum;
	}
}
