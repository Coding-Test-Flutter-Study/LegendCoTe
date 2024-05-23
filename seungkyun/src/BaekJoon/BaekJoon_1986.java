import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static String[][] map;
    static int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};


    static int N, M;
    static int num;
    static int ans;

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = "X";
            }
        }

        for (int n = 0; n < 3; n++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st2.nextToken());

            for (int i = 0; i < num; i++) {
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());

                if (n == 0) {
                    map[x-1][y-1] = "Q";
                } else if (n == 1) {
                    map[x-1][y-1] = "K";
                } else {
                    map[x-1][y-1] = "P";
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j].equals("Q")) {

                    Queen(i, j);
                } else if (map[i][j].equals("K")) {

                    Knight(i, j);
                }
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j].equals("X")) {
                    ans++;
                }
            }
        }

        bw.write(String.valueOf(ans));



        bw.flush();
    }

    static void Queen(int x, int y) {

        int xu = x - 1;
        int xd = x + 1;
        int yl = y - 1;
        int yr = y + 1;

        while (xu >= 0 && !map[xu][y].equals("K") && !map[xu][y].equals("P")&& !map[xu][y].equals("Q")) {
            map[xu][y] = "O";
            xu--;
        }
        while (xd < N && !map[xd][y].equals("K") && !map[xd][y].equals("P")&& !map[xd][y].equals("Q")) {
            map[xd][y] = "O";
            xd++;
        }
        while (yl >= 0 && !map[x][yl].equals("K") && !map[x][yl].equals("P")&& !map[x][yl].equals("Q")) {
            map[x][yl] = "O";
            yl--;
        }
        while (yr < M && !map[x][yr].equals("K") && !map[x][yr].equals("P")&& !map[x][yr].equals("Q")) {
            map[x][yr] = "O";
            yr++;
        }


        for (int i = 1; i <= 1000; i++) {
            if (x + i < N && y + i < M && !map[x + i][y + i].equals("K") && !map[x + i][y + i].equals("P")&&!map[x + i][y + i].equals("Q")) {
                map[x + i][y + i] = "O";
            } else {
                break;
            }
        }
        for (int i = 1; i <= 1000; i++) {
            if (x - i >= 0 && y - i >= 0 && !map[x - i][y - i].equals("K") && !map[x - i][y - i].equals("P")&& !map[x - i][y - i].equals("Q")) {
                map[x - i][y - i] = "O";
            } else {
                break;
            }
        }
        for (int i = 1; i <= 1000; i++) {
            if (x + i < N && y - i >= 0 && !map[x + i][y - i].equals("K") && !map[x + i][y - i].equals("P")&& !map[x + i][y - i].equals("Q")) {
                map[x + i][y - i] = "O";
            } else {
                break;
            }
        }
        for (int i = 1; i <= 1000; i++) {
            if (x - i >= 0 && y + i < M && !map[x - i][y + i].equals("K") && !map[x - i][y + i].equals("P")&& !map[x - i][y + i].equals("Q")) {
                map[x - i][y + i] = "O";
            } else {
                break;
            }
        }

    }

    static void Knight(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < M && map[newX][newY].equals("X")) {
                map[newX][newY] = "O";
            }
        }
    }


}
