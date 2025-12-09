package year2025.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Part2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<long[]> ranges = new ArrayList<>();
    String line;
    while (sc.hasNext()) {
      line = sc.nextLine();
      if (line.equals("fin")) {
        break;
      }
      if (!line.isBlank()) {
        String[] parts = line.split("-");
        long start = Long.parseLong(parts[0]);
        long end = Long.parseLong(parts[1]);
        ranges.add(new long[] {start, end});
      }
    }
    ranges.sort(Comparator.comparingLong(a -> a[0]));
    List<long[]> merged = new ArrayList<>();
    long[] current = ranges.get(0);

    for (int i = 1; i < ranges.size(); i++) {
      long[] next = ranges.get(i);

      if (next[0] <= current[1] + 1) {
        current[1] = Math.max(current[1], next[1]);
      } else {
        merged.add(current);
        current = next;
      }
    }

    merged.add(current);

    long total = 0;
    for (long[] r : merged) {
      total += (r[1] - r[0] + 1);
    }

    System.out.println("Total fresh IDs = " + total);
  }
}
