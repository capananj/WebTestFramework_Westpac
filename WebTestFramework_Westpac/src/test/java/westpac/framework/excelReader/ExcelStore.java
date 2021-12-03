package westpac.framework.excelReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelStore {

    private List<String> columns = new ArrayList<String>();
    private Map<String, List<Row>> mapOfRows = new HashMap<String, List<Row>>();
    private Sheet sheet;

    public ExcelStore(Sheet sheet) {
        this.sheet = sheet;
        setColums();
        setRows();
    }

    public static String getCellValueAsString(Cell cell)    {
        String strCellValue = "";
        if (cell != null){
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    strCellValue = cell.toString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
                        strCellValue = dateFormat.format(cell.getDateCellValue());
                    } else {
                        Double value = cell.getNumericCellValue();
                        Long longValue = value.longValue();
                        strCellValue = new String(longValue.toString());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    strCellValue = "";
                    break;
            }
        }
        return strCellValue;
    }

    public void setColums() {
        Row row = this.sheet.getRow(0);
        row.forEach(cell -> {
            this.columns.add(cell.getStringCellValue());
        });
    }

    private void setRows() {
        this.sheet.forEach( row -> {
            String testName = row.getCell(1).getStringCellValue();
            List<Row> rows = this.mapOfRows.get(testName);
            if (rows == null){
                rows = new ArrayList<Row>();
            }
            rows.add(row);
            this.mapOfRows.put(testName, rows);
        });
    }

    public Object[][] filterDatasets(String testName){
        List<Row> rows = this.mapOfRows.get(testName);
        Object[][] datasets = null;
        //log.info("Row : " + rows);
        if (!rows.isEmpty()) {
            //log.info("Row ----------------------------------------: " + rows);
            datasets = new Object[rows.size()][1];
            for (int i = 0; i < rows.size(); i++)   {
                Row row = rows.get(i);
                Map<String, String> rowdatamap = new HashMap<String, String>();

                for (int col = 0; col < this.columns.size(); col++){
                    String key = this.columns.get(col);
                    rowdatamap.put(key, getCellValueAsString(row.getCell(col)));
                }
                datasets [i][0] = rowdatamap;
            }
        }
        return datasets;
    }
}
