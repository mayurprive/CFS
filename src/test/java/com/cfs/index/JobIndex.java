package com.cfs.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cfs.init.Common;
import com.cfs.init.SeleniumInit;
import com.cfs.verification.JobVerification;

public class JobIndex extends SeleniumInit {

	// @Test
	@Test(groups = { "JobIndex.jobrequest" }, dependsOnGroups = { "ServiceRequestIndex.servicerequest" }, priority = 1)
	public void viewCreatedJob() throws InterruptedException {

		log("<strong>TC_CFS_04 : To verify user can view the created job list after successfully approved request.</strong>");

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

		jobVerification = jobIndexpage.openJobScreen();

		log("Verify that Job screen is open.");

		if (jobVerification.jobScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		jobVerification = jobIndexpage.filterSSRNumber();

		log("Verify that filter jobs in grid.");

		if (jobVerification.jobListVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		for (int i = 1; i <= JobVerification.numberOfJobs; i++) {

			jobVerification = jobIndexpage.selectAndViewJob(i);

			log("Verify that user can view the jobs.");

			if (jobVerification.viewJobScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

			jobVerification = jobIndexpage.createdJobData();

		}

	}

	// @Test
	@Test(groups = { "JobIndex.jobrequest" }, dependsOnGroups = {
			"ServiceRequestIndex.servicerequest" }, dependsOnMethods = { "viewCreatedJob" }, priority = 2)
	public void planCreatedJob() {

		log("<strong>TC_CFS_05 : To verify user plan view the created job.</strong>");

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

		jobVerification = jobIndexpage.openJobScreen();

		log("Verify that Job screen is open.");

		if (jobVerification.jobScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		jobVerification = jobIndexpage.filterSSRNumber();

		log("Verify that filter jobs in grid.");

		if (jobVerification.jobListVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		for (int i = 1; i <= JobVerification.numberOfJobs; i++) {

			System.err.println(i);

			jobVerification = jobIndexpage.goToList();

			jobVerification = jobIndexpage.selectAndViewJob(1);

			log("Verify that filter jobs in grid.");

			if (jobVerification.viewJobScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

			jobVerification = jobIndexpage.editJobTimingsandDockingBay();

			jobVerification = jobIndexpage.addLocationsAndResources();

			jobVerification = jobIndexpage.confirmPlannedJob();

			log("Verify Job Request confirmed successfully.");

			if (jobVerification.jobPlannedVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

		}

	}

	@Test(groups = { "JobIndex.jobrequest" }, dependsOnGroups = {
			"ServiceRequestIndex.servicerequest" }, dependsOnMethods = { "planCreatedJob" }, priority = 3)
	public void confirmContainerArrival() {

		log("<strong>TC_CFS_06 : To verify user can add container arrival information at gate.</strong>");

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

		// gateVerification = gateIndexpage.findListOfJobs();

		gateVerification = gateIndexpage.openGateScreen();

		Common.pause(3);

		gateVerification = gateIndexpage.openContainerArrivalScreen();

		log("Verify that Container Arrival screen is open.");

		if (gateVerification.containerArrivalScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		gateVerification = gateIndexpage.enterAndConfirmContainerNumber();

		log("Verify that Container Arrival confirmed successfully.");

		if (gateVerification.successContainerArrivalVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

	}

	// @Test

	@Test(groups = { "JobIndex.finishJob" }, dependsOnGroups = { "ServiceRequestIndex.servicerequest",
			"JobIndex.jobrequest" }, dependsOnMethods = { "confirmContainerArrival" }, priority = 4)

	public void completeDevanning() throws InterruptedException {

		log("<strong>TC_CFS_07 : To verify user complete the job.</strong>");

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

		jobVerification = jobIndexpage.openJobScreen();

		log("Verify that Job screen is open.");

		if (jobVerification.jobScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		jobVerification = jobIndexpage.filterSSRNumberwithOpr();

		log("Verify that filter jobs in grid.");

		if (jobVerification.jobListVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		for (int i = 1; i <= JobVerification.numberOfJobs; i++) {

			jobVerification = jobIndexpage.selectAndViewJob(i);

			log("Verify that user can view the jobs.");

			if (jobVerification.viewJobScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

			jobVerification = jobIndexpage.createdJobData();

			jobVerification = jobIndexpage.viewStartJobTiming();

			log("Verify that user can see the Cut Seal screen.");

			if (jobVerification.viewCutSealScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

			jobVerification = jobIndexpage.enterCutSealAndSave();

			jobVerification = jobIndexpage.goToDevanningSection();

			log("Verify that user can see the devaning screen.");

			if (jobVerification.viewDevanScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

			jobVerification = jobIndexpage.enterDevanningDetail();

			jobVerification = jobIndexpage.enterReceivedQuantity();

			log("Verify that user can see the apply seal screen.");

			if (jobVerification.applySealScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

			jobVerification = jobIndexpage.enterApplySealAndSave();

			log("Verify that user can see the complete job screen.");

			if (jobVerification.completeJobScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}

			jobVerification = jobIndexpage.getJobDetails();

			jobVerification = jobIndexpage.completeJob();

			/*log("Verify that user can see the job summary screen.");

			if (jobVerification.jobSummaryScreenVerification()) {
				log("<Strong><font color=#008000>Pass</font></strong>");
			} else {
				log("<Strong><font color=#ff0000>Fail</font></strong>");
				Assert.assertTrue(false);
			}*/

		}

	}

}
