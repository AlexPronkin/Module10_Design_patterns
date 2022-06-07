package steps;

import desktop.pages.AuthorizationPage;
import desktop.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import regularExpressions.RegExpressions;

import static constants.Constants.UNREGISTERED_USER_EMAIL;
import static constants.Constants.UNREGISTERED_USER_PASSWORD;
import static driver.SingletonDriver.getDriverInstance;

public class AuthorizationPageStepDefs {

    private static final WebDriver driver = getDriverInstance();
    private final AuthorizationPage authorizationPage = new AuthorizationPage(driver);
    private final SignInPage signInPage = new SignInPage(driver);

    @And("^(?:guest|user) enters incorrect data in the Email and Password fields$")
    public void guestEntersIncorrectDataInTheSignInFields() {
        authorizationPage.switchToSignInIFrame();
        Assertions.assertThat(RegExpressions.isEmailMatchesRegEx(UNREGISTERED_USER_EMAIL))
                .withFailMessage("User Email doesn't match RegEx").isTrue();
        authorizationPage.enterUnregisteredUserEmail(UNREGISTERED_USER_EMAIL);
        authorizationPage.enterUnregisteredUserPassword(UNREGISTERED_USER_PASSWORD);
    }

    @When("^(?:guest|user) confirms entered data$")
    public void guestConfirmsEnteredData() {
        authorizationPage.clickUserSignIn();
    }

    @Then("^(?:guest|user) redirected to separate Sign In page with an error notification$")
    public void verifyRedirectionToSignInWithInfoMessage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(driver.getCurrentUrl().contains("signin"))
                    .withFailMessage("User wasn't redirected to Sign In page").isTrue();
            softly.assertThat(signInPage.isSignInErrorDisplayed())
                    .withFailMessage("Sign In error not displayed").isTrue();
        });
    }
}
