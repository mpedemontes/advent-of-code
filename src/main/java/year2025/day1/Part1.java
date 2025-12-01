package year2025.day1;

import java.util.Scanner;

public class Part1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int position = 50;
    int totalZeroes = 0;

    while (sc.hasNext()) {
      String seq = sc.next();
      char direction = seq.charAt(0);
      int number = Integer.parseInt(seq.substring(1)) % 100;

      if (direction == 'L' || direction == 'l') {
        position -= number;
      } else { // R
        position += number;
      }

      // Normalizar posición en rango 0–99
      position = ((position % 100) + 100) % 100;

      if (position == 0) {
        totalZeroes++;
      }
    }

    System.out.println(totalZeroes);
  }
}
