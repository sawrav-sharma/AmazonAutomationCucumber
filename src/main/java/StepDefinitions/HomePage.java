package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Iterator;

public class HomePage {
    WebDriver driver;

    @Given("user is on home page of Amazon website")
    public void userIsOnHomePageOfAmazonWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.in/ref=nav_ya_signin");
    }

    @When("user search the product in the search bar")
    public void userSearchTheProductInTheSearchBar() {
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Fastrack");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
    }

    @Then("products are getting displayed which user searched for")
    public void productsAreGettingDisplayedWhichUserSearchedFor() {
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
    }

    @When("I select {string} quantity from dropdown")
    public void iSelectQuantityFromDropdown(String productQuantity) {
            Iterator var2 = driver.getWindowHandles().iterator();
            while(var2.hasNext()) {
                String winHandle = (String)var2.next();
                driver.switchTo().window(winHandle);
            }
        Select dropdown = new Select(driver.findElement(By.cssSelector("select#quantity")));
        dropdown.selectByVisibleText(productQuantity);
    }
    @And("I click on add to cart button and verify the quantity is {string}")
    public void iClickOnAddToCartButtonAndVerifyTheQuantityIs(String expectedCount) {
        driver.findElement(By.cssSelector("input#add-to-cart-button")).submit();
        Iterator var2 = driver.getWindowHandles().iterator();
        while(var2.hasNext()) {
            String winHandle = (String)var2.next();
            driver.switchTo().window(winHandle);
        }
        String cartCount = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
        Assert.assertEquals("Cart Count do not Match", cartCount, expectedCount);
        driver.quit();
    }
}
