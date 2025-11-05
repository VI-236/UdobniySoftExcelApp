package com.VI__236.UdobniySoftExcelApp.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class ExcelServiceImplementation implements ExcelService{

    @Override
    public ArrayList<Integer> ReadFromExcel(String filePath) {
        ArrayList<Integer> unsorted = new ArrayList<>();
        try{
            XSSFWorkbook myBook = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet myExcelSheet = myBook.getSheetAt(0);
            Iterator <Row> rowIterator = myExcelSheet.iterator();

            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    float objFloat = Float.valueOf(cell.toString());
                    Integer obj = (int) objFloat;
                    unsorted.add(obj);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File wasn't find.");
        }
        catch (IOException a){

        }
        return unsorted;
    }
}
