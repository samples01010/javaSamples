package ru.dmitriy.demos.pandemic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "human", indexes = {@Index(columnList = "id", name = "human_id_index")})
public class Human {  //Сущность - человек.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull( message = "Фамилия не должна быть пустой.")
    @Size(min =1, max = 128, message = "Длина фамилии должна быть от 1 до 128 символов.")
    @Column(name = "last_name")
    private String lastName = ""; //Фамилия.

    @NotNull( message = "Имя не должно быть пустым.")
    @Size(min =1, max = 128, message = "Длина имени должна быть от 1 до 128 символов.")
    @Column(name = "first_name")
    private String firstName = ""; //Имя.

    @NotNull( message = "Возраст не должен быть пустым.")
    @Min(value = 0, message = "Возраст должен быть не менее 0.")
    @Max(value = 256, message = "Возраст должен быть не более 256.")
    @Column(name = "age")
    private Integer age = 1; //Возраст.

    @NotNull( message = "Поле isDead не должно быть пустым.")
    @Column(name = "is_dead")
    private Boolean isDead = false; //Погиб.

    @NotNull( message = "Поле vaccinated не должно быть пустым.")
    @Column(name = "vaccinated")
    private Boolean vaccinated = false; //Вакцинирован.

    @NotNull( message = "Поле hasImmunity не должно быть пустым.")
    @Column(name = "has_immunity")
    private Boolean hasImmunity = false; //Приобрел иммунитет.

    public Human(String lastName, String firstName, Integer age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }
}
