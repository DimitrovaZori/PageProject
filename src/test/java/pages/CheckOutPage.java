package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement remove;

    @FindBy (id ="continue-shopping")
    private WebElement shoppingAgain;

    @FindBy (id = "checkout")
    private WebElement checkout;

    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    public CheckOutPage removeProduct() {
        remove.click();
        return new CheckOutPage(driver);
    }

    public CheckOutPage continueShop() {
        shoppingAgain.click();
        return new CheckOutPage(driver);
    }

    public CheckOutPage checkoutProduct() {
        checkout.click();
        return new CheckOutPage(driver);
    }

}
