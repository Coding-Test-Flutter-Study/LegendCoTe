import java.io.*;
public class Main {

    static int ans;
    static int[] array = new int[10];
    static String N;

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        N = br.readLine();
        String[] NArray = N.split("");

        for(int i=0; i<NArray.length;i++){
            int n = Integer.parseInt(NArray[i]);
            array[n]++;
        }

        int sum = array[6]+array[9];
        if(sum%2==0){

            array[6] = sum/2;
            array[9] = sum/2;
        } else {
            array[6] = sum/2+1;
            array[9] = sum/2+1;
        }

        for(int i=0; i<10;i++){
            ans = Math.max(ans,array[i]);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}