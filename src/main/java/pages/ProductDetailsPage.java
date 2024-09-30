package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestUtils;

public class ProductDetailsPage {
    private final WebDriver driver;
    private TestUtils testUtils;

    @FindBy(className = "pdp-e-i-head")
    private WebElement productTitle;

    @FindBy(id = "add-cart-button-id")
    private WebElement addToCartButton;

    @FindBy(className = "mess-text")
    private WebElement cartPopupMessage;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        testUtils = new TestUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductTitleDisplayed() {
        return productTitle.isDisplayed();
    }

    public void addToCart() {
        testUtils.click(addToCartButton);
    }

    public String getCartPopupMessageText() {
        return testUtils.getText(cartPopupMessage);
    }
}