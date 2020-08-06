public class Player {

    private String name;
    private int score;
    private int attempts;

    //Todo: write code that reset  attempts to 0 when two

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.attempts = 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore(int points){
        int newScore = this.getScore() + points;
        this.setScore(newScore);
    }
}
