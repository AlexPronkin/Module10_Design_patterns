package desktop.fragments;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractFragment {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="div.user-nav-wrap ul.right-nav.mobile-nav-content [href='/track']")
    private WebElement orderStatusButton;

    @FindBy(css="div.user-nav-wrap ul.right-nav.mobile-nav-content [href='/account/wishlist']")
    private WebElement wishlistButton;

    @FindBy(css="div.user-nav-wrap ul.right-nav.mobile-nav-content [href='/account/login/to/account']")
    private WebElement signInOrJoinButton;

    public void goToOrderStatus(){
        orderStatusButton.click();
    }

    public void goToWishlist(){
        wishlistButton.click();
    }

    public void goToSignInOrJoin(){
        signInOrJoinButton.click();
    }

    public WebElement getOrderStatusButton(){
        return orderStatusButton;
    }

    public WebElement getWishlistButton(){
        return wishlistButton;
    }

    public WebElement getSignInOrJoinButton(){
        return signInOrJoinButton;
    }
}
