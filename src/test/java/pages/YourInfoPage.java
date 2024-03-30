package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourInfoPage extends BasePage {

    @FindBy (id = "first-name")
    private WebElement firstName;

    @FindBy (id = "last-name")
    private WebElement lastName;

    @FindBy (id ="postal-code")
    private WebElement zipCode;

    @FindBy (css = "[type='submit']")
    private WebElement submit;

    @FindBy(id = "finish")
    private WebElement finish;

    @FindBy (className = "complete-header")
    private WebElement complete;


    public YourInfoPage (WebDriver driver){
        super(driver);
    }

    public void setFirstName(String firstname) {

        firstName.sendKeys(firstname);
    }
    public void setLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void setZipCode(String zipcode) {
        zipCode.sendKeys(zipcode);
    }

    public YourInfoPage clickSubmitButton() {
        submit.click();
        return new YourInfoPage(driver);
    }

    public String getColor(){
        return finish.getCssValue("color");
    }

    public YourInfoPage clickFinish() {
        finish.click();
        return new YourInfoPage(driver);
    }

    public String getCompleteText(){
        return complete.getText();
    }







}
