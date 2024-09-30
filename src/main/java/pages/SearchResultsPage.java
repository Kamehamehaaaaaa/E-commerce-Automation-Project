package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestUtils;

import java.time.Duration;

public class SearchResultsPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    private TestUtils testUtils;

    @FindBy(id = "inputValEnter")
    private WebElement searchBox;

    @FindBy(className = "search-result-txt-section")
    private WebElement searchResultsSection;

    @FindBy(xpath = "//div[contains(@data-filtername,'Size_s')]//i[contains(@class,'sd-icon sd-icon-plus')]")
    private WebElement sizeFilterExpandBtn;

    @FindBy(xpath = "//button[@data-filtername='Size_s']")
    private WebElement sizeFilterViewMoreBtn;

    @FindBy(xpath = "//label[@for='Size_s-L']")
    private WebElement sizeLFilter;

    @FindBy(xpath = "//a[@data-key='Size_s|Size']")
    private WebElement sizeFilterAppliedKey;

    @FindBy(className = "sort-selected")
    private WebElement sortDropdown;

    @FindBy(xpath = "//li[normalize-space()='Price High To Low']")
    private WebElement highToLowSortOption;

    @FindBy(className = "product-tuple-image")
    private WebElement firstProduct;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        testUtils = new TestUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean areSearchResultsDisplayed() {
        return searchResultsSection.isDisplayed();
    }

    public String getSearchResultsText() {
        return testUtils.getText(searchResultsSection);
    }

    public void applySizeFilter() {
        testUtils.scrollAndClickElement(sizeFilterExpandBtn);
        testUtils.scrollAndClickElement(sizeFilterViewMoreBtn);
        testUtils.scrollAndClickElement(sizeLFilter);
    }

    public void waitForFilterToBeLoaded() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> sizeFilterAppliedKey.isDisplayed());
    }

    public void sortByPriceHighToLow() {
        testUtils.click(sortDropdown);
        testUtils.click(highToLowSortOption);
    }

    public void openFirstProduct() {
        testUtils.click(firstProduct);
    }
}