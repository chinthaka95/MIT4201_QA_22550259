package Pages;

import BaseClass.BaseTest;
import Utils.ScreenShotsTaker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends BaseTest {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(xpath = "//*[@id=\"vl-flyout-nav\"]/ul/li[11]/a") // Deals Button
    WebElement deals;

    @FindBy(xpath = "//*[@id=\"gf-l\"]/li[1]/a") // AboutEbay
    WebElement aboutEbay;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[2]/content-section-list/svelte-retag/div/content-section[1]/svelte-retag/section/div/div/div/h2") // words aboutEbay button
    WebElement wordsAboutEbay;

    // Constructor to initialize elements
    public DealsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public String dealsInfoAssertion() {
        // Click On Deals
        deals.click();
        test = extent.createTest("Successful Navigate to Global Deals Page", "Successful Navigate to Global Deals Page");
        String screenshotPath1 = ScreenShotsTaker.takeScreenshot(driver, "GlobalDealsPage");
        test.pass("System Successfully Navigate to Global Deals Page").addScreenCaptureFromPath(screenshotPath1);
        // Scroll to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        test = extent.createTest("Successfully Navigate to Bottom Of the Page", "Successfully Navigate to Bottom Of the Page");
        String screenshotPath2 = ScreenShotsTaker.takeScreenshot(driver, "PageBottom");
        test.pass("System Successfully Navigate to Bottom Of the Page").addScreenCaptureFromPath(screenshotPath2);
        // Click On About E-Bay
        aboutEbay.click();
        test = extent.createTest("Successfully Navigate to About Page", "Successfully Navigate to About Page");
        String screenshotPath3 = ScreenShotsTaker.takeScreenshot(driver, "AboutPage");
        test.pass("System Successfully Navigate to About Page").addScreenCaptureFromPath(screenshotPath3);
        String aboutEbay = wordsAboutEbay.getText();
        return aboutEbay;


    }
}