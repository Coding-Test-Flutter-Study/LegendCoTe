import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,S;
    static int[] array;

    static int ans;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array= new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            array[i] = Integer.parseInt(st2.nextToken());
        }

        find(0,0);

        if(S==0){
            bw.write(ans-1+" ");

        } else {
            bw.write(ans+" ");
        }
        bw.flush();
    }

    static void find(int startI,int sum){

        if(sum==S){
            ans++;
        }
        if(startI<array.length){
            for(int i=startI; i<array.length;i++){
                find(i+1,sum+array[i]);
            }
        }
    }

}