package Lesson_1;

public class Robot implements Participants {
    private String name;
    private int skillRun = 100000;
    private int skillJump = 10;
    boolean did = true;

    public Robot(String name) {
        this.name = name;
    }

    public boolean isDid() {
        return did;
    }

    public int getSkillRun() {
        return skillRun;
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

    public void run() {
        System.out.println(name + " running!");
    }

    public void jump() {
        System.out.println(name + " jumping!");
    }
}
