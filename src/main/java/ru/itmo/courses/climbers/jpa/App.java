package ru.itmo.courses.climbers.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itmo.courses.climbers.jpa.entity.Climber;
import ru.itmo.courses.climbers.jpa.entity.Group;
import ru.itmo.courses.climbers.jpa.entity.Mountain;

public class App {
    public static void main(String[] args) {
        //создал фабрику
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ormClimbers");

        EntityManager manager = factory.createEntityManager();
        Mountain ararat = new Mountain();
        ararat.setMountain("Арарат");
        ararat.setCountry("Турция");
        ararat.setHeight(10);

        Mountain djomalunga = new Mountain();
        djomalunga.setHeight(123);
        djomalunga.setMountain("Djomalunga");
        djomalunga.setCountry("Гималаи");


        //добавляю инфо об объекте в таблицу
        manager.getTransaction().begin();
        manager.persist(ararat);
        manager.getTransaction().commit();

        manager.getTransaction().begin();
        manager.persist(djomalunga);
        manager.getTransaction().commit();

        // получение по первичному ключу
        Mountain mountainFromDbByPK = manager.find(Mountain.class,1);
        System.out.println("Гора: " + mountainFromDbByPK);

        //обновление уже существующего
        ararat.setHeight(199);

        // обновление инфо в таблице
        manager.getTransaction().begin();
        manager.persist(ararat);
        manager.getTransaction().commit();

        Mountain mountainFromDbByPKafterEdit = manager.find(Mountain.class,1);
        System.out.println("Гора: " + mountainFromDbByPKafterEdit);

        //удаление информации из таблицы
//        manager.getTransaction().begin();
//        manager.remove(ararat);
//        manager.getTransaction().commit();
//
//        Mountain mountainFromDbByPKafterRemove = manager.find(Mountain.class,1);
//        System.out.println("Гора: " + mountainFromDbByPKafterRemove);

        Mountain gora = new Mountain();
        gora.setHeight(123);
        gora.setMountain("goraName");
        gora.setCountry("Гималаи");


        manager.getTransaction().begin();
        manager.persist(gora);
        manager.getTransaction().commit();

        Climber climber = new Climber();
        climber.setAddressOfClimber("Лесной проспект 3");
        climber.setNameOfClimber("Петр");

        manager.getTransaction().begin();
        manager.persist(climber);
        manager.getTransaction().commit();

        Climber climber1 = new Climber();
        climber1.setAddressOfClimber("Лесной проспект 13");
        climber1.setNameOfClimber("Петр1");

        manager.getTransaction().begin();
        manager.persist(climber1);
        manager.getTransaction().commit();

        Climber climber2 = new Climber();
        climber2.setAddressOfClimber("Лесной проспект 213");
        climber2.setNameOfClimber("Петр2");

        manager.getTransaction().begin();
        manager.persist(climber2);
        manager.getTransaction().commit();

        Climber climber3 = new Climber();
        climber3.setAddressOfClimber("Лесной проспект 213");
        climber3.setNameOfClimber("Петр2");

        manager.getTransaction().begin();
        manager.persist(climber3);
        manager.getTransaction().commit();


        Group firstGroup = new Group();
        firstGroup.addToGroup(climber);
        firstGroup.addToGroup(climber1);
        firstGroup.addToGroup(climber2);

        manager.getTransaction().begin();
        manager.persist(firstGroup);
        manager.getTransaction().commit();

    }
}
