import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, ans;
    static int[][] array, map;
    static int[] order;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        //이중 배열로 사랑ㅁ과 좋아하는 사람 저장
        //순서대로 반복문 돌리기
        //좋아하는 사람 수 배열과 빈칸의 수 배열 생성해서 저장
        //조건에 맞게 배치

        ans = 0;
        N = Integer.parseInt(br.readLine());
        array = new int[N * N + 1][4];
        map = new int[N][N];
        order = new int[N * N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            order[i] = n;
            for (int j = 0; j < 4; j++) {
                array[n][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N * N; i++) {
            int now = order[i];

            int[][] like = new int[N][N];
            int[][] empty = new int[N][N];

            //조건 배열 채우기
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < N; m++) {
                    for (int x = 0; x < 4; x++) {
                        int newM = m + dy[x];
                        int newN = n + dx[x];

                        if (newM >= 0 && newN >= 0 && newM < N && newN < N) {
                            //like
                            for (int l = 0; l < 4; l++) {
                                if (map[newN][newM] == array[now][l]) {
                                    like[n][m]++;
                                }
                            }

                            //empty
                            if (map[newN][newM] == 0) {
                                empty[n][m]++;
                            }
                        }
                    }
                }
            }

            //배치
            set(like, empty, now);


        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                int check = 0;
                for (int x = 0; x < 4; x++) {
                    int newM = m + dy[x];
                    int newN = n + dx[x];

                    if (newM >= 0 && newN >= 0 && newM < N && newN < N) {
                        //like
                        for (int l = 0; l < 4; l++) {
                            if (map[newN][newM] == array[map[n][m]][l]) {
                                check++;
                            }
                        }

                    }
                }

                if (check == 0) {

                } else if (check == 1) {
                    ans += 1;
                } else if (check == 2) {
                    ans += 10;
                } else if (check == 3) {
                    ans += 100;
                } else {
                    ans += 1000;
                }
            }

        }
//
//        for (int n = 0; n < N; n++) {
//            for (int m = 0; m < N; m++) {
//                bw.write(map[n][m]+" ");
//            }
//            bw.write("\n");
//        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void set(int[][] like, int[][] empty, int i) {
        int nowLike = 0;
        int nowEmpty = 0;
        //배치

        int X = -1;
        int Y = -1;

        for (int n = N-1; n >=0; n--) {
            for (int m = 0; m <N; m++) {
                if (map[n][m] == 0) {
                    if (like[n][m] > nowLike ||
                            (like[n][m] == nowLike && empty[n][m] > nowEmpty) ||
                            (like[n][m] == nowLike && empty[n][m] == nowEmpty && (X == -1 || n < X || (n == X && m < Y)))) {
                        nowLike = like[n][m];
                        nowEmpty = empty[n][m];
                        X = n;
                        Y = m;
                    }
                }

            }
        }

        map[X][Y] = i;
    }
}