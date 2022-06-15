package ru.itmo.courses.climbers.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@NonNull
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_mountain")
@ToString(callSuper = true)
public class Mountain extends BaseId {

    @Column(name = "mountain_name", length =  25, nullable = false, unique = true)
    private String mountain;

    @Column(name = "country_name", length = 25, nullable = false)
    private String country;

    @Column(name = "mountain_height" ,length = 25, nullable = false) //100
    private int height;



}
