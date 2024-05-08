import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] array;

    static int start,end;
    static int sum;
    static int minSum;
    static int ans1,ans2;


    public static void main(String[] args) throws IOException {


        N  =Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            int n = Integer.parseInt(st.nextToken());

            array[i] = n;
        }

        Arrays.sort(array);

        twoPointer();
        bw.write(ans1+" "+ans2);


        bw.flush();
    }


    static void twoPointer() {

        start = 0;
        end = N-1;

        sum = array[start]+array[end];

        ans1 = array[start];
        ans2 = array[end];
        minSum = sum;

        while (start<end){

            if(sum==0){
                ans1 = array[start];
                ans2 = array[end];
                break;
            } else if(sum<0){


                start ++;

                if(start!=end){
                    sum = array[start]+array[end];
                    if(Math.abs(sum)<Math.abs(minSum)){

                        minSum = Math.abs(sum);
                        ans1 = array[start];
                        ans2 = array[end];
                    }
                }

            } else if (sum>0){

                end --;

                if(start!=end){
                    sum = array[start]+array[end];
                    if(Math.abs(sum)<Math.abs(minSum)){

                        minSum = Math.abs(sum);
                        ans1 = array[start];
                        ans2 = array[end];
                    }
                }
            }
        }


    }
}