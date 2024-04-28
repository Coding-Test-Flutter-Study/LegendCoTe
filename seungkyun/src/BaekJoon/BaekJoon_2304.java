import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;
    static int[] array;
    static int max;
    static int heightNow;
    static int heightL,heightR;
    static int lengthNow;
    static int ans;

    public static void main(String[] args) throws IOException {

        array = new int[1001];

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            array[l] = h;
            max = Math.max(max,h);
        }

        find();
        ans+=max*(heightR-heightL+1);

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void find() throws IOException {

        heightNow = array[0];
        lengthNow=0;
        //앞
        for(int i=1; i<array.length;i++){
            if(array[i]>heightNow){

                ans+=heightNow*(i-lengthNow);
                heightNow = array[i];
                lengthNow = i;

            }

            if(heightNow==max){
                heightL=i;
                break;
            }

        }



        //뒤

        heightNow = array[1000];
        lengthNow = 1000;
        for(int i=array.length-1; i>=0;i--){

            if(array[i]>heightNow){

                ans+=heightNow*(lengthNow-i);
                heightNow = array[i];
                lengthNow = i;
            }



            if(heightNow==max){
                heightR=i;
                break;
            }

        }

    }





}