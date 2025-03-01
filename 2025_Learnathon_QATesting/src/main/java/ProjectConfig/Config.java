package ProjectConfig;

import coreComponents.ExcelReader;

public class Config {

    private static final String EXCEL_FILE_PATH = "src/main/resources/Data/TestData.xlsx";

    public static ExcelReader getExcelReader() {
        return new ExcelReader(EXCEL_FILE_PATH);
    }

    public static String getSheetName(Class<?> stepDefinitionClass) {
        return stepDefinitionClass.getSimpleName();
    }
}