package steps;

import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.Step;
import onlinerby_po_example.po_onliner_pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @Step("Open Homepage")
    public void openHomepage(){
        homePage=new HomePage(driver);
        homePage.openHomepage();
    }

    @Step("Open Login page")
    public void openLoginPage (){
        homePage.openLoginPage();
    }

    @Step("Login")
    public void login (){
        loginPage = new LoginPage(driver);
        loginPage.login("hamster_bb","5598109");
        Assert.assertTrue(homePage.isUserSignedUp());
    }

}
