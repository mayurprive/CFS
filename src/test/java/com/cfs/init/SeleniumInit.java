package com.cfs.init;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.Utils;

import com.cfs.indexpages.GateIndexpage;
import com.cfs.indexpages.JobIndexpage;
import com.cfs.indexpages.LoginIndexpage;
import com.cfs.indexpages.ServiceRequestIndexpage;
import com.cfs.verification.GateVerification;
import com.cfs.verification.JobVerification;
import com.cfs.verification.LoginVerification;
import com.cfs.verification.ServiceRequestVerification;

public class SeleniumInit {

	public String suiteName = "";
	public String testName = "";

	/* Minimum requirement for test configuration */

	public static String testUrl; // Test url
	protected String seleniumHub; // Selenium hub IP
	protected String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;
	public static String currentWindowHandle = "";// Get Current Window handle
	public static String browserName = "";
	public static String osName = "";
	public static String browserVersion = "";

	public static String userName = "";
	public static String password = "";
	public static String language = "";
	public static String site = "";
	public String userDir = "";

	protected static String screenshot_folder_path = null; // Path to screenshot
															// folder
	public static String currentTest; // current running test

	protected static Logger logger = Logger.getLogger("testing");
	protected WebDriver driver;
	static PropertyLoader prop = new PropertyLoader();

	/* Page's declaration */

	public LoginIndexpage loginIndexpage;
	public ServiceRequestIndexpage serviceRequestIndexpage;
	public JobIndexpage jobIndexpage;
	public LoginVerification loginVerification;
	public ServiceRequestVerification serviceRequestVerification;
	public JobVerification jobVerification;
	public GateIndexpage gateIndexpage;
	public GateVerification gateVerification;

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */

