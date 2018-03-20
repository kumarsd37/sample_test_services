package com.rev.etl.faker.utils;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelPOIUtils {
    public static String getCellName(Cell cell)
    {
        System.out.println(cell);
        return cell.getRichStringCellValue().toString();
    }
}
