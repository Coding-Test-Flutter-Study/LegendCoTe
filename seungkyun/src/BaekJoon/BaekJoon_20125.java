import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;
    static String[][] array;
    static int heartX, heartY;

    static int leftArm,rightArm,leftLeg,rightLeg,torso;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        array = new String[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] strings = str.split("");
            for (int j = 0; j < N; j++) {
                array[i][j] = strings[j];
            }
        }

        findHead();

        findLength();

        bw.write((heartX+1)+" "+(heartY+1)+"\n"+leftArm+" "+rightArm+" "+torso+" "+leftLeg+" "+rightLeg);

        bw.flush();
    }

    static void findHead() {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (array[i + 1][j].equals("*") && array[i - 1][j].equals("*") && array[i][j + 1].equals("*") && array[i][j - 1].equals("*")) {
                    heartX = i;
                    heartY = j;
                }
            }
        }
    }

    static void findLength(){
        //leftArm
        for(int y=heartY-1;y>=0;y--){
            if(array[heartX][y].equals("*")){
                leftArm++;
            } else {
                break;
            }
        }

        //rightArm
        for(int y=heartY+1;y<N;y++){
            if(array[heartX][y].equals("*")){
                rightArm++;
            } else {
                break;
            }
        }
        //torso
        for(int x=heartX+1;x<N;x++){
            if(array[x][heartY].equals("*")){
                torso++;
            } else {
                break;
            }
        }

        //leftLeg
        for(int x=heartX+torso+1;x<N;x++){
            if(array[x][heartY-1].equals("*")){
                leftLeg++;
            } else {
                break;
            }
        }
        //rightLeg
        for(int x=heartX+torso+1;x<N;x++){
            if(array[x][heartY+1].equals("*")){
                rightLeg++;
            } else {
                break;
            }
        }
    }


}