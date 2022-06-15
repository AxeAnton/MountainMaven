package ru.itmo.courses.climbers.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@NonNull
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_group")
@Entity
public class Group extends BaseId {
    public Group() {
    }

    //    //НОВЫЙ КОД // СТАТЬЯ
//@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
//private Set<Mountain> mountainSet;
//
//    public Set<Mountain> getMountain() {
//        return mountainSet;
//    }
//
//    public void setUsers(Set<Mountain> mountainSet) {
//        this.mountainSet = mountainSet;
//    }

//    //кончился новый код

  //  @Column(name = "empty_place")
    public boolean isOpentoAdd = false;

    //@Column(name = "mountain_name_for_group", length = 20, nullable = false)
    private Mountain mountain;

    //@Column(name = "climber_list")
    private Climber[] climbers = new Climber[3];

//    public Group(boolean isOpentoAdd, Mountain mountain) {
//        this.isOpentoAdd = isOpentoAdd;
//        this.mountain = mountain;
//    }


    public void addToGroup(Climber climber) {
        if (!isOpentoAdd) {
            System.out.println("Набор закрыт");
            return;
        }
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null) {
                climbers[i] = climber;
                return;
            }
        }
        System.out.println("Альпинист добавлен");
    }

}
