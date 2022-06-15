package ru.itmo.courses.climbers.jpa.entity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NonNull
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_group")
@Entity
public class Group extends BaseId {

    public boolean OpenAdd = false;
    private Mountain mountain;
    private Climber[] climbers = new Climber[4]; // было 3

    public Group() {
    }

    public void addGroup(Climber climber) {
        if (!OpenAdd) {
            System.out.println("Stop add");
            return;
        }
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null) {
                climbers[i] = climber;
                return;
            }
        }
        System.out.println("Clamber was added");
    }

}
