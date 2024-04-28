import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N,M;
    static int[] array;
    static int max;
    static int sum;
    static int ans;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,array[i]);
        }

        M = Integer.parseInt(br.readLine());

        check();

        bw.write(String.valueOf(max));

        bw.flush();
    }

    static void check(){

        while (true){

            for(int i=0; i<N;i++){
                sum += Math.min(array[i], max);
            }

            if(M>=sum){
                break;
            } else {
                max--;
                sum=0;
            }

        }


    }


}