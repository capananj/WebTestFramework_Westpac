package westpac.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

public class WebDriverActions {

    public static final Logger log = LoggerFactory.getLogger(WebDriverActions.class);

    private static ConfigLoader config = ConfigLoader.getInstance();

    public WebDriver driver;
    private WebDriverWait wait;

    public WebDriverActions() {
        driver = WebDriverManager.getDriver();
        wait = WebDriverManager.getWait();
    }


    public WebDriverWait waitFor()  {
        return wait;
    }

    public FluentWait<WebDriver> fluentWait()   {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(WebDriverManager.getDriver())
                .withTimeout(Duration.ofMinutes(1))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NotFoundException.class, StaleElementReferenceException.class);
        return fluentWait;
    }


    public void click(WebElement elem)  {
        try {
            fluentWait().until(ExpectedConditions.elementToBeClickable(elem));
            elem.click();
            log.debug("Click element " + elem);
        }catch (Exception e){
            throw new TestException(String.format("Element is not clickable: [%s]", elem));
        }
    }

    public void enterText(WebElement elem, String value)    {
        try {
            waitFor().until(ExpectedConditions.elementToBeClickable(elem));
            elem.clear();;
            elem.sendKeys(value);
        }catch (Exception e)    {
            log.debug(String.format("Element %s does not exist ", elem));
        }
    }


    public void selectDropdown(WebElement elem, String value)   {
        try{
            waitFor().until(ExpectedConditions.elementToBeClickable(elem));
            elem.sendKeys(value);
        }catch (Exception e)    {
            log.debug(String.format("Element %s does not exist ", elem));
        }
    }
}
