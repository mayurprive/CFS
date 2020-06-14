package com.cfs.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cfs.init.SeleniumInit;

public class LoginIndex extends SeleniumInit {

	@Test
	public void loginSuccessful() throws Exception {

		log("<strong>TC_CFS_01 : To verify login functionality with valid credentials.</strong>");

		loginVerification = loginIndexpage.openURL();

		loginVerification = loginIndexpage.login(SeleniumInit.userName, SeleniumInit.password, SeleniumInit.language,
				SeleniumInit.site);

		log("Verify that User Login successfully.");

		if (loginVerification.dashboardVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

	}

	@Test
	public void logoutSuccessful() throws Exception {

		log("<strong>TC_CFS_02 : To verify user can logout successfully from system.</strong>");

		loginVerification = loginIndexpage.openURL();

		loginVerification = loginIndexpage.login(SeleniumInit.userName, SeleniumInit.password, SeleniumInit.language,
				SeleniumInit.site);

		log("Verify that User Login successfully.");

		if (loginVerification.dashboardVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		loginVerification = loginIndexpage.logout();

		log("Verify that User logout successfully.");

		if (loginVerification.logoutVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

	}
}