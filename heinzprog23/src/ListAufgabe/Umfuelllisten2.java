package ListAufgabe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Umfuelllisten2 {
  private static int[][] transfers = {{0, 1}, {0, 3}, {1, 2}, {2, 4}, {3, 1}, {4, 3}};
  private static int[] sizes = {3, 2, 3, 2, 3};
  private static int[] balls = {3, 0, 0, 0, 0};
  private static Set<String> ways = new HashSet<>();

  public static void main(String[] args) {
    transfer(1);

    ways.add(Arrays.toString(new int[]{3, 0, 0, 0, 0}));
    ways.add(Arrays.toString(new int[]{0, 0, 0, 0, 3}));
    for (String way : ways) {
      System.out.println("" + way);
    }
    System.out.println("Es gab genau " + ways.size() + " Fünftupel");
  }

  private static void transfer(int ballIndex) {
    if (ballIndex > 3) {
      ways.add(Arrays.toString(balls));
      return;
    }

    for (int[] transfer : transfers) {
      int from = transfer[0];
      int to = transfer[1];
      if (balls[from] > 0 && balls[to] < sizes[to] && (balls[to] < 2 || (balls[to] == 2 && balls[from] == 1))) {
        balls[from]--;
        balls[to]++;
        transfer(ballIndex + 1);
        balls[from]++;
        balls[to]--;
      }
    }
  }
}
