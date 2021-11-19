package ddeliopoulos.github.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class GameOfLife {
    public static class Point {
        private final int x;
        private final int y;

        Collection<Point> checkNeighborPoints = new ArrayList<>() {{
            new Point(-1, -1); // top left
            new Point(-1, 0); // right above
            new Point(-1, +1); // top right
            new Point(0, -1); // left
            new Point(0, +1); // right
            new Point(+1, -1); // bottom left
            new Point(+1, 0); // underneath
            new Point(+1, +1); // bottom right
        }};

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Collection<Point> getNeighbors(int maxX, int maxY) {

            Collection<Point> points = checkNeighborPoints.stream()
                                      .map(direction -> new Point(this.x + direction.x, this.y + direction.y))
                                      .filter(checkNeighborPoints1 ->
                                                      checkNeighborPoints1.x > 0
                                                              && checkNeighborPoints1.x < maxX
                                                              && checkNeighborPoints1.y > 0
                                                              && checkNeighborPoints1.x < maxY
                                      )
                                      .collect(Collectors.toList());

            System.out.println(new ArrayList<>(points));

            return points;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 1}};

        gameOfLife(grid);

    }

    public static void gameOfLife(int[][] board) {

        int rowLength = board.length - 1;
        int colLength = board[0].length;

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                Collection<Point> neighbors = new Point(x, y).getNeighbors(rowLength, colLength);

                //System.out.println(new ArrayList<>(neighbors));
                break;

            }
        }
    }
}
