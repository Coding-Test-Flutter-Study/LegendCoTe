import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, bus;

    static int[][] map;
    static int max = 100000*99+1;

    //map 완성
    //플로이드 워셜 -> 0~n-1 까지 반복하며 이 경로를 거쳐가는 경우와 그냥 거리중 짧은것 선택
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];


        //최댓값 대입
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = max;
            }
        }


        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], money);
        }

        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }

        floyd();

        check();

        bw.flush();
    }

    static void floyd() {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    static void check() throws IOException {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(map[i][j]==max){
                    bw.write(0+" ");
                } else {
                    bw.write(map[i][j] + " ");
                }

            }
            bw.write("\n");
        }
    }

}