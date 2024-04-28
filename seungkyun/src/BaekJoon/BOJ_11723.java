import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("add")) {
                String x = st.nextToken();
                if (!arrayList.contains(x)) {
                    arrayList.add(x);
                }
            } else if (str.equals("remove")) {
                String x = st.nextToken();
                arrayList.remove(x);
            } else if (str.equals("check")) {
                String x = st.nextToken();
                if (arrayList.contains(x)) {
                    bw.write("1"+"\n");
                } else {
                    bw.write("0"+"\n");
                }

            } else if (str.equals("toggle")) {
                String x = st.nextToken();
                if (arrayList.contains(x)) {
                    arrayList.remove(x);
                } else {
                    arrayList.add(x);
                }

            } else if (str.equals("all")) {

                arrayList.clear();
                for (int x = 1; x <= 20; x++) {
                    arrayList.add(String.valueOf(x));
                }

            } else {

                arrayList.clear();
            }

        }

        bw.flush();
    }


}