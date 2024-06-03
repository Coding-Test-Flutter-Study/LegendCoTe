import java.io.*;
import java.util.HashSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ans;
    static int N;
    static String[] romanNum = {"I", "V", "X", "L"};
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        find("", 0,0);
        ans = hashSet.size();
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void find(String string, int count,int I) {

        if (count == N) {
            calculate(string);
            return;
        }

        for (int i = I; i < 4; i++) {
            find(string + romanNum[i], count + 1,i);
        }
    }

    static void calculate(String string) {
        int sum = 0;

        String[] strings = string.split("");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("I")) {
                sum += 1;
            } else if (strings[i].equals("V")) {
                sum += 5;
            } else if (strings[i].equals("X")) {
                sum += 10;
            } else if (strings[i].equals("L")) {
                sum += 50;
            }
        }
        hashSet.add(sum);
    }
}