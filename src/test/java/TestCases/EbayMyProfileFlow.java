package TestCases;

import BaseClass.BaseTest;
import Pages.HomePage;
import Pages.ShopYourStylePage;
import Utils.ExcelReader;
import Utils.ScreenShotsTaker;
import org.testng.annotations.Test;

public class EbayMyProfileFlow extends BaseTest {

    @Test
    public void shopYourStyle() {

        HomePage homePage = new HomePage(driver);
        ShopYourStylePage shopYourStyle = new ShopYourStylePage(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Data";

        // Initialize ExcelUtils
        ExcelReader excel = new ExcelReader(excelFilePath, sheetName);

        setReportName("shopYourStyle Search Scenario- Test Case 9");
        startTest("shopYourStyle Search Scenario- Test Case 9");
        homePage.shopYourStyle();
        test = extent.createTest("Successfully Navigated to shopYourStyle Page", "Successfully Navigated to shopYourStyle Page");
        String screenshotPath1 = ScreenShotsTaker.takeScreenshot(driver, "SSuccessfully Navigated to shopYourStyle Page");
        test.pass("Successfully Navigated to shopYourStyle Page").addScreenCaptureFromPath(screenshotPath1);
        shopYourStyle.sortProducts();
        test = extent.createTest("System Successfully Changed the Sorting", "System Successfully Changed the Sorting");
        String screenshotPath2 = ScreenShotsTaker.takeScreenshot(driver, "System Successfully Changed the Sorting");
        test.pass("System Successfully Changed the Sorting").addScreenCaptureFromPath(screenshotPath2);

        // Close workbook
        excel.closeWorkbook();
    }


}
