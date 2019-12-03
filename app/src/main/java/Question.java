public class Question {
    String range;
    int money;
    String question;
    int [] answers;
    int correct;
    boolean isRight;
    boolean questionPicked;

    public Question(String inputRange, int inputMoney, String inputQuestion,
                    int[] inputAnswers, int inputCorrect, boolean inputRight,
                    boolean inputState) {
        this.range = inputRange;
        this.money = inputMoney;
        this.question = inputQuestion;
        this.answers = inputAnswers;
        this.correct = inputCorrect;
        this.isRight = inputRight;
        this.questionPicked = inputState;
    }

    public void printQuestion() {
        System.out.println(question);
        System.out.println(answers[0]);
        System.out.println(answers[1]);
        System.out.println(answers[2]);
        System.out.println(answers[3]);
    }

    public boolean getQuestionPicked() {
        return questionPicked;
    }

    public void setQuestionPicked(boolean p) {
        questionPicked = p;
    }

    public boolean checkAnswer(int inputAnswer) {
        if (correct == inputAnswer) {
            return true;
        } else {
            return false;
        }
    }
}


