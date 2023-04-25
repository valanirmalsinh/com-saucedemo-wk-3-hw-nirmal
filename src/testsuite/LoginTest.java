package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //find the Username Textbox element and enter Username "standard_user"
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //find the password Textbox element and enter the password "secret_sauce"
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //find the login button element and Click on it
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //verify the Products Label/Text
        String expectedMessage = "Products";
        String actualMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //click on username
        clickOnElement(By.xpath("//input[@id='user-name']"));
        //enter username
        sendTextToElement(By.id("user-name"),"standard_user");
        //click on password
        clickOnElement(By.xpath("//input[@id='password']"));
        //enter password
        sendTextToElement(By.name("password"),"secret_sauce");
        //click on login button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify that six products are displayed on page
        int expectedmsg = 6;
        List<WebElement> totalproduct = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualMsg = totalproduct.size();
        Assert.assertEquals("6", expectedmsg, actualMsg);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
