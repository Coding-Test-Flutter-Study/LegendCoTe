import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N,X;
    static int [] array;
    static int start,end;
    static int sum;
    static int ans;


    public static void main(String[] args) throws IOException {

        N =Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            array[i] = n;

        }

        Arrays.sort(array);

        X = Integer.parseInt(br.readLine());


        twoPointer();

        bw.write(String.valueOf(ans));
        bw.flush();
    }


    static void twoPointer() throws IOException {

        end = N-1;
        start=0;

        sum = array[start]+array[end];

        while (end>start){

            if(sum==X){
                ans++;

                start++;
                end--;
                sum = array[start]+array[end];
            } else if(sum<X){
                sum-=array[start];
                start++;
                sum+=array[start];
            } else if(sum>X){
                sum-=array[end];
                end--;
                sum+=array[end];
            }

        }

    }
}