import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by haosun on 5/21/17.
 */
public class Main {
    private int shortest = Integer.MAX_VALUE;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        dfs(maze, start[0], start[1], destination, 0);
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void dfs(int[][] maze, int curR, int curC, int[] destination, int curDistance) {
        if (curR == destination[0] && curC == destination[1]) {
            shortest = Math.min(shortest, curDistance);
            return;
        }
        if (maze[curR][curC] == 2) {
            return;
        }
        maze[curR][curC] = 2;
        int r = curR;
        int c = curC;
        int distance = curDistance;
        while ((c - 1) >= 0 && maze[r][c - 1] != 1) {
            c--;
            distance++;
        }
        if (c != curC) {
            dfs(maze, r, c, destination, distance);
        }
        r = curR;
        c = curC;
        distance = curDistance;
        while ((c + 1) < maze[0].length && maze[r][c + 1] != 1) {
            c++;
            distance++;
        }
        if (c != curC) {
            dfs(maze, r, c, destination, distance);
        }
        r = curR;
        c = curC;
        distance = curDistance;
        while ((r - 1) >= 0 && maze[r - 1][c] != 1) {
            r--;
            distance++;
        }
        if (r != curR) {
            dfs(maze, r, c, destination, distance);
        }
        r = curR;
        c = curC;
        distance = curDistance;
        while ((r + 1) < maze.length && maze[r + 1][c] != 1) {
            r++;
            distance++;
        }
        if (r != curR) {
            dfs(maze, r, c, destination, distance);
        }
        maze[curR][curC] = 0;
    }

    public static void main (String[] args) {
        Main test = new Main();
        int[][] maze = new int[][]{};
        int[] start = new int[]{21, 78};
        int[] destination = new int[]{30, 93};
        int result = test.shortestDistance(maze, start, destination);
        System.out.println(result);
    }
}
