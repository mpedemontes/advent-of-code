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
    long min = Long.parseLong(range.split("-")[0]);
    long max = Long.parseLong(range.split("-")[1]);
    List<Long> invalidIds = new ArrayList<>();

    String firstHalf;
    String secondHalf;
    String stringValue;
    for (long i = min; i <= max; i++) {
      stringValue = String.valueOf(i);
      System.out.println("stringValue: " + stringValue);
      if (stringValue.length() % 2 == 0) {
        firstHalf = stringValue.substring(0, stringValue.length() / 2);
        secondHalf = stringValue.substring(stringValue.length() / 2);
        System.out.println("firstHalf: " + firstHalf);
        System.out.println("secondHalf: " + secondHalf);
        if (firstHalf.equals(secondHalf)) {
          invalidIds.add(i);
        }
      }
    }
    return invalidIds;
  }
}
