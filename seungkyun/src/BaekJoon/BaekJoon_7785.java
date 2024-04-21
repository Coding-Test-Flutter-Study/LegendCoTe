package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BaekJoon_7785 {
    static HashSet<String> enter = new HashSet<>();
    static HashSet<String> leave = new HashSet<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                enter.add(name);
                leave.remove(name);

            } else {
                leave.add(name);
                enter.remove(name);
            }

        }
        String[] ans = new String[enter.size()];

        Iterator<String> iterator = enter.iterator();
        for (int i = 0; i < ans.length; i++) {
            ans[i] = iterator.next();
        }

        Arrays.sort(ans);
        for (int i = ans.length - 1; i >= 0; i--) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }
}
