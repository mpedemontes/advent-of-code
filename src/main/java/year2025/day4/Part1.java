package year2025.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<List<Character>> lines = new ArrayList<>();
    String line;
    while (sc.hasNext()) {
      line = sc.nextLine();
      if ("fin".equals(line)) {
        break;
      }
      if (!line.isBlank()) {
        lines.add(line.chars().mapToObj(c -> (char) c).toList());
      }
    }
    List<Character> currentLine;
    int surroundingRolls;
    int total = 0;
    for (int i = 0; i < lines.size(); i++) {
      currentLine = lines.get(i);
      for (int j = 0; j < currentLine.size(); j++) {
        surroundingRolls = 0;
        if (currentLine.get(j) == '@') {
          if (i > 0) {
            surroundingRolls += checkSurroundingLine(lines.get(i - 1), j);
          }
          surroundingRolls += checkCurrentLine(lines.get(i), j);
          if (i + 1 < lines.size()) {
            surroundingRolls += checkSurroundingLine(lines.get(i + 1), j);
          }
          if (surroundingRolls < 4) {
            total++;
          }
        }
      }
    }
    System.out.println(total);
  }

  private static int checkCurrentLine(List<Character> line, int j) {
    int total = 0;

    if (j > 0 && line.get(j - 1) == '@') {
      total++;
    }
    if (j + 1 < line.size() && line.get(j + 1) == '@') {
      total++;
    }
    return total;
  }

  private static int checkSurroundingLine(List<Character> line, int j) {
    int total = 0;

    if (j > 0 && line.get(j - 1) == '@') {
      total++;
    }
    if (line.get(j) == '@') {
      total++;
    }
    if (j + 1 < line.size() && line.get(j + 1) == '@') {
      total++;
    }
    return total;
  }
}
