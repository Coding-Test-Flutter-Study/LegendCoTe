import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int K;
    static long  N,ans;

    static long left =1;
    static long right = Integer.MAX_VALUE;

    static long[] array;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());

        array = new long[K];
        for(int i=0; i<K;i++){
            long num = Long.parseLong(br.readLine());
            array[i]=num;
        }

        binarySearch(left,right);

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void binarySearch(long left,long right){

        long mid = (left+right)/2;
        long count = 0;
        for(int i=0; i<K;i++){
            count+=array[i]/mid;
        }

        if(left<=right){

            if(count>=N){
                ans = mid;
                binarySearch(mid+1,right);
            } else {
                binarySearch(left,mid-1);
            }
        }


    }
}