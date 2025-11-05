package com.VI__236.UdobniySoftExcelApp.facades;

import com.VI__236.UdobniySoftExcelApp.services.ExcelService;
import com.VI__236.UdobniySoftExcelApp.services.TimSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Facade {
    private static TimSort timSort;
    private static ExcelService excelService;

    @Autowired
    public Facade(TimSort timSort, ExcelService excelService){
        this.timSort = timSort;
        this.excelService = excelService;
    }

    public int excelWorker (String filePath, int returnNumPosition){
        int returnedNum;
        ArrayList<Integer> unsortedList = new ArrayList<>();
        unsortedList = excelService.ReadFromExcel(filePath);

        int[] unsortedIntArray = unsortedList.stream()
                .mapToInt(Integer::intValue) // or i -> i
                .toArray();

        int [] sortedIntArray = timSort.sort(unsortedIntArray);

        return sortedIntArray[returnNumPosition--];
    }
}
