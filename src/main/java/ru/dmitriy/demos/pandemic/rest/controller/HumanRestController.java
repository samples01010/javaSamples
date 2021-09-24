package ru.dmitriy.demos.pandemic.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitriy.demos.pandemic.entity.Human;
import ru.dmitriy.demos.pandemic.service.db.HumanService;

import java.util.List;

@Slf4j
@Tag(name = "Контроллер людей(пациентов).", description = "Контроллер управлением людьми(пациентами).")
@RestController
@RequestMapping("human")
@RequiredArgsConstructor
public class HumanRestController {

    private final HumanService humanService;

    @Operation(summary = "Получить всех людей", description = "Отдает всех людей из бд.")
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public ResponseEntity getAll() {

        try {
            List<Human> humans = humanService.getAll();

            return new ResponseEntity<>(humans, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "Добавить", description = "Добавляет человека(пациента).")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody Human human) {

        try {
            //todo Валидация входных данных. (В демо-примере не реализована).

            humanService.save(human);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Ошибка. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "Удалить.(Эндпоинт только для режима разработки)", description = "Удаляет человека(пациента) из системы.")
    @GetMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Integer id) {

        try {
            //todo проверяем, что сервер запущен в режиме разработки (в примере не реализовано).

            Human human = humanService.findById(id);
            if (human == null)
                return new ResponseEntity<>("Человек с таким id не найден. ", HttpStatus.INTERNAL_SERVER_ERROR);

            humanService.delete(human);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Ошибка. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "Удалить всех людей.(Эндпоинт только для режима разработки)", description = "Удаляет всех людей из базы данных.")
    @GetMapping(value = "/deleteAll")
    public ResponseEntity<String> deleteAll() {

        try {
            //todo проверяем, что сервер запущен в режиме разработки (в примере не реализовано).

            humanService.deleteAll();

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Ошибка. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
