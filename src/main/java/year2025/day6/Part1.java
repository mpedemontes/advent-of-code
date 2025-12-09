package year2025.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> raw = new ArrayList<>();

    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.equals("fin")) break;
      raw.add(s);
    }

    int rows = raw.size();
    int cols = maxLength(raw);

    long total = 0;
    int c = 0;

    while (c < cols) {

      if (isEmptyCol(raw, c)) {
        c++;
        continue;
      }

      int start = c;
      while (c < cols && !isEmptyCol(raw, c)) c++;
      int end = c - 1;

      List<Long> nums = new ArrayList<>();

      for (int r = 0; r < rows - 1; r++) {
        String part = safeSubstring(raw.get(r), start, end).trim();
        if (!part.isEmpty()) {
          nums.add(Long.parseLong(part));
        }
      }

      String op = safeSubstring(raw.get(rows - 1), start, end).trim();

      long value = op.equals("+") ? 0 : 1;
      for (long x : nums) {
        value = op.equals("+") ? value + x : value * x;
      }

      total += value;
    }

    System.out.println(total);
  }

  static boolean isEmptyCol(List<String> raw, int col) {
    for (String s : raw) {
      if (col < s.length() && s.charAt(col) != ' ') return false;
    }
    return true;
  }

  static String safeSubstring(String s, int start, int end) {
    int len = s.length();
    if (start >= len) return "";
    if (end >= len) end = len - 1;
    return s.substring(start, end + 1);
  }

  static int maxLength(List<String> raw) {
    int max = 0;
    for (String s : raw) max = Math.max(max, s.length());
    return max;
  }
}
