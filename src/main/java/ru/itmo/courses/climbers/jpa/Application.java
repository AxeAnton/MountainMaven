package ru.itmo.courses.climbers.jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itmo.courses.climbers.jpa.entity.Climber;
import ru.itmo.courses.climbers.jpa.entity.Group;
import ru.itmo.courses.climbers.jpa.entity.Mountain;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ormClimber"); // 1 - "s"

        EntityManager manager = factory.createEntityManager();
        Mountain everest = new Mountain();
        everest.setMountain("Everest ");
        everest.setCountry("Nepal");
        everest.setHeight(8848);

        Mountain chogori = new Mountain();
        chogori.setHeight(8848);
        chogori.setMountain("Chogori");
        chogori.setCountry("Kashmir");

        manager.getTransaction().begin();
        manager.persist(everest);
        manager.getTransaction().commit();

        manager.getTransaction().begin();
        manager.persist(chogori);
        manager.getTransaction().commit();

        Mountain mountainFromDB = manager.find(Mountain.class,1);
        System.out.println("Mountain: " + mountainFromDB);

        everest.setHeight(8849);

        manager.getTransaction().begin();
        manager.persist(everest);
        manager.getTransaction().commit();

        Mountain mountainFromDBchanged = manager.find(Mountain.class,1);
        System.out.println("Mountain: " + mountainFromDBchanged);

        Mountain kanchenjunga = new Mountain();
        kanchenjunga.setHeight(8848);
        kanchenjunga.setMountain("Kanchenjunga");
        kanchenjunga.setCountry("India");


        manager.getTransaction().begin();
        manager.persist(kanchenjunga);
        manager.getTransaction().commit();

        Climber climber = new Climber();
        climber.setClimberAddress("SPb Leteyny st.59");
        climber.setClimberName("Anton");

        manager.getTransaction().begin();
        manager.persist(climber);
        manager.getTransaction().commit();

        Climber climber1 = new Climber();
        climber1.setClimberAddress("SPb Marata 50");
        climber1.setClimberName("Petr");

        manager.getTransaction().begin();
        manager.persist(climber1);
        manager.getTransaction().commit();

        Climber climber2 = new Climber();
        climber2.setClimberAddress("SPb Nevsky st. 10");
        climber2.setClimberName("Ivan");

        manager.getTransaction().begin();
        manager.persist(climber2);
        manager.getTransaction().commit();

        Climber climber3 = new Climber();
        climber3.setClimberAddress("Kolpino Lenina St.");
        climber3.setClimberName("Kosty");

        manager.getTransaction().begin();
        manager.persist(climber3);
        manager.getTransaction().commit();


        Climber climber4 = new Climber();
        climber4.setClimberAddress("SPb Nastavnikov St. 6");
        climber4.setClimberName("Any");

        manager.getTransaction().begin();
        manager.persist(climber4);
        manager.getTransaction().commit();

        Group firstGroup = new Group();
        firstGroup.addGroup(climber);
        firstGroup.addGroup(climber1);
        firstGroup.addGroup(climber2);
        firstGroup.addGroup(climber3);

        manager.getTransaction().begin();
        manager.persist(firstGroup);
        manager.getTransaction().commit();

    }

}
