package abstractclasses.fragment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractFragment {

    protected WebDriver driver;
    private WebElement rootElement;

    public AbstractFragment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }
}