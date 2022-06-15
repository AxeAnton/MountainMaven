package ru.itmo.courses.climbers.jpa.entity;


public class Application {
    public static void main(String[] args) {
        Mountain mountain1 = new Mountain();
        mountain1.setMountain("Гора1");
        mountain1.setCountry("Россия");
        mountain1.setHeight(122);

        Climber climber = new Climber();
        climber.setNameOfClimber("Петр");
        climber.setAddressOfClimber("Лесной 3");

        Climber climber1 = new Climber();
        climber1.setNameOfClimber("Антон");
        climber1.setAddressOfClimber("Литейный 4");

        Climber climber2 = new Climber();
        climber2.setNameOfClimber("Иван");
        climber2.setAddressOfClimber("Горки 4");


        Group group = new Group();
        group.addToGroup(climber);
        group.addToGroup(climber1);
        group.addToGroup(climber2);
        System.out.println(group.toString());

        Mountain mountain = new Mountain();
        mountain.setHeight(110);
        mountain.setMountain("Эверест");
        mountain.setCountry("Грузия");


        Group group1 = new Group();
        group.addToGroup(climber);
        group.addToGroup(climber1);
        System.out.println(group1.toString());
    }

}
