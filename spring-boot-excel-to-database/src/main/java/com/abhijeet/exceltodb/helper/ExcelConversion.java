package com.abhijeet.exceltodb.helper;


import com.abhijeet.exceltodb.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelConversion {


    private static String XLXS_CONYTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public boolean checkFormat(MultipartFile file) {

        String contentType = file.getContentType();
        if (contentType.equalsIgnoreCase(XLXS_CONYTENT_TYPE)) {
            return true;
        }
        return false;
    }

    public List<Student> convertDataToJavaObject(MultipartFile file) {

        List<Student> students = new ArrayList();

        try {
            InputStream inputStream = file.getInputStream();

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row next = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Student student = new Student();

                Iterator<Cell> cellIterator = next.cellIterator();
                int columnNumber = 0;

                while (cellIterator.hasNext()) {
                    Cell values = cellIterator.next();

                    if (columnNumber == 0) {
                        student.setId((int) values.getNumericCellValue());
                    }
                    if (columnNumber == 1) {
                        student.setFirstName(values.getStringCellValue());

                    }
                    if (columnNumber == 2) {
                        student.setLastName(values.getStringCellValue());
                    }
                    if (columnNumber == 3) {
                        student.setMailAddress(values.getStringCellValue());
                    }
                    columnNumber++;

                }
                students.add(student);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;

    }
}
