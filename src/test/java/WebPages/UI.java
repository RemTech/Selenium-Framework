package WebPages;

import Utilities.Navigator;
import jdk.nashorn.internal.ir.IfNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UI {
    private By Sign_in_Linktext = By.xpath("//a[starts-with(@class,'login')]");
    private By Email_loginTextBox = By.cssSelector("#email");
    private By PasswordTextBox = By.xpath("//input[starts-with(@type,'password')]");
    private By Login_Button = By.xpath("//button[starts-with(@id,'SubmitLogin')]");
    private By UserAccountPage = By.xpath("//h1[starts-with(@class,'page-heading')]");
    private By Search_TextBox = By.xpath("//input[starts-with(@name,'search_query')]");
    private By InvalidPasswordErrorText = By.xpath("//p[text()='There is 1 error']");
    private By Search_Button = By.xpath("//button[contains(@name,'submit_search')]");
    private By Product_to_Click = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img");
    private By AddToCart_button = By.xpath("//button[contains(@class,'exclusive')]");
    private By SuccessfullyAdded = By.xpath("//div[starts-with(@class,'layer_cart_product col-xs-12 col-md-6')]");
    private By SuccessMessage = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > h2 > span.ajax_cart_product_txt");
    private By EditRecordButton = By.xpath("//a[starts-with(@title,'Information')]");
    private By FirstnameTextBox = By.xpath("//input[contains(@name,'firstname')]");
    private By LastNameTextBox = By.xpath("//input[contains(@name,'lastname')]");
    private By EmailTextBox = By.xpath("//input[contains(@data-validate,'isEmail')]");
    private By DaysDropBox = By.xpath("//select[contains(@name,'days')]");
    private By DaysDropBoxValues = By.xpath("//option[contains(@value,'')]");
    private By MonthsDropBox = By.xpath("//select[contains(@name,'months')]");
    private By MonthsDropBoxValues = By.xpath("//option[contains(@value,'')]");
    private By YearDropBox = By.xpath("//select[contains(@name,'years')]");
    private By YearsDropBoxValues = By.xpath("//option[contains(@value,'')]");
    private By CurrentPasswordTextBox = By.xpath("//input[starts-with(@name,'old_passwd')]");
    private By SuccessMessageElement = By.xpath("//*[@id='center_column']/div/p/text()");
    private Navigator Nav;

    public UI(Navigator nav) {
        this.Nav = nav;
    }

    public void clickOnSignInText() {
        Nav.drivers.findElement(Sign_in_Linktext).click();
    }

    public void enterEmailAddress(String email) {
        Nav.drivers.findElement(Email_loginTextBox).clear();
        Nav.drivers.findElement(Email_loginTextBox).sendKeys(email);
    }

    public void enterPassword(String Password) {
        Nav.drivers.findElement(PasswordTextBox).clear();
        Nav.drivers.findElement(PasswordTextBox).sendKeys(Password);
    }

    public void loginButton() {
        Nav.drivers.findElement(Login_Button).click();
    }

    public boolean userAccountPage() {
        boolean Status = Nav.drivers.findElement(UserAccountPage).isDisplayed();
        return Status;
    }

    public String pageNotLoaded() {
        String Actual = Nav.drivers.getTitle();
        return Actual;
    }

    public String passwordErrorMessage() {
        String pageMessage = Nav.drivers.findElement(InvalidPasswordErrorText).getText();
        return pageMessage;
    }

    public void searchFunction(String search) throws InterruptedException {
        Thread.sleep(4000);
        Nav.drivers.findElement(Search_TextBox).clear();
        Nav.drivers.findElement(Search_TextBox).sendKeys(search);
    }

    public void clickSearchButton() {
        Nav.drivers.findElement(Search_Button).click();
    }

    public void productToSelect() throws InterruptedException {
        Thread.sleep(2000);
        Nav.drivers.findElement(Product_to_Click).click();
    }

    public void addToCartButton() {
        Nav.drivers.findElement(AddToCart_button).click();
    }

    public boolean productAddedSuccessfully() {
        boolean Status = Nav.drivers.findElement(SuccessfullyAdded).isDisplayed();
        return Status;
    }

    public String successMessage() {
        String Actual= Nav.drivers.findElement(SuccessMessage).getText();
        return Actual;
    }
}
