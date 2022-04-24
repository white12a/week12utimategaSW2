package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.linkText("Sign In"));
        verifyText("Welcome Back!",By.xpath("//h1[@class='page__heading']"),"Welcome Message Validation");
    }
    @Test
    public void verifyTheErrorMessage() {
        clickOnElement(By.linkText("Sign In"));
        sendTextToElement(By.id("user[email]"),"123@gmail.com");
        sendTextToElement(By.id("user[password]"),"12345");
        clickOnElement(By.xpath("//input[@type='submit']"));
        verifyText("Invalid email or password.",By.className("form-error__list-item"),"Invalid error msg not displayed");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
