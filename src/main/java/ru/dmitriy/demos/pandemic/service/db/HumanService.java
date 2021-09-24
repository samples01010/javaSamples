package ru.dmitriy.demos.pandemic.service.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dmitriy.demos.pandemic.entity.Human;
import ru.dmitriy.demos.pandemic.repository.HumanRepository;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;

    /**
     * Создать новую сущность Human со случайными данными.
     *
     * @return созданный human. Либо null, если возникла ошибка.
     */
    public Human createRandomHuman() {

        try {

            Random random = new Random();
            String lastName = "lastName" + String.format("%010d", random.nextInt(1000));
            String firstName = "firstName" + String.format("%010d", random.nextInt(1000));
            int age = random.nextInt(99) + 1;

            return new Human(lastName, firstName, age);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void save(Human human) {
        humanRepository.save(human);
    }

    public void delete(Human human) {
        humanRepository.delete(human);
    }

    public Human findById(Integer id) {
        return humanRepository.findById(id);
    }

    public List<Human> getAll() {
        return humanRepository.findAll();
    }

    public void deleteAll() {
        humanRepository.deleteAll();
    }

}
