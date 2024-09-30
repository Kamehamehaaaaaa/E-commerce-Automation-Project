package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SearchResultsPage;
import pages.ProductDetailsPage;
import dataProviders.ConfigFileReader;
import utilities.TestUtils;

import java.time.Duration;

public class SearchPageTests {
    private static final Logger log = LoggerFactory.getLogger(SearchPageTests.class);
    private WebDriver driver;
    private SearchResultsPage searchResultsPage;
    private ProductDetailsPage productDetailsPage;
    private ConfigFileReader configFileReader;
    private TestUtils testUtils;

    @BeforeClass
    public void setUp() {
        configFileReader= new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
        searchResultsPage = new SearchResultsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        testUtils = new TestUtils(driver);
    }

    @Test(priority = 1)
    public void testSearchFunctionality() {
        driver.get(configFileReader.getApplicationUrl());
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(), "Search results are not displayed");
        Assert.assertTrue(searchResultsPage.getSearchResultsText().contains("tshirt"), "Search results contain search term");
    }

    @Test(priority = 2)
    public void testProductFiltering() {
        searchResultsPage.applySizeFilter();
        searchResultsPage.waitForFilterToBeLoaded();
        Assert.assertTrue(driver.getCurrentUrl().contains("q=Size_s%3AL%7C"), "URL does not reflect applied filter");
    }

    @Test(priority = 3)
    public void testSortingFunctionality() {
        searchResultsPage.sortByPriceHighToLow();
        Assert.assertTrue(driver.getCurrentUrl().contains("sort=phtl"), "URL does not reflect sorting option");
    }

    @Test(priority = 4)
    public void testProductDetailsPage() {
        searchResultsPage.openFirstProduct();
        testUtils.switchToNewWindow();
        Assert.assertTrue(productDetailsPage.isProductTitleDisplayed(), "Product title is not displayed on details page");
    }

    @Test(priority = 5)
    public void testItemAddedToCart() {
        productDetailsPage.addToCart();
        Assert.assertTrue(productDetailsPage.getCartPopupMessageText().contains("added to your cart"), "Cart popup is not displayed after adding product");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}