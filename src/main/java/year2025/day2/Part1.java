package year2025.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    List<Long> invalidIds = new ArrayList<>();
    String input = sc.nextLine();
    List<String> ranges = Arrays.stream(input.split(",")).toList();

    for (String range : ranges) {
      invalidIds.addAll(findInvalidIDsInRange(range));
    }
    System.out.println("Total: " + invalidIds.stream().reduce(0L, Long::sum));
  }

  private static List<Long> findInvalidIDsInRange(String range) {
    String[] parts = range.split("-");
    long min = Long.parseLong(parts[0]);
    long max = Long.parseLong(parts[1]);

    List<Long> invalidIds = new ArrayList<>();

    for (long i = min; i <= max; i++) {
      String s = String.valueOf(i);
      int len = s.length();

      if (len % 2 == 0) {
        String first = s.substring(0, len / 2);
        String second = s.substring(len / 2);
        if (first.equals(second)) {
          invalidIds.add(i);
        }
      }
    }
    return invalidIds;
  }
}
