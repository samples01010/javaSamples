package ru.dmitriy.demos.pandemic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "human", indexes = {@Index(columnList = "id", name = "human_id_index")})
public class Human {  //Сущность - человек.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName = ""; //Фамилия.

    @Column(name = "first_name")
    private String firstName = ""; //Имя.

    @Column(name = "age")
    private Integer age = 1; //Возраст.

    @Column(name = "is_dead")
    private Boolean isDead = false; //Погиб.

    @Column(name = "vaccinated")
    private Boolean vaccinated = false; //Вакцинирован.

    @Column(name = "has_immunity")
    private Boolean hasImmunity = false; //Приобрел иммунитет.

    public Human(String lastName, String firstName, Integer age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }
}
