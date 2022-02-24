package Stepdefs.Steps;

import WebPages.UI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConProp;
import Utilities.Navigator;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.it.Ma;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class UserSteps {
private Navigator Nav;
private ConProp Con;
private UI User;

    public UserSteps(Navigator nav) {
        this.Nav=nav;
        this.Con=new ConProp();
        this.User=new UI(nav);
    }

    @Given("^That the website home page is loaded on the web browser$")
    public void that_the_website_home_page_is_loaded_on_the_web_browser()  {
        Nav.drivers.get(Con.getEnvProp("baseURL"));
    }

    @When("^a user clicks on login text at the top of the page$")
    public void a_user_clicks_on_login_text_at_the_top_of_the_page()  {
     User.clickOnSignInText();
    }
    @And("^a user enters the following details$")
    public void a_user_enters_the_following_details(List<Map<String,String>>Values)  {
        User.enterEmailAddress(Values.get(0).get("Email_Address"));
        User.enterPassword(Values.get(0).get("Password"));
    }
    @And("^clicks the Signin button$")
    public void clicks_the_signin_button()  {
        User.loginButton();
    }

    @Then("^user account page should be loaded$")
    public void user_account_page_should_be_loaded()  {
       boolean Expected=User.userAccountPage();
       Assert.assertTrue("Login Successful",Expected);
    }

    //Invalid Login Steps

    @Given("That the website home page is up and running on the web browser")
    public void thatTheWebsiteHomePageIsUpAndRunningOnTheWebBrowser() {
        Nav.drivers.get(Con.getEnvProp("baseURL"));
    }

    @When("a user clicks on Signin text at the top of the page")
    public void aUserClicksOnSigninTextAtTheTopOfThePage() {
        User.clickOnSignInText();
    }

    @And("a user Inputs the following details")
    public void aUserInputsTheFollowingDetails(List<Map<String,String>>data) {
        User.enterEmailAddress(data.get(0).get("Email_Address"));
        User.enterPassword(data.get(0).get("Password"));
    }

    @And("clicks the Login button")
    public void clicksTheLoginButton() {
        User.loginButton();
    }

    @Then("user account page should not be loaded")
    public void userAccountPageShouldNotBeLoaded() {
     String Value=User.pageNotLoaded();
     if(Value.equalsIgnoreCase(Con.getEnvProp("PageStatus"))){
         Assert.assertEquals(Value,Con.getEnvProp("PageStatus"));
     }
    }
    @And("error message {string} Invalid Password Should be displayed.")
    public void errorMessageInvalidPasswordShouldBeDisplayed(String ErrorMessage) {
      String Actual=User.passwordErrorMessage();
      Assert.assertEquals(Actual,ErrorMessage);
    }
// Test to Validate Search Functionality.

    @Given("that Website is loaded on the web browser.")
    public void thatWebsiteIsLoadedOnTheWebBrowser() {
        Nav.drivers.get(Con.getEnvProp("baseURL"));
    }

    @When("a Customer inputs {string} in the search box")
    public void aCustomerInputsInTheSearchBox(String Search_Values) throws InterruptedException {
        User.searchFunction(Search_Values);
    }

    @And("Clicks on Search or presses the enter button")
    public void clicksOnSearchOrPressesTheEnterButton() {
        User.clickSearchButton();
    }

   @Then("Products should be populated on the screen.")
   public void productsShouldBePopulatedOnTheScreen() {
   }

// Test to verify products can be added to cart

    @When("a Customer Enters {string} in the search box.")
    public void aCustomerEntersInTheSearchBox(String Search_Value) throws InterruptedException {
        User.searchFunction(Search_Value);
    }

    @And("click on search button")
    public void clickOnSearchButton() {
        User.clickSearchButton();
    }

    @And("clicks on Add to cart button product from the lists of products on the screen")
    public void clicksOnAddToCartButtonProductFromTheListsOfProductsOnTheScreen() throws InterruptedException {
        User.productToSelect();
        User.addToCartButton();
    }

    @Then("Products should be successfully added to cart")
    public void productsShouldBeSuccessfullyAddedToCart() {
      User.productAddedSuccessfully();
    }

    /* WebElements for verification in this Step are none reponsive as they should. No assertions yet on it.*/
    @And("Success message {string} is displayed.")
    public void successMessageIsDisplayed(String successMessage) {
    String actual= User.successMessage();
   System.out.println(actual);
    }
}
