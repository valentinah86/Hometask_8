package steps;

import com.thoughtworks.gauge.*;
import onlinerby_po_example.po_onliner_pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CatalogTest {

    private WebDriver driver;
    private HomePage homePage;
    private Catalog catalog;
    private ProductPage productPage;
    private ProductsList productsList;
    private Bracket bracket;
    private LoginPage loginPage;

    @BeforeSuite
    public void initDriver (){
        final String PATH = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        ChromeOptions options = new ChromeOptions().setBinary(PATH);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Step("Open Homepage")
    public void openHomepage(){
        homePage=new HomePage(driver);
        homePage.openHomepage();
    }

    @Step("Open Catalog")
    public void openCatalog (){

        homePage.openCatalog();
    }

    @Step("Select category")
    public void selectCategory (){
        catalog = new Catalog(driver);
        catalog.selectCategory();
    }

    @Step("Select subcategory")
    public void selectSubCategory (){
        catalog.selectSubCategory();
    }

    @Step("Open products list")
    public void openProductsList (){
        catalog.openProductsList();
    }

    @Step("Select random product")
    public void selectProduct () throws IOException {
        productsList = new ProductsList(driver);
        productsList.getProduct();
    }

    @Step("Add product to bracket")
    public void addProductToBracket () throws IOException {
        productPage = new ProductPage(driver);
        productPage.addProductToBracket();
        productPage.openBracket();

    }
    @Step("Check bracket")
    public void checkBracket () {

        bracket = new Bracket(driver);
        Assert.assertFalse(bracket.bracketIsEmpty());

    }

    @AfterSuite
    public void closeBrowser (){
        driver.close();
    }

}
