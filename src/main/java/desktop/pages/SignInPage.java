package desktop.pages;

import abstractclasses.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'alert-container')]")
    private WebElement signInError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInErrorDisplayed() {
        return signInError.isDisplayed();
    }
}
