package BaekJoon;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BaekJoon_1764 {


    static HashSet<String> hashSet = new HashSet<>();
    static ArrayList<String> arrayList = new ArrayList<>();
    static int count;

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            hashSet.add(str);
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (hashSet.contains(str)) {
                arrayList.add(str);
                count++;
            }
        }


        Collections.sort(arrayList);
        bw.write(String.valueOf(count));
        for (String s : arrayList) {
            bw.write("\n");
            bw.write(s);
        }
        bw.flush();
    }
}

