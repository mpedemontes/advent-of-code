package year2025.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

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

      // === PARTE 2: construir números por columnas ===
      List<Long> nums = new ArrayList<>();

      for (int col = start; col <= end; col++) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows - 1; r++) {
          char ch = getChar(raw, r, col);
          if (Character.isDigit(ch)) sb.append(ch);
        }
        if (sb.length() > 0) nums.add(Long.parseLong(sb.toString()));
      }

      String op = "";
      for (int col = start; col <= end; col++) {
        char ch = getChar(raw, rows - 1, col);
        if (ch == '+' || ch == '*') {
          op = "" + ch;
          break;
        }
      }

      long res = op.equals("+") ? 0 : 1;
      for (long v : nums) {
        res = op.equals("+") ? (res + v) : (res * v);
      }

      total += res;
    }

    System.out.println(total);
  }

  static boolean isEmptyCol(List<String> raw, int col) {
    for (String s : raw) if (col < s.length() && s.charAt(col) != ' ') return false;
    return true;
  }

  static char getChar(List<String> raw, int row, int col) {
    if (col >= raw.get(row).length()) return ' ';
    return raw.get(row).charAt(col);
  }

  static int maxLength(List<String> raw) {
    int m = 0;
    for (String s : raw) m = Math.max(m, s.length());
    return m;
  }
}
