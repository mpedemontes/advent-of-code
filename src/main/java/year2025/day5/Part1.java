package year2025.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> ranges = new ArrayList<>();
    List<Long> numbers = new ArrayList<>();
    String line;
    while (sc.hasNext()) {
      line = sc.nextLine();
      if (line.equals("fin")) {
        break;
      }
      if (!line.isBlank()) {
        ranges.add(line);
      }
    }
    while (sc.hasNext()) {
      line = sc.nextLine();
      if (line.equals("fin")) {
        break;
      }
      if (!line.isBlank()) {
        numbers.add(Long.parseLong(line));
      }
    }
    int total = 0;
    for (Long number : numbers) {
      if (numberIsInSomeRange(number, ranges)) {
        total++;
      }
    }
    System.out.println(total);
  }

  private static boolean numberIsInSomeRange(Long number, List<String> ranges) {
    long n1, n2, aux;
    for (String range : ranges) {
      n1 = Long.parseLong(range.split("-")[0]);
      n2 = Long.parseLong(range.split("-")[1]);
      if (n1 > n2) {
        aux = n2;
        n2 = n1;
        n1 = aux;
      }
      if (number >= n1 && number <= n2) {
        return true;
      }
    }
    return false;
  }
}
