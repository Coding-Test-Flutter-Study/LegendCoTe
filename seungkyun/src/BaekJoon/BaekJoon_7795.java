import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int T;
    static int N,M;
    static int [] arrayA,arrayB;

    static int pointerA,pointerB;
    static int ans;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T;t++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arrayA = new int[N];
            arrayB = new int[M];
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i=0; i<N;i++){
                int n = Integer.parseInt(st2.nextToken());
                arrayA[i] = n;
            }

            StringTokenizer st3 = new StringTokenizer(br.readLine());

            for(int i=0; i<M;i++){
                int m = Integer.parseInt(st3.nextToken());
                arrayB[i] = m;
            }

            Arrays.sort(arrayA);
            Arrays.sort(arrayB);


            twoPointer();
            bw.write(ans+"\n");
            ans =0;
        }



        bw.flush();
    }


    static void twoPointer() {

        pointerA = 0;
        pointerB = 0;
        while (pointerA<N){

            if(arrayA[pointerA]>arrayB[pointerB]){
                ans++;

                if(pointerB<M-1){
                    pointerB++;
                } else {
                    pointerA++;
                    pointerB=0;
                }
            } else {
                pointerA++;
                pointerB=0;
            }
        }



    }
}