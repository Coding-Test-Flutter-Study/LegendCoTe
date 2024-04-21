package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1051 {


        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static String[][] array;
        static int max;

        public static void main(String[] args) throws IOException {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            array = new String[N][M];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                String[] strArray = str.split("");
                for (int j = 0; j < M; j++) {
                    array[i][j] = strArray[j];
                }
            }

            for (int X = 0; X < N; X++) {
                for (int Y = 0; Y < M; Y++) {

                    for (int x = X; x < N; x++) {
                        for (int y = Y; y < M; y++) {

                            if (array[X][Y].equals(array[x][y]) && array[X][Y].equals(array[X][y]) && array[X][Y].equals(array[x][Y])) {
                                if((x-X)==(y-Y)){
                                    max = Math.max((x - X + 1) * (y - Y + 1), max);

                                }
                            }
                        }
                    }


                }
            }


            bw.write(String.valueOf(max));

            bw.flush();
        }


}
