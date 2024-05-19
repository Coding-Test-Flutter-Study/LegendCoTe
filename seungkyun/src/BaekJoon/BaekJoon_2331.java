import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int A,P;

    static int [] check = new int[4*(9*9*9*9*9)+1];
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());


        check[A]++;
        arrayList.add(A);

        while (true){
            int D = D(String.valueOf(A));


            if(check[D]==0){
                check[D]++;
                arrayList.add(D);
                A = D;
            } else {
                ans = arrayList.indexOf(D);
                bw.write(String.valueOf(ans));
                break;
            }

        }

        bw.flush();
    }

    static int D(String a){
        int r = 0;
        for(int i=0; i<a.length();i++){
            int q = 1;
            for(int j=0; j<P;j++){
                q*=Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            r+=q;
        }
        return r;
    }
}