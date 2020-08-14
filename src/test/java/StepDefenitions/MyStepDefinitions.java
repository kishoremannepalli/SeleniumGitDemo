package StepDefenitions;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
public class MyStepDefinitions extends Base {

	 @Given("^Brower is intialieze$")
	    public void brower_is_intialieze() throws Throwable {
		 driver=intializeDriver();
	    }

	 @When("^user enters (.+) and (.+) and logs in$")
	 public void user_enters_and_and_logs_in(String username, String password) throws Throwable  {
	    	LoginPage loginPage= new LoginPage(driver);
			loginPage.userId().sendKeys(username);
			loginPage.password().sendKeys(password);
			loginPage.logIn().click();
			
			driver.close();
	    }

	    @Then("^verify the user is succefully logged in$")
	    public void verify_the_user_is_succefully_logged_in() throws Throwable {
	       System.out.println("User is sucssefully logged in");
	    }

	    @And("^Navigated to \"([^\"]*)\" homepage$")
	    public void navigated_to_something_homepage(String strArg1) throws Throwable {
	    	driver.get(strArg1);
	    }

	    @And("^click on loign button to navigate to secure login page$")
	    public void clic_on_loign_button_to_navigate_to_secure_login_page() throws Throwable {
	    	LandingPage lp=new LandingPage(driver);
	    	if(lp.getPopupsize().size()>0)
	    	{
	    		lp.getPopup().click();
	    	}
	    
			//lp.cancelPopUp();	
			lp.login().click();
	    }

}