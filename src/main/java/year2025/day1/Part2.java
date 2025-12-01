package year2025.day1;

import java.util.Scanner;

public class Part2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long totalZeroes = 0;
    int position = 50;

    while (sc.hasNext()) {

      String seq = sc.next();
      char direction = seq.charAt(0);
      long number = Long.parseLong(seq.substring(1));

      if (direction == 'R' || direction == 'r') {

        long clicksUntilZero = (100 - position) % 100;

        if (number >= clicksUntilZero) {
          totalZeroes += 1 + (number - clicksUntilZero) / 100;
        }

        position = (int) ((position + number) % 100);

      } else {

        long clicksUntilZero = position % 100;

        if (number >= clicksUntilZero) {
          totalZeroes += 1 + (number - clicksUntilZero) / 100;
        }

        position = (int) ((position - number) % 100);
        if (position < 0) position += 100;
      }
    }

    System.out.println(totalZeroes);
  }
}
