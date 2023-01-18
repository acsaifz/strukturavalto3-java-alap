package hu.acsaifz.quiz;

public class OneWordQuestion implements Question{
    private String question;
    private String correctAnswer;
    private Level level;

    public OneWordQuestion(String question, String correctAnswer, Level level) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.level = level;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public int calculatePoints(String... answer) {
        if (answer.length > 1){
            throw new IllegalArgumentException("Only one answer acceptable!");
        }

        return correctAnswer.equals(answer[0]) ? level.getPoint() : 0;
    }
}
