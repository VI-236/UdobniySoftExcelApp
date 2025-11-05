package com.VI__236.UdobniySoftExcelApp.controllers;

import com.VI__236.UdobniySoftExcelApp.facades.Facade;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TO DO
//Привентить сюда свагер и можно пушить.
@Tag(name = "ExcelAppController", description = "Данынй контроллер получает на входе путь к " +
"локальному файлу .xlsx (полный путь к файлу) и целое число.")
@RestController
public class ExcelAppController {
    private Facade facade;

    @Autowired
    public ExcelAppController(Facade facade){
        this.facade = facade;
    }

    @GetMapping("/excel_worker")
    public int excelApp(@RequestParam("FilePath") String filePath,
                                @RequestParam("returnNumPosition") int returnNumPosition){

        return facade.excelWorker(filePath, returnNumPosition);
    }
}
