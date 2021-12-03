package westpac.framework.excelReader;

import westpac.framework.BaseTest;
import westpac.framework.ConfigLoader;
import westpac.framework.DirectoryManager;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtil extends BaseTest {

    private static ConfigLoader config = ConfigLoader.getInstance();
    public static String TESTDATA_SHEET_PATH = DirectoryManager.testResourcesDirectory + config.getProperty("testdatafile").toLowerCase();
    private ExcelReader excelReader = ExcelReader.reader();


    @DataProvider(name = "getEditProfileInformation")
    public Object[][] editProfileInformation(Method name) {
        Object data[][] = excelReader.getRowDataMap(TESTDATA_SHEET_PATH,"editProfileInformation",name.getName());
        return data;
    }

    @DataProvider(name = "getLogin")
    public Object[][] login(Method name) {
        Object data[][] = excelReader.getRowDataMap(TESTDATA_SHEET_PATH,"login",name.getName());
        return data;
    }

    @DataProvider(name = "getRegister")
    public Object[][] register(Method name) {
        Object data[][] = excelReader.getRowDataMap(TESTDATA_SHEET_PATH,"register",name.getName());
        return data;
    }

    @DataProvider(name = "getViewOverallRatings")
    public Object[][] viewOverallRatings(Method name) {
        Object data[][] = excelReader.getRowDataMap(TESTDATA_SHEET_PATH, "viewOverallRatings", name.getName());
        return data;
    }

    @DataProvider(name = "getVoteCarRatings")
    public Object[][] voteCarRatings(Method name) {
        Object data[][] = excelReader.getRowDataMap(TESTDATA_SHEET_PATH, "voteCarRatings", name.getName());
        return data;
    }
}

