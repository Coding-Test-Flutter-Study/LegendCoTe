import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static boolean[][] visited;
    static int[][] newMap;
    static int count;
    static int iceNum;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M;
    static int[] start = {0,0};
    static int[] end = {N,M};

    //bfs 로 빙산 개수 체크
    //2보다 작으면 빙산 줄이기
    //위 과정 반복하면서  2개 이상일때 중단
    // count

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        newMap = new int[N][M];



        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st2.nextToken());
                map[i][j] = a;
            }
        }

        while (true) {
            iceNumCheck();
            if(iceNum==0){
                bw.write("0");
                break;
            }

            if (iceNum >= 2) {
                bw.write(String.valueOf(count));
                break;
            } else {
                melting();
                copyMap(map,newMap);
                count++;
            }

            visited = new boolean[N][M];
            iceNum = 0;
        }


        bw.flush();
    }

    static void iceNumCheck() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    iceNum++;
                }
            }
        }
    }

    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();

        visited[x][y]=true;

        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {

            int[] xy = queue.poll();

            for (int i = 0; i < 4; i++) {

                int newX = xy[0] + dx[i];
                int newY = xy[1] + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M && map[newX][newY] != 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    static void melting() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {

                    int water = 0;
                    for (int x = 0; x < 4; x++) {
                        int newI = i + dx[x];
                        int newJ = j + dy[x];

                        if (map[newI][newJ] == 0) {
                            water++;
                        }
                    }

                    newMap[i][j] = map[i][j]-water;
                    if(newMap[i][j]<=0){
                        newMap[i][j]=0;
                    }
                }
            }
        }

    }


    static void copyMap(int[][] map, int[][] newMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = newMap[i][j];
            }
        }

    }
}