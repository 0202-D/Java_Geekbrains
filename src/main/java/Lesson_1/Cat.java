package Lesson_1;

public class Cat implements Participants {
    private String name;
    private int skillRun = 100;
    private int skillJump = 1;
    boolean did = true;

    public boolean isDid() {
        return did;
    }

    public void setDid(boolean did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public int getSkillRun() {
        return skillRun;
    }

    public int getSkillJump() {
        return skillJump;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " running!");
    }

    public void jump() {
        System.out.println(name + " jumping!");
    }
}
