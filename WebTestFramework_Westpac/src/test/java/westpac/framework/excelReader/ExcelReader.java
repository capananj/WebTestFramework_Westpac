package westpac.framework.excelReader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DataProviderUtil.class);

    private static ExcelReader instance;
    Map<String, Workbook> mapOfWorkbooks = new HashMap<String, Workbook>();

    public ExcelReader(){
    }

    public static ExcelReader reader()  {
        if (instance == null)   {
            instance = new ExcelReader();
        }
        return instance;
    }

    public Sheet getSheet(String inputFile, String sheetName)  {
        log.debug("Opened test data file " + inputFile);
        Workbook workbook = mapOfWorkbooks.get(inputFile);
        if (workbook == null){
            try {
                FileInputStream fis = new FileInputStream(inputFile);
                workbook = new HSSFWorkbook(fis);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Sheet sheet = workbook.getSheet(sheetName);
        mapOfWorkbooks.put(inputFile, workbook);
        return sheet;
    }

    public Object[][] getRowDataMap(String inputFile, String sheetName, String testName){
        Object[][] dataset = null;
        Sheet sheet = getSheet(inputFile, sheetName);
        if (sheet != null){
            dataset = new ExcelStore(sheet).filterDatasets(testName);
        }
        return dataset;
    }

    public void close() {
        if (!this.mapOfWorkbooks.isEmpty()) {
            this.mapOfWorkbooks.forEach((key, value) -> {
                try{
                    value.close();
                }catch (Exception exc) {
                    exc.printStackTrace();
                }
            });
        }
        this.mapOfWorkbooks.clear();
    }



}
