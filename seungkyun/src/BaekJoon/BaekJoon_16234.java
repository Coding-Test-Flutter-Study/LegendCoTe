import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N, L, R;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int sum;
    static int countries;
    static boolean ok;
    static ArrayList<int[]> arrayList = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st2.nextToken());
                map[i][j] = a;
            }
        }

        ok = true;
        while (ok) {
            ok = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            ans++;
            visited = new boolean[N][N];
        }
        bw.write(String.valueOf(ans-1));
        bw.flush();
    }

    static void bfs(int x, int y)  {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        sum += map[x][y];
        countries++;
        arrayList.add(new int[]{x, y});

        while (!queue.isEmpty()) {

            int[] xy = queue.poll();


            for (int i = 0; i < 4; i++) {
                int newX = xy[0] + dx[i];
                int newY = xy[1] + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY] && Math.abs(map[xy[0]][xy[1]] - map[newX][newY]) >= L && Math.abs(map[xy[0]][xy[1]] - map[newX][newY]) <= R) {


                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                    ok=true;

                    sum += map[newX][newY];
                    countries++;
                    arrayList.add(new int[]{newX, newY});
                }
            }

        }

        population();
        sum = 0;
        countries = 0;
        arrayList.clear();

    }

    static void population() {

        int population = sum / countries;

        for (int i = 0; i < arrayList.size(); i++) {
            int x = arrayList.get(i)[0];
            int y = arrayList.get(i)[1];

            map[x][y] = population;

        }
    }
}
