package TestCases;

import BaseClass.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Utils.ExcelReader;
import Utils.ScreenShotsTaker;
import org.testng.annotations.Test;

public class EbayAddtoWatchlistFlow extends BaseTest {


    @Test
    public void searchAndBuySamsungPhone() {

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Data";

        // Initialize ExcelUtils
        ExcelReader excel = new ExcelReader(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(1, 1); // Row 1, Column 1

        // Step 1: Search for Samsung phone
        homePage.searchFor(mobileBrand);
        setReportName("Add To Watch list Scenario- Test Case 2");
        startTest("Add To Watch list Scenario- Test Case 2");
        test = extent.createTest("Successful Searched", "System Successfully searched the item and get the result");
        String screenshotPath1 = ScreenShotsTaker.takeScreenshot(driver, "SuccessfulSearch");
        test.pass("System Successfully searched the item and get the result").addScreenCaptureFromPath(screenshotPath1);

        // Step 2: Select the first product
        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "System Successfully searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsTaker.takeScreenshot(driver, "FirstResultTaken");
        test.pass("System Successfully searched the item and select  the first result").addScreenCaptureFromPath(screenshotPath2);

        // Write data back to the Excel file
        excel.setCellData(1, 2, "Samsung Selected", excelFilePath);

        // Step 3: Proceed to addToWatchList
        productPage.addToWatchList();
        test = extent.createTest("Successful Add to watch list", "System Successfully  Add the item to watch list");
        String screenshotPath3 = ScreenShotsTaker.takeScreenshot(driver, "AddToWatchList");
        test.pass("System Successfully  Add the item to watch list").addScreenCaptureFromPath(screenshotPath3);

        // Close workbook
        excel.closeWorkbook();
    }


}
