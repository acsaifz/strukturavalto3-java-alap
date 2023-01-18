package hu.acsaifz.quiz;

import java.util.List;

public class MultipleChoiceQuestion implements Question{
    private String question;
    private Level level;
    List<String> options;
    List<String> correctAnswers;

    public MultipleChoiceQuestion(String question, List<String> options, List<String> correctAnswers, Level level) {
        validate(options, correctAnswers);

        this.question = question;
        this.level = level;
        this.options = options;
        this.correctAnswers = correctAnswers;
    }

    private void validate(List<String> options, List<String> correctAnswers) {
        if (options.size() < 2){
            throw new IllegalArgumentException("Answers size must be at least 2!");
        }

        if (!options.containsAll(correctAnswers)){
            throw new CorrectAnswersMismatchException("Answers must contain all correct answers!");
        }
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
        List<String> answers = List.of(answer);
        if (!options.containsAll(answers)){
            throw new IllegalArgumentException("Answers are not in options!");
        }

        if (answer.length == correctAnswers.size() && correctAnswers.containsAll(answers)){
            return level.getPoint();
        } else {
            return 0;
        }
    }
}
