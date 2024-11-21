package myclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SnakeAndLadders {
    final static int WINPOINT = 100;

    static Map<Integer, Integer> snake = new HashMap<>();
    static Map <Integer, Integer> ladder = new HashMap<>();

    {
        snake.put(99,54);
        snake.put(70,55);
        snake.put(52,42);
        snake.put(25,2);
        snake.put(95,72);

        ladder.put(6,25);
        ladder.put(11,40);
        ladder.put(60,85);
        ladder.put(46,90);
        ladder.put(17,69);
    }

    public static int rollDice() {
        int rand = (int) (Math.random() * 6) + 1;
        return rand;
    }

    public int calculatePlayerPosition(int playerPos, int diceValue) {
        playerPos = playerPos + diceValue;

        if(playerPos > WINPOINT) {
            playerPos = playerPos - diceValue;
        } else if (snake.containsKey(playerPos)) {
            playerPos = snake.get(playerPos);
        }

        return playerPos;
    }

    public void SnakeLadderPlay() {
        Scanner sb = new Scanner(System.in);
        int player1 = 0, player2 = 0;
        int currentPlayer = 1;
        int diceValue = 0;
        String str = "";

        do {
            System.out.println(currentPlayer == 1 ?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
            System.out.println("Press r to roll Dice");
            diceValue = rollDice();
            str = sb.next();

            if(currentPlayer == 1) {
                player1 = calculatePlayerPosition(player1, diceValue);

                if(player1 == WINPOINT) {
                    System.out.println("Player 1 wins");
                    break;
                }

                currentPlayer = 2;
            } else {
                player2 = calculatePlayerPosition(player2, diceValue);

                if(player2 == WINPOINT) {
                    System.out.println("Player 2 wins");
                    break;
                }

                currentPlayer = 1;
            }
            System.out.println("Player 1 current pos = "+ player1);
            System.out.println("Player 2 current pos = "+ player2);
            System.out.println("Dice value = "+ diceValue);

        } while(str.equals("r"));

        sb.close();
    }
}

class SnakeAndLaddersTest {
    public static void main(String[] args) {
        SnakeAndLadders obj = new SnakeAndLadders();
        obj.SnakeLadderPlay();
    }
}