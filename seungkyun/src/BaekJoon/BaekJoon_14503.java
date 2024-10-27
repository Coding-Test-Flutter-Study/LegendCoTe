import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 청소 하면 2
    // 빈칸 체크

    static int[] dx = { -1, 0, 1, -0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] map;
    static int ans, N, M;
    static int nowX, nowY, nowdir;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        nowX = Integer.parseInt(st2.nextToken());
        nowY = Integer.parseInt(st2.nextToken());
        nowdir = Integer.parseInt(st2.nextToken());

        for(int i=0; i<N;i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            for(int j=0; j<M;j++) {
                map[i][j]=Integer.parseInt(st3.nextToken());
            }
        }
        move();
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void move() {

        // 현재 칸 청소 안한 경우
        while (true) {
            if (map[nowX][nowY] == 0) {
                map[nowX][nowY] = 2;
                ans++;
            }

            boolean canClean = false;
            // 주변 빈칸 체크
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if (map[newX][newY] == 0) {
                        canClean = true;
                        break;
                    }
                }
            }

            if (!canClean) {
                // 빈 칸 없음

                // 후진 체크
                int backdir = (nowdir + 2) % 4;
                int newX = nowX + dx[backdir];
                int newY = nowY + dy[backdir];
                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    if (map[newX][newY] == 1) {
                        return;
                    } else {
                        nowX = newX;
                        nowY = newY;
                    }
                }

            } else {
                // 빈 칸 있음
                while (true) {

                    int newdir = (nowdir + 3) % 4;
                    int newX = nowX + dx[newdir];
                    int newY = nowY + dy[newdir];
                    nowdir = newdir;
                    if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                        if (map[newX][newY] == 0) {
                            nowX = newX;
                            nowY = newY;

                            break;
                        }
                    }

                }

            }
        }
    }
}