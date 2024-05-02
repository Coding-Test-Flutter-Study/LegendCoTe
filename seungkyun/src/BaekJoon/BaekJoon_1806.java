import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,S;
    static int[] array;

    static int[] sumArray;

    static int start,end;
    static int sum;
    static int length;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];
        sumArray= new int[N+1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            int n =Integer.parseInt(st2.nextToken());
            array[i] = n;
        }


        for(int i=1; i<=N;i++){
            sumArray[i] = sumArray[i-1]+array[i-1];
        }



        if(sumArray[N]<S){
            bw.write("0");
        } else {
            twoPointer();
            bw.write(String.valueOf(length));
        }



        bw.flush();
    }

    static void twoPointer() {

        start = 0;
        end = 0;

        length = 100000;
        while (start<=N){

            sum = sumArray[end]-sumArray[start];

            if(sum<S){

                end++;

                if(end>N){
                    break;
                }
            } else {
                length = Math.min(length,end-start);

                start++;

                if(start>end){
                    break;
                }


            }


        }

    }
}