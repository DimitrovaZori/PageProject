import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourInfoPage;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends MainDriver {

    LoginPage loginPage;
    ProductsPage productsPage;
    CheckOutPage checkOutPage;
    YourInfoPage infoPage;

    @Test
    public void selectAgain() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
        productsPage.selectProduct();
        productsPage.buyProduct();
        CheckOutPage checkOutPage = new CheckOutPage(driver);

        checkOutPage.removeProduct();
        checkOutPage.continueShop();
        assertEquals(productsPage.getLogoName(), "Swag Labs");
    }


    @Test
    public void selectProducts() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage = new ProductsPage(driver);
        productsPage.selectProduct();
        productsPage.selectProduct2();
        productsPage.buyProduct();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.checkoutProduct();

        assertEquals(productsPage.getLogoName(), "Swag Labs");
    }


    @Test
    public void finishShopping() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage = new ProductsPage(driver);
        productsPage.selectProduct();
        productsPage.selectProduct2();
        productsPage.buyProduct();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.checkoutProduct();

        assertEquals(productsPage.getLogoName(), "Swag Labs");

        YourInfoPage infoPage = new YourInfoPage(driver);
        infoPage.setFirstName("Zori");
        infoPage.setLastName("Dimitova");
        infoPage.setZipCode("9000");
        infoPage.clickSubmitButton();

        assertEquals(infoPage.getColor(), "rgba(19, 35, 34, 1)");
        infoPage.clickFinish();

        assertEquals(infoPage.getCompleteText(), "Thank you for your order!");


    }


}
