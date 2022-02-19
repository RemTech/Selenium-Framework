package WebPages;

import org.openqa.selenium.By;
import utilities.SeleniumDriver;

public class UI_Functions {
    // This class is for the WebElements on the WebPages.
    private SeleniumDriver Selenium;
    private By Sign_in_Linktext= By.xpath("//a[starts-with(@class,'login')]");
    private By Email_loginTextBox=By.cssSelector("#email");
    private By PasswordTextBox=By.xpath("//input[starts-with(@type,'password')]");
    private  By Login_Button=By.xpath("//button[starts-with(@id,'SubmitLogin')]");
    private By Search_TextBox=By.xpath("//input[starts-with(@name,'search_query')]");
    private  By Search_Button=By.xpath("//button[contains(@name,'submit_search')]");
    private By Product_to_Click=By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img");
    private By AddToCart_button=By.xpath("//button[contains(@class,'exclusive')]");
    private By EditRecordButton=By.xpath("//a[starts-with(@title,'Information')]");
    private By FirstnameTextBox=By.xpath("//input[contains(@name,'firstname')]");
    private By LastNameTextBox=By.xpath("//input[contains(@name,'lastname')]");
    private By EmailTextBox=By.xpath("//input[contains(@data-validate,'isEmail')]");
    public UI_Functions(SeleniumDriver selenium){
        this.Selenium=selenium;
    }
    public
}
