package puzzles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadPuzzle {

    public static List<String> readFile() throws IOException {

      BufferedReader reader = new BufferedReader(new FileReader("puzzle.txt"));
      List<String> rows = new ArrayList<>();
      String row;

      while (( row = reader.readLine()) != null)
      {
        rows.add(row);
      }

      return rows;
    }
}
