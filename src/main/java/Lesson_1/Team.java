package Lesson_1;


/**
 * @author Dm.Petrov
 */
public class Team {
    private String name;
    Participants [] team;

    public Team(String name, Participants[] team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public Participants[] getTeam() {
        return team;
    }
    public void showResult(){
        for (Participants participants : team) {
            if(participants.isDid()){
                System.out.println(participants.getName()+ " competition has ended !!!");}
            else {
                System.out.println(participants.getName()+" loose!!!");
            }

        }
    }

    public void showTeam(){
        System.out.println("Team "+name +":");
        for (Participants participants : team) {
            System.out.print(participants.getName()+" ");
        }
        System.out.println();
        }

    }

