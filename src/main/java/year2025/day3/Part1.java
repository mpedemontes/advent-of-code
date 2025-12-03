package year2025.day3;

import java.util.Scanner;

public class Part1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String line;
    int total = 0;
    int max;
    int maxPosition;
    int secondMax;
    int current;
    int toAdd;
    String rest;
    while (sc.hasNext()) {
      line = sc.nextLine();
      System.out.println(line);
      max = 0;
      maxPosition = 0;
      secondMax = 0;
      for (int i = 0; i < line.length() - 1; i++) {
        current = Character.getNumericValue(line.charAt(i));
        if (current > max) {
          max = current;
          maxPosition = i;
        }
      }
      rest = line.substring(maxPosition + 1);
      System.out.println(line.substring(maxPosition + 1));
      for (int i = 0; i < rest.length(); i++) {
        current = Character.getNumericValue(rest.charAt(i));
        if (current > secondMax) {
          secondMax = current;
        }
      }

      toAdd = 10 * max + secondMax;
      System.out.println(line);
      System.out.println("adding " + toAdd);
      total += toAdd;
      System.out.println(total);
    }
  }
}
