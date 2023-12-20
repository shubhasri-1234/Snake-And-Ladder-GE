import java.util.Random;

public class SnakeAndLadderPart1 {
    private static final int WINNING_POSITION = 100;
    //UC1
    private int[] playerPositions = {0, 0}; // Player 1 and Player 2 positions
    private int currentPlayer = 0; // 1 for Player 1, 1 for Player 2
    private int diceRollCount = 0;
    //UC2
    private int rollDice() {
        //nextInt(int n) method generates a random integer between 0 (inclusive) and the specified bound n (exclusive)
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    //UC3
    private void playTurn() {
        int diceValue = rollDice();
        diceRollCount++;

        System.out.println("Player " + (currentPlayer) + " rolled a " + diceValue);

        int option = rollDice(); // Simulating options using another dice roll

        switch (option % 3) {
            case 0:
                System.out.println("No Play. Player stays in the same position.");
                break;
            case 1:
                System.out.println("Ladder! Player moves ahead by " + diceValue + " positions.");
                playerPositions[currentPlayer] += diceValue;
                break;
            case 2:
                System.out.println("Snake! Player moves behind by " + diceValue + " positions.");
                playerPositions[currentPlayer] -= diceValue;
                break;
        }
        //reset to 0

        if (playerPositions[currentPlayer] < 0) {
            playerPositions[currentPlayer] = 0;
        }

        System.out.println("Player " + (currentPlayer) + " is now at position " + playerPositions[currentPlayer]);
        System.out.println();

        //UC4
        if (playerPositions[currentPlayer] == WINNING_POSITION) {
            System.out.println("Player " + (currentPlayer) + " wins!");
            //UC6
            System.out.println("Dice was rolled " + diceRollCount + " times.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SnakeAndLadderPart1 game = new SnakeAndLadderPart1();

        while (true) {
            game.playTurn();
        }
    }
}
