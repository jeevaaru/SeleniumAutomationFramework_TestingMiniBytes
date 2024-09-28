package org.jeeva.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.jeeva.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public final class ExcelUtils {
    private ExcelUtils() {
    }

    // try with explorers

    public static List<Map<String,String>> getTestDetails(){

        List<Map<String,String>> list;
        FileInputStream fs = null;

        try {
            fs = new FileInputStream(FrameworkConstants.getExcelPath());
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            String sheetName = "RUNMANAGER";
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum();

            Map<String,String> map = null;
            list = new ArrayList<>();

            for(int i =1; i<=lastrownum;i++){
                map = new HashMap<>();
                for(int j=0;j<lastcolnum;j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            try {
                if(Objects.nonNull(fs)){
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
