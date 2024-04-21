package BaekJoon;

import java.io.*;
import java.util.*;

public class BaekJoon_18870 {


        static ArrayList<Long> arrayList = new ArrayList<>();

        static long[] array;
        static HashSet<Long> hashSet = new HashSet<>();
        static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public static void main(String[] args) throws IOException {

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            array = new long[N];

            for (int i = 0; i < N; i++) {
                long X = Long.parseLong(st.nextToken());
                hashSet.add(X);
                array[i] = X;
            }

            arrayList.addAll(hashSet);

            Collections.sort(arrayList);

            for (int i = 0; i < N; i++) {
                bw.write(binarySearch(array[i], 0, arrayList.size() - 1) + " ");
            }

            bw.flush();
        }

        static int binarySearch(long key, int low, int high) {

            int mid;

            if (low <= high) {
                mid = (low + high) / 2;

                if (key == arrayList.get(mid)) {
                    return mid;
                } else if (key < arrayList.get(mid)) {
                    return binarySearch(key, low, mid - 1);
                } else {
                    return binarySearch(key, mid + 1, high);
                }
            }
            return 0;
        }




}
