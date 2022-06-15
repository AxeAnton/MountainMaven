package ru.itmo.courses.climbers.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@NonNull
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_climber")
public class Climber extends BaseId {

//    //НОВЫЙ КОД    // НОМИНАЦИЯ
//    @OneToOne(optional = false)
//    @JoinColumn(name="id", unique = true, nullable = false, updatable = false)
//    private Group group;
//    //КОнец

    @Column(name = "climber_name",length = 20, nullable = true)
    private String nameOfClimber;

    @Column(name = "climber_adress", length = 100)
    private String addressOfClimber;



}
