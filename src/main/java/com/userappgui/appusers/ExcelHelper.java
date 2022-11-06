package com.userappgui.appusers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.userappgui.appusers.Repositories.CityRepository;
import com.userappgui.appusers.models.City;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;


public class ExcelHelper {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void saveDataExcel () throws FileNotFoundException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Города");
        // кол-во строк
        int rownum = 0;

        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // загаловки таблицы
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("ID Города");
        cell.setCellStyle(style);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Название города");
        cell.setCellStyle(style);

        List<City> cities = CityRepository.getAll();

        for (City city: cities) {
            rownum++;
            row = sheet.createRow(rownum);


            // ID column (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(city.getId());
            // City name (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(city.getNameCity());
        }

        File dir = new File("/home/ladonin/Документы/temp");

        File file = new File(dir, "cities.xls");

        FileOutputStream outFile = new FileOutputStream(file);
        try {
            workbook.write(outFile);
        } catch (IOException e) {
            System.out.println("Ошибка созданя файла");
        }
        System.out.println("Created file: " + file.getAbsolutePath());
    }
}
