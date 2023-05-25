package puzzles;

import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import search.AbstractState;
import search.State;

public class PuzzleN extends AbstractState {

    static Integer N = 3;
    int[][] table;

    enum Direction {N, E, S, W}

    public PuzzleN() throws IOException {

        List<String> text = ReadPuzzle.readFile();
        table = new int[N][N];
        for(int i = 0; i < N; i++)
        {
            String[] row = text.get(i).split(" ");
            for (int j = 0; j < N; j++)
            {
                  table[i][j] = Integer.parseInt(row[j]);
            }
        }
    }

    public PuzzleN(PuzzleN puzzleN, Direction d) {

        super(puzzleN);
        this.table = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                table[i][j] = puzzleN.table[i][j];
            }
        }

        int zeroRow = 0, zeroCol = 0;

        for(int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (table[i][j] == 0)
                {
                    zeroRow = i;
                    zeroCol = j;
                }
            }
        }


        switch (d)
        {
            case N -> {
                table[zeroRow][zeroCol] = table[zeroRow-1][zeroCol];
                table[zeroRow-1][zeroCol] = 0;
            }
            case E -> {
                table[zeroRow][zeroCol] = table[zeroRow][zeroCol+1];
                table[zeroRow][zeroCol+1] = 0;
            }
            case S -> {
                table[zeroRow][zeroCol] = table[zeroRow+1][zeroCol];
                table[zeroRow+1][zeroCol] = 0;
            }
            case W -> {
                table[zeroRow][zeroCol] = table[zeroRow][zeroCol-1];
                table[zeroRow][zeroCol-1] = 0;
            }
            default -> System.out.println("Wrong State");
        }

    }


    @Override
    public Iterable<State> getPossibleMoves() {

        int zeroRow = 0, zeroCol = 0;

        for (int row = 0; row < N; row++)
        {
            for (int col = 0; col < N; col++)
            {
                if (table[row][col] == 0)
                {
                    zeroRow = row; zeroCol = col;
                }
            }
        }

        List<State> moves = new ArrayList<>();

        if (zeroRow > 0)
        {
            moves.add(new PuzzleN(this, Direction.N));
        }
        if (zeroCol > 0)
        {
            moves.add(new PuzzleN(this, Direction.W));
        }
        if (zeroRow < N-1)
        {
            moves.add(new PuzzleN(this, Direction.S));
        }
        if (zeroCol < N-1)
        {
            moves.add(new PuzzleN(this, Direction.E));
        }

        return moves;
    }

    @Override
    public boolean isSolution() {

        boolean solution = true;

        for (int row = 0; row < N; row++)
        {
            for (int col = 0; col < N; col++)
            {
                if (table[row][col] != row*N+col)
                {
                    solution = false;
                    break;
                }
            }
        }
        return solution;
    }

    @Override
    public double getHeuristic() {

        double sum = 0;
//        for (int row = 0; row < N; row++)
//        {
//            for (int col = 0; col < N; col++)
//            {
//                sum += abs(table[row][col]/N-row)+abs();
//            }
//        }
        return sum;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuzzleN puzzleN = (PuzzleN) o;
        return Arrays.deepEquals(table, puzzleN.table);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(table);
    }

    @Override
    public String toString() {
        return "PuzzleN{" +
                "table=" + Arrays.deepToString(table) +
                '}';
    }
}

