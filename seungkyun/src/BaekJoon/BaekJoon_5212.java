import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static String[][] map;
    static String[][] newMap;
    static int maxX, maxY, minX, minY;
    static int N, M;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {


        minX = 11;
        minY = 11;
        maxX = 0;
        maxY = 0;
        //육지 제거
        //섬 1개일 경우, 2개 이상일 경우 나누어 지도 축소

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        newMap = new String[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] array = str.split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = array[j];
            }
        }

        copyMap(map, newMap);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("X")) {
                    submerge(i, j);
                }
            }
        }

        shrinkMap();


        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                bw.write(newMap[i][j]);
            }
            if (i < maxX) {
                bw.write("\n");

            }
        }


        bw.flush();
    }


    static void submerge(int x, int y) {

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0) {
                count++;
            }
            if (newY < 0) {
                count++;
            }
            if (newX >= N) {
                count++;
            }
            if (newY >= M) {
                count++;
            }
            if (newX >= 0 && newY >= 0 && newX < N && newY < M && map[newX][newY].equals(".")) {
                count++;
            }
        }

        if (count >= 3) {
            newMap[x][y] = ".";
        }

    }

    static void shrinkMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j].equals("X")) {
                    maxY = Math.max(maxY, j);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    minX = Math.min(minX, i);
                }
            }
        }

    }

    static void copyMap(String[][] map, String[][] newMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }


}