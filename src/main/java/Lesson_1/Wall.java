package Lesson_1;

public class Wall implements Obstacles {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void passingThrough(Participants participants) {
        if (participants.getSkillJump() > height && participants.isDid()) {
            participants.jump();
        } else {
            participants.setDid(false);
            System.out.println(participants.getName() + " didn't jump over!!!");
        }
    }


}
