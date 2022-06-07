package runner;

import desktop.pages.AuthorizationPage;
import desktop.pages.HomePage;
import desktop.pages.SignInPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import regularExpressions.RegExpressions;

import static constants.Constants.HOME_PAGE_URL;
import static constants.Constants.LOGIN_PAGE_URL;
import static driver.SingletonDriver.getDriverInstance;

public class JUnitTestRunner {

    private static final WebDriver driver = getDriverInstance();
    private final HomePage homePage = new HomePage(driver);
    private final AuthorizationPage authorizationPage = new AuthorizationPage(driver);
    private final SignInPage signInPage = new SignInPage(driver);

    @Before
    public void setup() {
        driver.get(HOME_PAGE_URL);
    }

    @Test
    public void verifyRedirectionToSeparateSignInPageWithEmailNotFoundAlertMessage() {
        homePage.waitVisibilityOfElement(10, homePage.getNavigationBar().getSignInOrJoinButton());
        homePage.getNavigationBar().goToSignInOrJoin();
        authorizationPage.switchToSignInIFrame();
        authorizationPage.enterUnregisteredUserEmail("blah@blah.blah");
        authorizationPage.enterUnregisteredUserPassword("blah-blah");
        authorizationPage.clickUserSignIn();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(driver.getCurrentUrl().contains("signin"))
                    .withFailMessage("User wasn't redirected to Sign In page").isTrue();
            softly.assertThat(signInPage.isSignInErrorDisplayed())
                    .withFailMessage("Sign In error not displayed").isTrue();
        });
    }

    @Test
    public void verifyThatSignInButtonClickable() {
        homePage.waitVisibilityOfElement(10, homePage.getNavigationBar().getSignInOrJoinButton());
        homePage.getNavigationBar().goToSignInOrJoin();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"),
                "Current page should be 'Sign in or join' page");
    }

    @Test
    public void verifyThatOfOrderStatusButtonClickable() {
        homePage.waitVisibilityOfElement(10, homePage.getNavigationBar().getOrderStatusButton());
        homePage.getNavigationBar().goToOrderStatus();
        Assertions.assertTrue(driver.getCurrentUrl().contains("track"),
                "Current page should be 'Order status' page");
    }

    @Test
    public void verifyThatUnauthorisedUserProceedsToLoginAfterClickOnWishlist() {
        homePage.waitVisibilityOfElement(10, homePage.getNavigationBar().getWishlistButton());
        homePage.getNavigationBar().goToWishlist();
        Assertions.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(LOGIN_PAGE_URL),
                "User should be redirected to 'Login' page");
    }

    @AfterAll
    static void quit() {
        driver.quit();
    }
}
