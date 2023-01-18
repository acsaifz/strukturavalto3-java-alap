package hu.acsaifz.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question){
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return List.copyOf(questions);
    }

    public int calculateSumPoints(List<String> answers) {
        int sum =0;

        for (int i = 0; i < questions.size(); i++){
            Question actualQuestion = questions.get(i);
            String actualAnswer = answers.get(i);
            sum += actualQuestion.calculatePoints(actualAnswer);
        }

        return sum;
    }

    public Map<Level, Integer> groupByLevel() {
        return questions
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Question::getLevel, Collectors.summingInt(n -> 1)
                        )
                );
    }
}
