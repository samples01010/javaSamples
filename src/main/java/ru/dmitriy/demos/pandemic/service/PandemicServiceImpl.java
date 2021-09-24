package ru.dmitriy.demos.pandemic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dmitriy.demos.pandemic.entity.Human;
import ru.dmitriy.demos.pandemic.service.db.HumanService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PandemicServiceImpl implements PandemicService {

    private final HumanService humanService;

    @Override
    public String getStatus() {

        StringBuilder result = new StringBuilder();

        List<Human> allHumans = humanService.getAll();

        if (allHumans == null || allHumans.isEmpty())
            return "Ошибка: таблица с людьми пуста.";

        int countDeath = 0;
        int countRecovered = 0;
        int countVaccinated = 0;

        for (Human human : allHumans) {
            if (human.getIsDead())
                countDeath++;
            if (human.getHasImmunity())
                countRecovered++;
            if (human.getVaccinated())
                countVaccinated++;
        }

        result.append("Всего человек на начало эпидемии: ")
                .append(allHumans.size())
                .append(" Погибло: ")
                .append(countDeath)
                .append(" Выздоровело: ")
                .append(countRecovered)
                .append(" Вакцинировано: ")
                .append(countVaccinated);

        return result.toString();
    }


}
