package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TestAccountRegistrationPage_TC001 extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public void verifyAccountRegistration() {
		logger.info("****Starting TestAccountRegistrationPageTC001****");
		try {
		HomePage homePage = new HomePage(driver);
		logger.info("Clicking on My Account Link..");
		homePage.clickMyAccount();
		logger.info("Clicking on Register Link..");
		homePage.clickRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details..");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		regPage.setTelephone(randomeNumber());
			
		String password=randomeAlphaNumberic();
			
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("Validating Expected Massage..");
		String confmsg = regPage.getMsgConformation(); 
		if (confmsg.equals("Your Account Has Been Created!")) {
            Assert.assertTrue(true);
        }
        else {
        	logger.error("TestAccountRegistrationPageTC001 Failed!");
            logger.debug("Debug logs");
            Assert.assertTrue(false);
            }
		}
		catch (Exception e)
		{
			Assert.fail();
		} 
		logger.info("****Ending TestAccountRegistrationPageTC001****");
	}	

}