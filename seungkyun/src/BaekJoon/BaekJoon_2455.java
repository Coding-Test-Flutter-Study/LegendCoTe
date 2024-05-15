import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int N,M;
    static int max;
    static int now;

    public static void main(String[] args) throws IOException {

        int now = 0;
        for(int i=0; i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());


            now -=N;
            now +=M;

            max = Math.max(max,now);

        }

        bw.write(String.valueOf(max));

        bw.flush();
    }



}