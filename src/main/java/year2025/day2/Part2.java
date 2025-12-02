package year2025.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part2 {
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

    for (long i = min; i <= max; i++) {
      if (isNumberInvalid(i)) {
        invalidIds.add(i);
      }
    }
    return invalidIds;
  }

  private static boolean isNumberInvalid(long l) {
    String s = String.valueOf(l);
    int len = s.length();

    for (int size = 1; size <= len / 2; size++) {

      if (len % size != 0) continue;

      String pattern = s.substring(0, size);
      boolean matches = true;

      for (int i = size; i < len; i += size) {
        if (!s.substring(i, i + size).equals(pattern)) {
          matches = false;
          break;
        }
      }

      if (matches) return true;
    }

    return false;
  }
}
