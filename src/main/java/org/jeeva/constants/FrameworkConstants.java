package org.jeeva.constants;

import org.jeeva.enums.ConfigProperties;
import org.jeeva.utils.PropertyUtils;

public class FrameworkConstants {
    private FrameworkConstants(){

    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH+ "/config/config.properties";
    private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentReportFilePath = "";




    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
            return extentReportFilePath;
    }
    private static String createReportPath() throws Exception {
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH+ System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH+ "index.html";
        }
    }

    public static String getExcelPath(){
        return EXCELPATH;
    }


}
