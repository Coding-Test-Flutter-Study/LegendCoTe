import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,P,TaeScore;

    static int [] array;
    static int rank;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        TaeScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());


        if(N==0){
            bw.write("1");
        } else {
            array = new int[P];

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i=0; i<N;i++){
                array[i] = Integer.parseInt(st2.nextToken());
            }

            rank = 1;

            if(N==P&&array[P-1]>=TaeScore){
                bw.write("-1");
            }
            else {
                for(int i=0; i<array.length;i++){
                    if(array[i]>TaeScore){
                        rank++;
                    }

                }
                bw.write(String.valueOf(rank));
            }


        }


        bw.flush();
    }

}