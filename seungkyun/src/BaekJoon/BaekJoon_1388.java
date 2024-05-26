import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int X, Y;
    static String[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new String[X][Y];
        visited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            String str = br.readLine();
            String[] strings = str.split("");
            for (int j = 0; j < Y; j++) {
                map[i][j] = strings[j];
            }
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                }
            }
        }

        bw.write(String.valueOf(ans));

        bw.flush();
    }

    static void bfs(int x, int y, String str) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {

            int[] xy = queue.poll();

            if (str.equals("-")) {
                for (int i = 0; i < 2; i++) {
                    int newX = xy[0] + dx[i];
                    int newY = xy[1] + dy[i];

                    if (newX >= 0 && newY >= 0 && newX < X && newY < Y && !visited[newX][newY] && map[newX][newY].equals("-")) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            } else {
                for (int i = 2; i < 4; i++) {
                    int newX = xy[0] + dx[i];
                    int newY = xy[1] + dy[i];

                    if (newX >= 0 && newY >= 0 && newX < X && newY < Y && !visited[newX][newY] && map[newX][newY].equals("|")) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        ans++;
    }
}