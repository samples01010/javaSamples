package ru.dmitriy.demos.pandemic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dmitriy.demos.pandemic.entity.Human;
import ru.dmitriy.demos.pandemic.service.db.HumanService;


@SpringBootTest
class PandemicApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(PandemicApplicationTests.class);

    private final HumanService humanService;

    @Autowired
    public PandemicApplicationTests(HumanService humanService) {
        this.humanService = humanService;
    }

    @BeforeAll
    static void beforeAll() {
        log.info("Подготовка перед запуском тестов.");
    }

    @Test
    void contextLoads() {
    }

    @Test
    void createAndDeleteHuman() {

        Human human = humanService.createRandomHuman();

        humanService.save(human);

        Assertions.assertNotNull(humanService.findById(human.getId()));

        humanService.delete(human);

        Assertions.assertNull(humanService.findById(human.getId()));

    }

    @AfterAll
    static void afterAll() {
        log.info("Тестирование закончено.");
    }

}
