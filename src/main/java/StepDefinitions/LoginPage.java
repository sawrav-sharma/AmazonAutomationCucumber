package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LoginPage {
    WebDriver driver;
    String url ="https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fref%3Dnav_ya_signin&openid." +
            "identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=" +
            "http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";

    @Given("user is on sign in page of Amazon website")
    public void userIsOnSignInPageOfAmazonWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("user enters mobileNumber {string}")
    public void userEntersMobileNumber(String mobileNo) {
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(mobileNo);
    }

    @Then("user clicks on continue button")
    public void userClicksOnContinueButton() {
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        driver.findElement(By.xpath("//div[@class='a-section a-spacing-large']//input[@id='ap_password']")).sendKeys(password);
    }

    @Then("clicks on Sign In Submit button and user is navigated to the home page and page contains {string}")
    public void clicksOnSignInSubmitButtonAndUserIsNavigatedToTheHomePageAndPageContains(String expectedUser) {
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
        String getUser = driver.findElement(By.xpath("//div[@class='nav-line-1-container']//span[@class='nav-line-1 nav-progressive-content']")).getText();
        Assert.assertEquals("Cart Count do not Match", getUser, expectedUser);
        WebElement profileSpace = driver.findElement(By.xpath("//a[@id='nav-item-signout']//span[contains(text(),'Sign Out')]"));
        //Instantiating Actions class
        Actions actions = new Actions(driver);
        //Hovering on main menu
        actions.moveToElement(profileSpace);
        actions.click();
        driver.quit();
    }
}
