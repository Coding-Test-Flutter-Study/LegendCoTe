import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int origin;
    static int ans;


    public static void main(String[] args) throws IOException {

        origin = Integer.parseInt(br.readLine());

        cycle(origin);

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void cycle(int n) {


        int newNum;

        if (n < 10) {
            newNum = n * 10 + n;
        } else {
            newNum = (n % 10) * 10 + (n / 10 + n % 10) % 10;
        }
        ans++;
        if (newNum == origin) {
            return;
        }
        cycle(newNum);

    }

}