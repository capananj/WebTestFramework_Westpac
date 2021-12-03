package westpac.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WebDriverManager {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(WebDriverManager.class);

    private static ConfigLoader config = ConfigLoader.getInstance();
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static List<String> windowNames;
    private static String url;

    public static void createDriver(){
        driver = BrowserManager.createDriver(config.getProperty("browser"));
        wait = new WebDriverWait(driver, 100);
        windowNames = new ArrayList<String>();
        windowNames.add(0, driver.getWindowHandle());
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWait(){
        return wait;
    }

    public static void goToBuggyCarsWebsite()    {
        driver.get(config.getProperty("buggyCarsUrl"));
        log.debug("Launched URL " + config.getProperty("buggyCarsUrl"));
    }

}
