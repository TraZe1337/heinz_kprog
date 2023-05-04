package ListAufgabe;
import java.util.Arrays;
public class Umfuelllisten3 {
  private static int[] behaelter = {3, 2, 3, 2, 3};
  private static int[][] moves = {{0, 1}, {0, 3}, {1, 2}, {2, 4}, {3, 1}, {4, 3}};
  private static int zaehler = 0;

  public static void main(String[] args) {
    for (int i = 0; i < behaelter.length; i++) {
      int[] balls = new int[behaelter.length];
      balls[i] = 3;
      distributeBalls(0, balls);
    }
    System.out.println("Es gab genau " + zaehler + " Fünftupel");
  }

  private static void distributeBalls(int ballIndex, int[] balls) {
    if (ballIndex == 3) {
      zaehler++;
      System.out.println(Arrays.toString(balls));
      return;
    }

    for (int[] move : moves) {
      int fromContainer = move[0];
      int toContainer = move[1];
      int ballsToMove =
          Math.min(balls[fromContainer], behaelter[toContainer] - balls[toContainer]);
      if (ballsToMove > 0) {
        int[] newBalls = balls.clone();
        newBalls[fromContainer] -= ballsToMove;
        newBalls[toContainer] += ballsToMove;
        distributeBalls(ballIndex + 1, newBalls);
      }
    }
  }

}
