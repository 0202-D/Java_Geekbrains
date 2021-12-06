package Lesson_1;

public class Main {
    public static void main(String[] args) {
        // Сначала сделал для задания с первого по четвертое

        Participants[] participants = {new Robot("T-1000"), new Cat("Tom"), new Human("Ivan")};
        Obstacles[] obstacles = {new RunningRoad(500), new Wall(2), new RunningRoad(1500), new Wall(5)};
        for (Participants participant : participants) {
            for (Obstacles obstacle : obstacles) {
                if (!participant.isDid()) {
                    System.out.println(participant.getName()+" failed!");
                    break;
                }
                obstacle.passingThrough(participant);
            }
          if(participant.isDid()) { System.out.println(participant.getName()+" - the competition has ended!!!");}
            System.out.println();
        }

        // Потом добавил два класса для пятого и шестого

        Participants [] participants1 =  {new Robot("Fedor"), new Cat("Vaska"),
                new Human("Dima"),new Robot("R2D2")};
        Obstacles [] obstacles1 = {new RunningRoad(100), new Wall(1), new RunningRoad(500), new Wall(3)};
        Team team = new Team("Victory",participants1);
        team.showTeam();
        Course course = new Course(obstacles1);
        course.dolt(team);
        team.showResult();
    }
}


