package steps;

import desktop.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static constants.Constants.HOME_PAGE_URL;
import static driver.SingletonDriver.getDriverInstance;

public class NavigationBarStepDefs {

    private static final WebDriver driver = getDriverInstance();
    private final HomePage homePage = new HomePage(driver);

    @When("^(?:guest|user) opens Home Page$")
    public void openHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    @When("^(?:guest|user) clicks on Sign in or Join button in Navigation Bar$")
    public void userClicksOnSignInJoinButtonInNavigatasdionBar() {
        homePage.getNavigationBar().goToSignInOrJoin();
    }

    @When("^(?:guest|user) clicks on Order Status button in Navigation Bar$")
    public void clickOnOrderStatusButtonInNavigationBar() {
        homePage.getNavigationBar().goToOrderStatus();
    }

    @When("^(?:guest|user) clicks on Wishlist button in Navigation Bar$")
    public void userClicksOnWishlistButtonInNavigationBar() {
        homePage.getNavigationBar().goToWishlist();
    }

    @Then("current URL contains {string} word")
    public void currentURLContainsWord(String word) {
        Assertions.assertTrue(driver.getCurrentUrl().contains(word),
                "Current page should contain " + word + " word");
    }
}
