package year2025.day1;

import java.util.Scanner;

public class Part1 {
  public static void main(String[] args) {
    int totalZeroes = 0;

    Scanner sc = new Scanner(System.in);

    String seq;
    String direction;
    int number;
    int position = 50;

    while (sc.hasNext()) {
      seq = sc.next();
      direction = seq.substring(0, 1);
      number = Integer.parseInt(seq.substring(1));
      number = number % 100;

      if (direction.equalsIgnoreCase("L")) {
        System.out.println("Moving " + number + " positions to the left");
        position -= number;
        if (position < 0) {
          position = 100 - Math.abs(position);
        }
        System.out.println("Moved " + number + " to the left. Current position is " + position);
      } else {
        System.out.println("Moving " + number + " positions to the right");
        position += number;
        if (position > 0) {
          position = position % 100;
        }
        System.out.println("Moved " + number + " to the right. Current position is " + position);
      }

      if (position == 0) {
        totalZeroes++;
      }

      System.out.println(totalZeroes);
    }
  }
}
