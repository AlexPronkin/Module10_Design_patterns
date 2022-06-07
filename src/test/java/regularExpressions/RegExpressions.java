package regularExpressions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static driver.SingletonDriver.getDriverInstance;

public class RegExpressions {

    private static final WebDriver driver = getDriverInstance();
    private static final String STREET_NUMBER_REGEX = "\\d{1,4}";
    private static final String STREET_NAME_REGEX = "\\w+ [Dd]rive";
    private static final String SUITE_NUMBER_REGEX = "(?<=[Ss]uite )(\\d+)(?=,)";
    private static final String CITY_STATE_AND_POSTAL_CODE_REGEX = "\\w+, [A-Z]{2} \\d+";
    private static final String COUNTRY_NAME_REGEX = "\\w+$";
    private static final String EMAIL_REGEX = "^[^.,_\\-][A-Za-z0-9+_.-]{0,63}@[A-Za-z0-9.-]+[^-_.,]$";
    private static final String MASTERCARD_REGEX = "^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|" +
            "[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$";
    private static final String IP_REGEX = "^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";

    @Test
    public void printAddressElements() {
        driver.get("https://www.epam.com/about/who-we-are/contact");
        String fullAddressAsText = driver.findElement(By.xpath("//div[contains(@class,'text-ui')]//span")).getText();
        System.out.println(getListOfAddressElements(fullAddressAsText));
        driver.quit();
    }

    public static boolean isEmailMatchesRegEx(String email) {
        return email.trim().matches(EMAIL_REGEX);
    }

    public static boolean isIPAddressMatchesRegEx(String ip) {
        return ip.trim().matches(IP_REGEX);
    }

    public static boolean isBankCardNumberMatchesRegEx(String cardNumber) {
        return cardNumber.replaceAll("[^0-9]", "").matches(MASTERCARD_REGEX);
    }

    private static List<String> getListOfAddressElements(String fullAddress) {
        List<String> addressElements = new ArrayList<>();
        addressElements.add("Street number - " + getStreetNumber(fullAddress));
        addressElements.add("Street name - " + getStreetName(fullAddress));
        addressElements.add("Suite number - " + getSuiteNumber(fullAddress));
        addressElements.add("City and state - " + getCityStateAndPostalCode(fullAddress));
        addressElements.add("Country - " + getCountry(fullAddress));
        return addressElements;
    }

    private static String getStreetNumber(String fullAddress) {
        return getMatcher(fullAddress, STREET_NUMBER_REGEX);
    }

    private static String getStreetName(String fullAddress) {
        return getMatcher(fullAddress, STREET_NAME_REGEX);
    }

    private static String getSuiteNumber(String fullAddress) {
        return getMatcher(fullAddress, SUITE_NUMBER_REGEX);
    }

    private static String getCountry(String fullAddress) {
        return getMatcher(fullAddress, COUNTRY_NAME_REGEX);
    }

    private static String getCityStateAndPostalCode(String fullAddress) {
        return getMatcher(fullAddress, CITY_STATE_AND_POSTAL_CODE_REGEX);
    }

    private static String getMatcher(String text, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        return matcher.group();
    }
}