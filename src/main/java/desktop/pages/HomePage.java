package desktop.pages;

import abstractclasses.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import desktop.fragments.NavigationBar;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver);
    }
}
