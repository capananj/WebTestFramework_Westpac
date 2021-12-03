package westpac.framework;

import org.testng.annotations.*;
import westpac.framework.excelReader.ExcelReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Method;

@Listeners(ScreenshotManager.class)
public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    public String methodName;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetup() {
        cleanDir();
    }

   @BeforeMethod(alwaysRun = true)
    public void openBrowser(Method method) throws Exception{
        WebDriverManager.createDriver();
        log.info("Test Name" + method.getName());
        methodName = method.getName();
        WebDriverManager.goToBuggyCarsWebsite();
    }


    @AfterSuite(alwaysRun = true)
    public void closeExcel()    {
        log.info("Closed Excel");
        ExcelReader reader = new ExcelReader();
        reader.close();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        WebDriverManager.getDriver().close();
    }


    public void cleanDir()  {
        File screenshotDir = new File(DirectoryManager.screenshotDirectory);
        File logDir = new File(DirectoryManager.logsDirectory);
        File outputDir = new File(DirectoryManager.outputDirectory);
        File reportDir = new File(DirectoryManager.outputDirectory + "report");

        if (screenshotDir.exists()) {
            for (File file : screenshotDir.listFiles()) {
                file.delete();
            }
            screenshotDir.delete();
            log.info("Screenshot folder has been cleaned up");
        }else{

        }

        if (logDir.exists())    {
            for (File file : logDir.listFiles()) {
                file.delete();
            }
            logDir.delete();
            log.info("Log folder has been cleaned up");
        }

        if (outputDir.exists())    {
            for (File file : outputDir.listFiles()) {
                file.delete();
            }
            outputDir.delete();
            log.info("Output folder has been cleaned up");
        }

        if (reportDir.exists())    {
            for (File file : reportDir.listFiles()) {
                file.delete();
            }
            reportDir.delete();
            log.info("Report folder has been cleaned up");
        }
        log.info("Clean up complete");
    }



}
