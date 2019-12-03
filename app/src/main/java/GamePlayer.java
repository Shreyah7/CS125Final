
import java.util.Scanner;

public class GamePlayer {
    String name;
    boolean gameState;
    int money;

    public GamePlayer() {
        name = "";
        gameState = false;
        money = 0;
    }

    public void setName() {
        Scanner scan = new Scanner (System.in);
        //System.out.println("Enter you name");
        name = scan.nextLine();
    }

    public String getName() {
        return name;
    }

    public boolean getGameState() {
        return gameState;
    }

    public void setGameState(boolean state) {
        gameState = state;
    }

    public int getWinnings() {
        return money;
    }

    public void setWinnings(int m) {
        money += m;
    }
}


