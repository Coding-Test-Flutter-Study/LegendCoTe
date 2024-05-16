import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map = new int[8][8];

    static int[] king;
    static int[] rock;

    static int N;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingPosition = st.nextToken();
        int n1 = 8 - Integer.parseInt(String.valueOf(kingPosition.charAt(1)));
        int m1 = kingPosition.charAt(0) - 65;
        map[n1][m1] = 1;
        king = new int[]{n1, m1};

        String rockPosition = st.nextToken();
        int n2 = 8 - Integer.parseInt(String.valueOf(rockPosition.charAt(1)));
        int m2 = rockPosition.charAt(0) - 65;
        map[n2][m2] = 2;
        rock = new int[]{n2, m2};

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String direction = br.readLine();
            move(direction);
        }

        bw.write((char) (king[1] + 65) + String.valueOf(8 - king[0]) + "\n");
        bw.write((char) (rock[1] + 65) + String.valueOf(8 - rock[0]));

        bw.flush();
    }

    static void move(String direction) {

        if (direction.equals("R")) {

            int newKingN = king[0];
            int newKingM = king[1] + 1;
            int newRockN = rock[0];
            int newRockM = rock[1] + 1;

            go(newKingN, newKingM, newRockN, newRockM);

        } else if (direction.equals("L")) {
            int newKingN = king[0];
            int newKingM = king[1] - 1;
            int newRockN = rock[0];
            int newRockM = rock[1] - 1;

            go(newKingN, newKingM, newRockN, newRockM);

        } else if (direction.equals("B")) {
            int newKingN = king[0] + 1;
            int newKingM = king[1];
            int newRockN = rock[0] + 1;
            int newRockM = rock[1];

            go(newKingN, newKingM, newRockN, newRockM);

        } else if (direction.equals("T")) {
            int newKingN = king[0] - 1;
            int newKingM = king[1];
            int newRockN = rock[0] - 1;
            int newRockM = rock[1];

            go(newKingN, newKingM, newRockN, newRockM);

        } else if (direction.equals("RT")) {
            int newKingN = king[0] - 1;
            int newKingM = king[1] + 1;
            int newRockN = rock[0] - 1;
            int newRockM = rock[1] + 1;

            go(newKingN, newKingM, newRockN, newRockM);

        } else if (direction.equals("LT")) {
            int newKingN = king[0] - 1;
            int newKingM = king[1] - 1;
            int newRockN = rock[0] - 1;
            int newRockM = rock[1] - 1;

            go(newKingN, newKingM, newRockN, newRockM);

        } else if (direction.equals("RB")) {
            int newKingN = king[0] + 1;
            int newKingM = king[1] + 1;
            int newRockN = rock[0] + 1;
            int newRockM = rock[1] + 1;


            go(newKingN, newKingM, newRockN, newRockM);

        } else {
            int newKingN = king[0] + 1;
            int newKingM = king[1] - 1;
            int newRockN = rock[0] + 1;
            int newRockM = rock[1] - 1;

            go(newKingN, newKingM, newRockN, newRockM);

        }
    }


    static void go(int newKingN, int newKingM, int newRockN, int newRockM) {


        if (newKingN >= 0 && newKingM >= 0 && newKingN < 8 && newKingM < 8 && map[newKingN][newKingM] == 0) {
            map[king[0]][king[1]] = 0;
            map[newKingN][newKingM] = 1;
            king[0] = newKingN;
            king[1] = newKingM;
        } else if (newKingN >= 0 && newKingM >= 0 && newKingN < 8 && newKingM < 8 && map[newKingN][newKingM] == 2) {

            if (newRockN >= 0 && newRockM >= 0 && newRockN < 8 && newRockM < 8) {
                map[king[0]][king[1]] = 0;
                map[rock[0]][rock[1]] = 1;
                map[newRockN][newRockM] = 2;
                rock[0] = newRockN;
                rock[1] = newRockM;
                king[0] = newKingN;
                king[1] = newKingM;
            }
        }
    }

}