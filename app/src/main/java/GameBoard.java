import android.widget.Button;

import java.io.File;
import java.util.Scanner;

public class GameBoard {
    Question[][] gameBoard = new Question[5][5];
    GamePlayer player1 = new GamePlayer();
    GamePlayer player2 = new GamePlayer();
    int currentAnswer;
    int row;
    int column;
    int questionCount = 25;

    public GameBoard(Question[][] inputBoard, GamePlayer input1, GamePlayer input2,
                     int inputAnswer, int inputRow, int inputColumn) {
        this.gameBoard = inputBoard;
        this.player1 = input1;
        this.player2 = input2;
        this.currentAnswer = inputAnswer;
        this.row = inputRow;
        this.column = inputColumn;
    }

    public void inputBoard(String[] args) {
        //how to read file i made??
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                File input = new File(args[j]);

               /*
               Scanner scan = new Scanner(input);

               while(scan.hasNext()) {
                   String range = scan.nextLine();
                   scan.nextLine();
                   int money = scan.nextInt();
                   String question = scan.nextLine();
                   scan.nextLine();

                   int[] answers = new int[4];
                   answers[0] = scan.nextInt();
                   scan.nextLine();
                   answers[1] = scan.nextInt();
                   scan.nextLine();
                   answers[2] = scan.nextInt();
                   scan.nextLine();
                   answers[3] = scan.nextInt();
                   scan.nextLine();
                   int correct = scan.nextInt();
                   boolean isRight = false;
                   boolean questionState = false;

                   Question addQ = new Question(range, money, question, answers,
                           correct, isRight, questionState);
                   gameBoard[i][j] = addQ;
                }

                */

                //dont think this fills right => GET HELP
            }
        }
    }


    public void displayBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (i == 0) {
                    System.out.print(gameBoard[i][j].range + "     ");
                } else if (!(gameBoard[i][j]).getQuestionPicked()) {
                    System.out.print(gameBoard[i][j].money + "     ");
                } else {
                    System.out.print("****");
                }
                System.out.println();
            }
        }
    }

    public void askQuestion() {
        if (player1.getGameState()) {
            System.out.println(player1.getName() + ", choose a range!");
        } else if (player2.getGameState()) {
            System.out.println(player2.getName() + ", choose a range!");
        }
        //create 5 buttons => one for every range
        //create 5 buttons => one for every money

       /*
       Button range1 = findViewById();
       Button range2 = findViewById();
       Button range3 = findViewById();
       Button range4 = findViewById();
       Button range5 = findViewById();

       range1.setOnClickListener(v -> {
           row = 0;
       });
       range2.setOnClickListener(v -> {
           row = 1;
       });
       range3.setOnClickListener(v -> {
           row = 2;
       });
       range4.setOnClickListener(v -> {
           row = 3;
       });
       range5.setOnClickListener(v -> {
           row = 4;
       });

       Button money1 = findViewById();
       Button money2 = findViewById();
       Button money3 = findViewById();
       Button money4 = findViewById();
       Button money5 = findViewById();

       money1.setOnClickListener(v -> {
           column = 0;
       });
       money2.setOnClickListener(v -> {
           column = 1;
       });
       money3.setOnClickListener(v -> {
           column = 2;
       });
       money4.setOnClickListener(v -> {
           column = 3;
       });
       money5.setOnClickListener(v -> {
           column = 4;
       });

       */
        if (gameBoard[row][column].getQuestionPicked()) {
            System.out.println("That was already picked, ");
            askQuestion();
        }
        gameBoard[row][column].printQuestion();
        gameBoard[row][column].setQuestionPicked(true);
        questionCount--;
        System.out.println("Please enter your answer");
        Scanner scan = new Scanner(System.in);
        currentAnswer = scan.nextInt();
    }

    public void checkAnswer() {
        if (currentAnswer == gameBoard[row][column].correct) {
            System.out.println("Congrats! You got it right");
            player1.setWinnings(gameBoard[row][column].money);
            player1.setGameState(false);
            player2.setGameState(true);
            System.out.println("Player 1 has $" + player1.getWinnings());
            System.out.println("Player 2 has $" + player2.getWinnings());
        } else if (currentAnswer == gameBoard[row][column].answers[0] || currentAnswer == gameBoard[row][column].answers[1]
                || currentAnswer == gameBoard[row][column].answers[2] || currentAnswer == gameBoard[row][column].answers[3]) {
            System.out.println("Sorry! You were wrong... ");
            player1.setGameState(false);
            player2.setGameState(true);
            System.out.println("Player 1 has $" + player1.getWinnings());
            System.out.println("Player 2 has $" + player2.getWinnings());
        } else {
            System.out.println("Please enter a valid answer");
            //Should I scan and set currentAnswer
        }
    }

    public void oneRound() {
        displayBoard();
        askQuestion();
        checkAnswer();
    }

    public void play() {
        System.out.println("Welcome to The Price Is Right");
        //print rules
        System.out.println("Player 1, please enter your name");
        player1.setName();
        System.out.println("Player 2, please enter your name");
        player2.setName();
        player1.setGameState(true);
        while(questionCount != 0) {
            oneRound();
        }
    }

}

