package abstractclasses.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.SingletonDriver.getDriverInstance;

public abstract class AbstractPage {

    protected final WebDriver driver;
    private String pageUrl;
    private String pageUrlPattern;

    public AbstractPage(WebDriver driver) {
        this.driver = getDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void waitVisibilityOfElement(int timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String setPageUrlPattern(String pageUrlPattern) {
        return this.pageUrlPattern = pageUrlPattern;
    }

    public String getPageUrlPattern() {
        return pageUrlPattern;
    }
}
