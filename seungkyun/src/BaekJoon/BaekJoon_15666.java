import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static HashSet<Integer> hashSet = new HashSet<Integer>();

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        StringTokenizer stringTokenizer2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(stringTokenizer2.nextToken());
            if (!arrayList.contains(n)) {
                arrayList.add(n);
            }
        }

        Collections.sort(arrayList);
        dfs(0, "", 0);

        bw.flush();
    }

    static void dfs(int count, String ans, int start) throws IOException {

        if (count == M) {
            bw.write(ans + "\n");
            return;
        }

        for (int i = start; i < arrayList.size(); i++) {
            dfs(count + 1, ans + String.valueOf(arrayList.get(i)) + " ", i);
        }
    }

}