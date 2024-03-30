import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest extends MainDriver {

    LoginPage loginPage;
    ProductsPage productsPage;
    CheckOutPage checkOutPage;

    @Test
    public void testSuccessfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
        assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Test
    public void testNotValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        String message = loginPage.getError();

        assertEquals(message,"Epic sadface: Username is required");

    }

    @Test
    public void chooseAgain() {
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

}
