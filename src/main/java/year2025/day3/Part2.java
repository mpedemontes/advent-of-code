package year2025.day3;

import java.util.Scanner;

public class Part2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long total = 0L;

    while (sc.hasNextLine()) {
      String line = sc.nextLine().trim();
      if (line.isEmpty()) continue;

      StringBuilder sb = getStringBuilder(line);

      String result = sb.substring(0, 12);
      long value = Long.parseLong(result);
      total += value;

      System.out.println(line + " → " + result + " (" + value + ")");
      System.out.println("TOTAL = " + total);
    }

    System.out.println("TOTAL = " + total);
    sc.close();
  }

  private static StringBuilder getStringBuilder(String line) {
    int n = line.length();
    int toRemove = n - 12;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      char c = line.charAt(i);

      while (!sb.isEmpty() && toRemove > 0 && sb.charAt(sb.length() - 1) < c) {
        sb.deleteCharAt(sb.length() - 1);
        toRemove--;
      }
      sb.append(c);
    }

    while (toRemove > 0) {
      sb.deleteCharAt(sb.length() - 1);
      toRemove--;
    }
    return sb;
  }
}
