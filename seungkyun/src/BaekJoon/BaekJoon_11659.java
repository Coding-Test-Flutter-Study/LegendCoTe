import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N,M;
    static int [] array;
    static int [] prefixSum;

    static int I,J;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        prefixSum = new int[N+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            int n = Integer.parseInt(st2.nextToken());

            array[i] = n;
        }


        for(int i=1; i<N+1;i++){
            prefixSum[i] = prefixSum[i-1]+array[i-1];
        }

        for(int i=0; i<M;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            I = Integer.parseInt(st3.nextToken());
            J = Integer.parseInt(st3.nextToken());

            bw.write(prefixSum(I,J)+"\n");

        }

        bw.flush();
    }

    static int prefixSum(int I, int J){


        return prefixSum[J]-prefixSum[I-1];



    }




}