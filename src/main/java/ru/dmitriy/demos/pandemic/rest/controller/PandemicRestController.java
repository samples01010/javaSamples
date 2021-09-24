package ru.dmitriy.demos.pandemic.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmitriy.demos.pandemic.service.PandemicService;

@Tag(name = "Контроллер-фасад пандемии.", description = "Служит для получения/обработки глобальных данных, статистики пандемии.")
@RestController
public class PandemicRestController {

    private final PandemicService pandemicService;


    @Autowired
    public PandemicRestController(PandemicService pandemicService) {
        this.pandemicService = pandemicService;
    }

    @Operation(summary = "Получение статуса", description = "Получение статуса пандемии в виде неструктурированной строки по всем людям.")
    @GetMapping(value = "/status")
    public ResponseEntity<String> getStatus() {

        try {
            String status = pandemicService.getStatus();

            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Ошибка получения статуса. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
