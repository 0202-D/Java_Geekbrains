package Lesson_1;

/**
 * @author Dm.Petrov
 */
public class Course {
        private   Obstacles [] obstacles;

    public Course(Obstacles[] obstacles) {
        this.obstacles = obstacles;
    }

    public void dolt (Team team) {
            for (int i =0;i<team.getTeam().length;i++) {
                for (Obstacles obstacle : obstacles) {
                    if (!team.getTeam()[i].isDid()) {
                        System.out.println(team.getTeam()[i].getName()+" failed!");
                        break;
                    }
                    obstacle.passingThrough(team.getTeam()[i]);
                }
                if(team.getTeam()[i].isDid()) { System.out.println(team.getTeam()[i].getName()+" - the competition has ended!!!");}
                System.out.println();
            }
                
            }
        }

