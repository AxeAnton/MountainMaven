package ru.itmo.courses.climbers.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.Set;


@Data
@NonNull
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_mountain")
@ToString(callSuper = true)
public class Mountain extends BaseId {
    //    //НОВЫЙ КОД // СТАТЬЯ
//    @ManyToMany
//    @JoinTable(name="mountain",
//            joinColumns = @JoinColumn(name="mountainr_id", referencedColumnName="id"),
//            inverseJoinColumns = @JoinColumn(name="mountain_id", referencedColumnName="id")
//    )
//    private Set<Group> groupSet;
//
//    public Set<Group> getGroup() {
//        return groupSet;
//    }
//
//    public void setBooks(Set<Group> groups) {
//        this.groupSet = groups;
//    }
    //    //кончился новый код


    @Column(name = "mountain_name", length =  20, nullable = false, unique = true)
    private String mountain;

    @Column(name = "country_name", length = 20, nullable = false)
    private String country;

    @Column(name = "mountain_height" ,length = 200, nullable = false)
    private int height;



}

