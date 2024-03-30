package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "app_logo")
    private WebElement logo;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement product;

    @FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement product2;

    @FindBy(className = "shopping_cart_link")
    private WebElement choosenProduct;


    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }
    public String getLogoName(){
        return logo.getText();
    }

    public ProductsPage selectProduct() {
        product.click();
        return new ProductsPage(driver);
    }

    public ProductsPage selectProduct2() {
        product2.click();
        return new ProductsPage(driver);
    }

    public ProductsPage buyProduct() {
        choosenProduct.click();
        return new ProductsPage(driver);
    }
}
