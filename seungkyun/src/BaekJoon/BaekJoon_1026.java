import java.io.*;
import java.util.*;

public class Main {

    static int N,ans;
    static int[] A;
    static int[] B;
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            A[i]=a;
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            int b = Integer.parseInt(st2.nextToken());
            B[i]=b;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<N;i++){
            ans+=(A[i]*B[N-i-1]);
        }

        bw.write(String.valueOf(ans));

        bw.flush();
    }

}