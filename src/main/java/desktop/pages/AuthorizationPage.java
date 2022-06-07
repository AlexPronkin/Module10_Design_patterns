package desktop.pages;

import abstractclasses.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='signin-iframe']")
    private static WebElement signInIFrame;

    @FindBy(css="#signin-embedded-layout #ap_email")
    private static WebElement userEmailField;

    @FindBy(css="#signin-embedded-layout #ap_password")
    private WebElement userPasswordField;

    @FindBy(css="#signInSubmit")
    private WebElement userSignInSubmitButton;

    @FindBy(css="##ap_customer_name")
    private WebElement guestNameField;

    @FindBy(css="#ap_register_form #ap_email")
    private WebElement guestEmailField;

    @FindBy(css="#ap_register_form #ap_password")
    private WebElement guestPasswordField;

    @FindBy(css="#continue")
    private WebElement guestRegisterSubmitButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public void switchToSignInIFrame(){
        new AuthorizationPage(driver.switchTo().frame(signInIFrame));
    }

    public void enterUnregisteredUserEmail(String email) {
        waitVisibilityOfElement(10, userEmailField);
        userEmailField.sendKeys(email);
    }

    public static WebElement getUserEmailField() {
        return userEmailField;
    }

    public void enterUnregisteredUserPassword(String password){
        waitVisibilityOfElement(10, userPasswordField);
        userPasswordField.sendKeys(password);
    }

    public void enterGuestName (String name) {
        guestNameField.sendKeys(name);
    }

    public void enterGuestEmail (String email) {
        guestEmailField.sendKeys(email);
    }

    public void enterGuestPassword (String password) {
        guestPasswordField.sendKeys(password);
    }

    public void clickUserSignIn(){
        waitVisibilityOfElement(10, userSignInSubmitButton);
        userSignInSubmitButton.click();
    }

    public void clickGuestRegister(){
        guestRegisterSubmitButton.click();
    }
}