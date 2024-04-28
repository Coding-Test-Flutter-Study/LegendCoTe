import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N,streak;
    static int[] temp;
    static int[] prefixSum;
    static int max;

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        streak = Integer.parseInt(st.nextToken());

        temp = new int[N];
        prefixSum = new int[N+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){

            int n = Integer.parseInt(st2.nextToken());

            temp[i]= n;
        }

        for(int i=1; i<N+1;i++){
            prefixSum[i] = prefixSum[i-1]+temp[i-1];
        }

        max = prefixSum[streak];
        prefix();

        bw.write(String.valueOf(max));


        bw.flush();
    }

    static void prefix() {
        for(int i=streak; i<=N;i++){

            max = Math.max(max,prefixSum[i]-prefixSum[i-streak]);
        }
    }



}