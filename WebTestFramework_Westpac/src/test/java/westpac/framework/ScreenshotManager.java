package westpac.framework;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotManager extends TestListenerAdapter {

    @Attachment(value = "Failed Log", type = "text/plain")
    public static String saveTextLog(String message)    {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result){
        WebDriver driver = WebDriverManager.getDriver();
        try {
            CaptureScreenshot(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (driver instanceof WebDriver)    {
            attachScreenshot(driver);
            System.out.println(result.getName() + "Screenshot Captured \n");
        }
        System.out.println(result.getName() + "Test Failed \n");
    }

    @Override
    public void onTestSuccess(ITestResult result)    {
        WebDriver driver = WebDriverManager.getDriver();
        try{
            CaptureScreenshot(result);
        } catch (Exception e){
            e.printStackTrace();
        }
        if (driver instanceof WebDriver) {
            attachScreenshot(driver);
            System.out.println(result.getName() + "Screenshot Captured \n");
        }
        System.out.println(result.getName() + "Test Scenario Passed \n");
    }

    @Override
    public void onTestSkipped(ITestResult result)   {
        System.out.println(result.getName() + "Test Skipped \n");
    }

    public void CaptureScreenshot(ITestResult result)  {
        Object obj = result.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
        Date date = new Date();

        WebDriver driver = WebDriverManager.getDriver();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            File destFile = new File("test-output/screenshot/" + result.getName() + "_" + dateFormat.format(date) + ".png");
            FileUtils.copyFile(scrFile, destFile);
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

        }catch (IOException e)  {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Screenshot on Test Suite", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
