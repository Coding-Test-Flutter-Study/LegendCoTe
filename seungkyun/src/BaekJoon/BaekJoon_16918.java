import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    //while
    // 시간 짝수면 채우기,
    // 시간 홀수 터뜨리기, 폭탄좌표

    static int times;
    static ArrayList<int[]> bombLocation = new ArrayList<>();

    static int R, C, N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static String[][] map;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        times = 1;
        map = new String[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            String[] strings = str.split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = strings[j];
            }
        }

        bomb();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static void bomb() {
        while (times <= N) {
            //폭탄 설치
            if (times % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j].equals(".")) {
                            map[i][j] = "O";
                        }
                    }
                }
                times++;
            } else {
                //폭발
                for (int i = 0; i < bombLocation.size(); i++) {
                    map[bombLocation.get(i)[0]][bombLocation.get(i)[1]] = ".";
                    for (int d = 0; d < 4; d++) {
                        int newX = bombLocation.get(i)[0] + dx[d];
                        int newY = bombLocation.get(i)[1] + dy[d];
                        if (newX >= 0 && newY >= 0 && newX < R && newY < C) {
                            map[newX][newY] = ".";
                        }
                    }
                }
                bombLocation.clear();

                //남은 폭탄 좌표 저장
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j].equals("O")) {
                            bombLocation.add(new int[]{i, j});
                        }
                    }
                }
                times++;
            }
        }
    }
}