import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    static int [] array;


    static int max,maxCount;
    static int N,X;



    public static void main(String[] args) throws IOException {


        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        array= new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            int n = Integer.parseInt(st2.nextToken());
            array[i] = n;
        }

        slidingWindow();

        if(max==0){
            bw.write("SAD");
        } else {
            bw.write(max+"\n");

            bw.write(String.valueOf(maxCount));

        }


        bw.flush();
    }

    static void slidingWindow() throws IOException {

        int sum = 0;
        //초기
        for(int i=0; i<X;i++){
            sum += array[i];
        }

        max = sum;
        maxCount=1;

        //sliding window
        for(int i=X, j=0; i<N;i++,j++){
            sum =  sum+array[i]-array[j];
            if(sum>max){
                max = sum;
                maxCount=1;
            } else if (max==sum) {
                maxCount++;
            }


        }



    }



}