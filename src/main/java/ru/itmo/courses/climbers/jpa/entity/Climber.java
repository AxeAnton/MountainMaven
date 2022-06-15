package ru.itmo.courses.climbers.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NonNull
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_climber")
public class Climber extends BaseId {

    @Column(name = "climber_name",length = 25, nullable = true)
    private String climberName;

    @Column(name = "climber_adress", length = 120)
    private String climberAddress;

}

