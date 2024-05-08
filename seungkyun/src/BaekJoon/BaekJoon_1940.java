import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N,M;
    static int[] array;
    static int start,end;
    static int sum;
    static int ans;



    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M  =Integer.parseInt(br.readLine());

        array = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            array[i] = n;
        }

        Arrays.sort(array);

        twoPointer();

        bw.write(String.valueOf(ans));
        bw.flush();
    }


    static void twoPointer() {

        start =0;
        end = N-1;

        sum= array[start]+array[end];

        while (start<end){

            if(sum==M){
                ans++;
                start++;
                end--;
                sum = array[start]+array[end];
            } else if(sum>M){
                sum-=array[end];
                end--;
                sum+=array[end];
            } else {
                sum-=array[start];
                start++;
                sum+=array[start];
            }
        }



    }
}