package browserTesting.steps;

import browserTesting.Statics;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserSteps {
    WebDriver driver;

    @Given("^I open chrome and launch the application$")
    public void openChromeAndLaunchApplication() {
        //Change chrome driver version value in Statics enum if needed
        System.setProperty( "webdriver.chrome.driver",
                            "drivers/windows/x86/chrome_driver_" + Statics.CHROME_VERSION.getRef() + ".exe");
        driver = new ChromeDriver();
        driver.navigate().to(Statics.WEB_URL.getRef());
    }

    @When("^I select type \"(.*)\"$")
    public void selectType(String type) {
        Select select = new Select(driver.findElement(By.id("type")));
        select.selectByVisibleText(type);
    }

    @When("^I select support plan \"(.*)\"$")
    public void selectSupportPlan(String plan) {
        Select select = new Select(driver.findElement(By.id("support")));
        select.selectByVisibleText(plan);
    }

    @When("^I write monthly duration of \"(.*)\"$")
    public void writeMonthlyDuration(String duration) {
        driver.findElement(By.id("duration")).sendKeys(duration);
    }

    @When("^I click in calculate price button")
    public void clickCalculatePriceButton() {
        driver.findElement(By.id("calculate")).click();
    }

    @Then("^I validate price is \"(.*)\"$")
    public void validatePrice(String price) throws InterruptedException {
        Thread.sleep(5 * 1000);
        Assert.assertEquals(price, driver.findElement(By.id("price")).getText());
    }

    @Then("^I close the browser window$")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

}
