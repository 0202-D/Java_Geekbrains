package Lesson_1;

public class RunningRoad implements Obstacles {
    private int length;

    public RunningRoad(int length) {
        this.length = length;
    }

    public void passingThrough(Participants participants) {
        if (participants.getSkillRun() > length && participants.isDid()) {
            participants.run();
        } else {
            participants.setDid(false);
            System.out.println(participants.getName() + " didn't run");
        }
    }
}
