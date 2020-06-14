package com.cfs.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cfs.init.SeleniumInit;

public class ServiceRequestIndex extends SeleniumInit {

	@Test(groups = { "ServiceRequestIndex.servicerequest" }, priority = 1)
	public void requestByBOLFlow() throws InterruptedException {

		log("<strong>TC_CFS_01 : To verify user can complete request with Request Type = Devanning and Document Type = BOL.</strong>");

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

		serviceRequestVerification = serviceRequestIndexpage.openServiceRequestScreen();

		log("Verify that Service Request screen is open.");

		if (serviceRequestVerification.serviceRequestScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.openCreateRequestScreen();

		log("Verify that Create Request screen is open.");

		if (serviceRequestVerification.createRequestVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.selectDevanningRequest();

		log("Verify that all the fields/checkbox are display for Devanning request.");

		if (serviceRequestVerification.devanningFieldsVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.enterInformationForRequest();

		serviceRequestVerification = serviceRequestIndexpage.selectVesselVisit();

		log("Verify List of BOL & Containers display for selected Visit.");

		if (serviceRequestVerification.vesselVisitListVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.getBOLDetails();

		serviceRequestVerification = serviceRequestIndexpage.fillCompleteForm();

		serviceRequestVerification = serviceRequestIndexpage.addAdditionalServiceandRemarks();

		log("Verify Service is added successfully.");

		if (serviceRequestVerification.additionalServiceVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.saveCreatedRequest();

		log("Verify Service Request created successfully.");

		if (serviceRequestVerification.requestCreatedverification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		log("Verify mail is received on registered email address.");

		if (serviceRequestVerification.requestCreateEmailVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

	}

	// @Test
	@Test(dependsOnMethods = { "requestByBOLFlow" }, groups = { "ServiceRequestIndex.servicerequest" }, priority = 2)
	public void planPostpaidRequest() throws Exception {

		log("<strong>TC_CFS_02 : To verify user can plan postpaid request with Request Type = Devanning and Document Type = BOL.</strong>");

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

		serviceRequestVerification = serviceRequestIndexpage.openServiceRequestScreen();

		log("Verify that Service Request screen is open.");

		if (serviceRequestVerification.serviceRequestScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.openCreatedRequest();

		log("Verify that Created Request screen is open.");

		if (serviceRequestVerification.createdRequestVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.getCreatedRequestData();

		serviceRequestVerification = serviceRequestIndexpage.changeRequestDataAndPlan();

		log("Verify Service Request planned successfully.");

		if (serviceRequestVerification.requestPlannedVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		log("Verify mail is received on registered email address.");

		if (serviceRequestVerification.requestApprovedEmailVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

	}

	// @Test
	@Test(dependsOnMethods = { "planPostpaidRequest" }, groups = { "ServiceRequestIndex.servicerequest" }, priority = 3)
	public void approvePostpaidRequest() throws Exception {

		log("<strong>TC_CFS_03 : To verify user can approve postpaid request with Request Type = Devanning and Document Type = BOL.</strong>");

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

		serviceRequestVerification = serviceRequestIndexpage.openServiceRequestScreen();

		log("Verify that Service Request screen is open.");

		if (serviceRequestVerification.serviceRequestScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.openPlannedRequest();

		log("Verify that Planned Request screen is open.");

		if (serviceRequestVerification.plannedRequestVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.getCreatedRequestData();

		serviceRequestVerification = serviceRequestIndexpage.changeRequestDataAndApprove();

		log("Verify Service Request approved successfully.");

		if (serviceRequestVerification.requestApprovedVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		log("Verify mail is received on registered email address.");

		if (serviceRequestVerification.requestPlanEmailVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

	}

	// @Test
	@Test(dependsOnGroups = { "ServiceRequestIndex.servicerequest", "JobIndex.jobrequest",
			"JobIndex.finishJob" }, priority = 4)
	public void completedRequest() throws Exception {

		log("<strong>TC_CFS_08 : To verify request comepleted successfully.</strong>");

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

		serviceRequestVerification = serviceRequestIndexpage.openServiceRequestScreen();

		log("Verify that Service Request screen is open.");

		if (serviceRequestVerification.serviceRequestScreenVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.openCompletedRequest();

		log("Verify that Service Request screen is open.");

		if (serviceRequestVerification.completedRequestVerification()) {
			log("<Strong><font color=#008000>Pass</font></strong>");
		} else {
			log("<Strong><font color=#ff0000>Fail</font></strong>");
			Assert.assertTrue(false);
		}

		serviceRequestVerification = serviceRequestIndexpage.getCompletedRequestData();

	}

}