	@BeforeClass(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {

		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");
		System.out.println("\n ======" + testUrl + "========= \n");
		seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");
		targetBrowser = testContext.getCurrentXmlTest().getParameter("selenium.browser");

		userName = (String) prop.getValue("userName");
		password = (String) prop.getValue("password");
		language = (String) prop.getValue("language");
		site = (String) prop.getValue("site");

		userDir = System.getProperty("user.dir");

	}

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, ITestContext testContext) throws IOException, InterruptedException {

		currentTest = method.getName(); // get Name of current test.

		URL remote_grid = new URL("http://" + seleniumHub + ":" + seleniumHubPort + "/wd/hub");

		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();

		DesiredCapabilities capability = null;
		if (targetBrowser == null || targetBrowser.contains("firefox")) {

			FirefoxProfile profile = new FirefoxProfile();

			capability = DesiredCapabilities.firefox();

			File file = new File(userDir + "//lib//geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

			capability.setJavascriptEnabled(true);
			capability.setCapability(FirefoxDriver.PROFILE, profile);
			capability.setCapability("marionette", true);

			browserName = capability.getBrowserName();
			osName = System.getProperty("os.name");
			browserVersion = capability.getVersion().toString();

			// this.driver = new RemoteWebDriver(remote_grid, capability);

			driver = new FirefoxDriver(capability);

			System.out.println("=========" + " Mozilla Firefox Browser " + "==========");

		} else if (targetBrowser.contains("chrome")) {

			capability = DesiredCapabilities.chrome();

			File file = new File(userDir + "//lib//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);

			browserName = capability.getVersion();
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();

			driver = new RemoteWebDriver(remote_grid, capability);

			System.out.println("=========" + " Google Chrome Browser " + "==========");

		} else if (targetBrowser.contains("ie")) {

			System.setProperty("webdriver.ie.driver", userDir + "//lib//IEDriverServer.exe");

			capability = DesiredCapabilities.internetExplorer();

			capability.setBrowserName("internet explorer");
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capability.setJavascriptEnabled(true);

			this.driver = new InternetExplorerDriver(capability);

			browserName = capability.getBrowserName();
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();

			driver = new RemoteWebDriver(remote_grid, capability);

			System.out.println("=========" + " Internet Explorer Browser " + "==========");

		} else if (targetBrowser.contains("safari")) {

			capability = DesiredCapabilities.safari();

			capability.setJavascriptEnabled(true);
			capability.setBrowserName("safari");

			browserName = capability.getBrowserName();
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();

			this.driver = new SafariDriver(capability);

			System.out.println("=========" + " Safari Browser " + "==========");

		} else if (targetBrowser.contains("saucelab")) {

			capability = DesiredCapabilities.firefox();

			capability.setCapability("platform", "Windows 7");
			capability.setCapability("name", "Tarpan_firstcry");
			capability.setCapability("version", "40.0");

			driver = new RemoteWebDriver(new URL(""), capability);

			System.out.println("=========" + " Running in sauceLabs " + "==========");

		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(testUrl);
		driver.manage().window().maximize();

		currentWindowHandle = driver.getWindowHandle();

		System.out.println("Current Window Handle ID:--->" + currentWindowHandle);

		suiteName = testContext.getSuite().getName();
		System.out.println("Current Xml Suite is:---->" + suiteName);

		// Page Object Initialization According To Its Test Suite.

		loginIndexpage = new LoginIndexpage(driver);
		serviceRequestIndexpage = new ServiceRequestIndexpage(driver);
		jobIndexpage = new JobIndexpage(driver);
		loginVerification = new LoginVerification(driver);
		serviceRequestVerification = new ServiceRequestVerification(driver);
		jobVerification = new JobVerification(driver);
		gateIndexpage = new GateIndexpage(driver);
		gateVerification = new GateVerification(driver);

	}

	/**
	 * Log For Failure Test Exception.
	 * 
	 * @param tests
	 */
	private void getShortException(IResultMap tests) {

		for (ITestResult result : tests.getAllResults()) {

			Throwable exception = result.getThrowable();
			List<String> msgs = Reporter.getOutput(result);
			boolean hasReporterOutput = msgs.size() > 0;
			boolean hasThrowable = exception != null;
			if (hasThrowable) {
				boolean wantsMinimalOutput = result.getStatus() == ITestResult.SUCCESS;
				if (hasReporterOutput) {
					log("<b><i>" + (wantsMinimalOutput ? "Expected Exception" : "Failure Reason:") + "</b></i>");
				}

				// Getting first line of the stack trace
				String str = Utils.stackTrace(exception, true)[0];
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(str);
				String firstLine = scanner.nextLine();
				log("<Strong><font color=#ff0000>" + firstLine + "</font></strong>");
			}
		}
	}

	/**
	 * After Method
	 * 
	 * @param testResult
	 */

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {

		ITestContext ex = testResult.getTestContext();

		try {
			testName = testResult.getName();
			if (!testResult.isSuccess()) {

				// Print test result to Jenkins Console
				System.out.println();
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				// Make a screenshot for test that failed
				String screenshotName = Common.getCurrentTimeStampString() + testName;
				Reporter.log("<br> <b>Please look to the screenshot - </b>");
				Common.makeScreenshot(driver, screenshotName);
				getShortException(ex.getFailedTests());
			} else {

				// Print test result to Jenkins Console
				System.out.println("TEST PASSED - " + testName + "\n");
			}
			System.out.println("here is test status--------------------" + testResult.getStatus());

			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();

		} catch (Exception throwable) {
			System.out.println("message from tear down" + throwable);
		} finally {
			if (browserName.contains("internet explorer")) {
				killIEServer();

				Common.pause(5);
			}
		}

	}

	public void killIEServer() {
		try {

			Common.pause(5);

			String[] cmd = new String[3];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "taskkill /F /IM iexplore.exe";

			@SuppressWarnings("unused")
			Process process = Runtime.getRuntime().exec(cmd);

			@SuppressWarnings("unused")
			Process process1 = Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */

	public static void log(String msg) {

		System.out.println("======" + msg + "======");
		Reporter.log("<br></br>" + msg);
	}

}
