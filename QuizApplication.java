package Task4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}
public class QuizApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                List.of("A. London", "B. Paris", "C. Berlin", "D. Rome"), 1));
        questions.add(new Question("Which planet is known as the Red Planet?",
                List.of("A. Earth", "B. Jupiter", "C. Mars", "D. Venus"), 2));
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());

            List<String> options = currentQuestion.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            System.out.print("Your answer (enter A, B, C, or D): ");
            String userAnswer = scanner.nextLine();

            int userAnswerIndex;
            switch (userAnswer.toUpperCase()) {
                case "A":
                    userAnswerIndex = 0;
                    break;
                case "B":
                    userAnswerIndex = 1;
                    break;
                case "C":
                    userAnswerIndex = 2;
                    break;
                case "D":
                    userAnswerIndex = 3;
                    break;
                default:
                    userAnswerIndex = -1;
            }

            if (userAnswerIndex == currentQuestion.getCorrectOptionIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + options.get(currentQuestion.getCorrectOptionIndex()));
            }

            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.size());

        scanner.close();
    }
}
	