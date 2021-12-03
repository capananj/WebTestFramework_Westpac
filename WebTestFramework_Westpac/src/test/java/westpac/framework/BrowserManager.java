package westpac.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;
import java.util.Map;

public class BrowserManager {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BrowserManager.class);
    private static WebDriver driver;

    public static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase(DriverType.chrome.name())){
            System.setProperty("webdriver.chrome.driver", DirectoryManager.testResourcesDirectory + "/driver/chromedriver.exe");

            Map<String, Object> preferences = new Hashtable<>();
            preferences.put("browser.download.folderList", 2);
            preferences.put("download.default_directory", DirectoryManager.outputDirectory);
            preferences.put("browser.download.manager.showWhenStarting", false);
            preferences.put("browser.download.manager.showAlertOnComplete", false);
            preferences.put("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", preferences);
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().deleteAllCookies();
        }
        log.debug("Driver initialization successful");
        return driver;
    }

}
