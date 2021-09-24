package ru.dmitriy.demos.pandemic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitriy.demos.pandemic.entity.Human;

@Repository
public interface HumanRepository extends JpaRepository<Human, String> {

    Human findById(Integer id);

}