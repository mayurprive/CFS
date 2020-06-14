package CFS_QA.CFS_QA;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cfs.init.CFSCommon;
import com.cfs.init.Common;

/**
 * Hello world!
 *
 */
public class App {

	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	static String userDir = System.getProperty("user.dir");

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Hello World!");

		String s1c = "305012719: SSR227123881931 Request request has been planned successfully ";

		for (int i = 0; i < 3; i++) {
			System.err.println("Print This");
		}

		System.out.println(s1c.substring(11, 27));

		Date date = new Date();
		System.out.println(sdf.format(date));

		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 2); // number of days to add
		String tomorrow = (String) (formattedDate.format(c.getTime()));
		System.out.println("Tomorrows date is " + tomorrow);

		Thread.sleep(5000);

		/*
		 * DesiredCapabilities capability = DesiredCapabilities.chrome();
		 * 
		 * File file = new File(userDir + "//lib//IEDriverServer.exe");
		 * System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		 * 
		 * 
		 * capability.setBrowserName("chrome");
		 * capability.setJavascriptEnabled(true);
		 * 
		 * 
		 * driver = new InternetExplorerDriver(capability);
		 * 
		 * driver.get("http://www.google.com");
		 * 
		 * Thread.sleep(5000);
		 * 
		 * openUrlInNewTab2(driver, "http://www.gmail.com");
		 * 
		 * Thread.sleep(5000);
		 */

		for (int i = 0; i < (checkNum(1)) / 2; i++) {
			System.err.println(i);
		}

	}

	public static int checkNum(int num) {
		int outNum;

		if (num == 1) {
			outNum = num+1;
		} else if (num % 2 == 0) {
			outNum = num;
		} else {
			outNum = num - 1;
		}

		//System.err.println(outNum + "-----");
		return outNum;
	}

	public static void openUrlInNewTab(WebDriver driver, String url) throws InterruptedException {

		// get the current window handle

		// String parentHandle = driver.getWindowHandle();

		// click some link that opens a new window
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");

		// switch focus of WebDriver to the next found window handle (that's
		// your newly opened window)
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// code to do something on new window

		driver.get(url);

		// driver.navigate().to(url);

	}

	public static void openUrlInNewTab2(WebDriver driver, String url) throws InterruptedException {

		// get the current window handle

		Set<String> windows = driver.getWindowHandles();
		String adminToolHandle = driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("window.open();");
		Set<String> customerWindow = driver.getWindowHandles();
		customerWindow.removeAll(windows);
		String customerSiteHandle = ((String) customerWindow.toArray()[0]);
		driver.switchTo().window(customerSiteHandle);
		driver.get(url);
		driver.switchTo().window(adminToolHandle);
		// driver.navigate().to(url);

	}

}
