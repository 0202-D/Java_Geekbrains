package Lesson_1;

public class Human implements Participants {
    private String name;
    private int skillRun = 800;
    private int skillJump = 3;
    private boolean did = true;

    public int getSkillRun() {
        return skillRun;
    }

    public boolean isDid() {
        return did;
    }

    public void setDid(boolean did) {
        this.did = did;
    }

    public int getSkillJump() {
        return skillJump;
    }

    public String getName() {
        return name;
    }

    public Human(String name) {
        this.name = name;
    }

    public void run() {

        System.out.println(name + " running!!!");
    }

    public void jump() {

        System.out.println(name + " jumping!");
    }
}

