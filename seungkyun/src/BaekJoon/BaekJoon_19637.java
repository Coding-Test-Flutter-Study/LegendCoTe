import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static String[] title;
    static int[] titleNum;

    static int N, M;
    static String ans;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        title = new String[N];
        titleNum = new int[N];

        for (int i = 0; i < N; i++) {

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String str = st2.nextToken();
            int num = Integer.parseInt(st2.nextToken());

            title[i] = str;
            titleNum[i] = num;
        }

        for (int i = 0; i < M; i++) {

            int ch = Integer.parseInt(br.readLine());
            check(ch);
            bw.write(ans + "\n");
        }


        bw.flush();
    }

    static void check(int character) {

        int start = 0;
        int end = N - 1;

        int mid;
        while (start <= end) {

            mid = (start + end) / 2;

            if (character<= titleNum[mid]) {
                end = mid-1;
            } else if(character>titleNum[mid]){
                start = mid+1;
            }
        }
        ans =title[start];
    }
}