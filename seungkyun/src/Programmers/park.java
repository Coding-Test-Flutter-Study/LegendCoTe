import java.util.*;

class Solution {
    static Character[][] map;
    static int N,M;
    static int x,y;
    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        map = new Character[N][M];

        for(int i=0; i<N;i++){
            String str = park[i];
            for(int j=0; j<M;j++){
                map[i][j]= str.charAt(j);
                if(map[i][j]=='S'){
                    x=i;
                    y=j;
                }
            }
        }


        for(int i=0; i<routes.length;i++){
            String[] route = routes[i].split(" ");
            String direction = route[0];
            int length = Integer.parseInt(route[1]);
            move(direction,length);
        }


        int[] answer = {x,y};
        return answer;
    }

    static void move(String direction,int length){
        int newX,newY;

        if(direction.equals("N")){
            newX = x-length;
            newY = y;

            if(newX>=0&&newY>=0&&newX<N&&newY<M){
                for(int i = newX;i<=x;i++){
                    if(map[i][newY]=='X'){
                        return;
                    }
                }
                x = newX;
                y = newY;
            }
        } else if(direction.equals("S")){
            newX = x+length;
            newY = y;

            if(newX>=0&&newY>=0&&newX<N&&newY<M) {
                for (int i = x; i <= newX; i++) {
                    if (map[i][newY] == 'X') {
                        return;
                    }
                }
                x = newX;
                y = newY;
            }
        } else if(direction.equals("W")){

            newX = x;
            newY = y-length;

            if(newX>=0&&newY>=0&&newX<N&&newY<M){
                for(int i = newY;i<=y;i++){
                    if(map[newX][i]=='X'){
                        return;
                    }
                }
                x = newX;
                y = newY;
            }
        }else if(direction.equals("E")){

            newX = x;
            newY = y+length;

            if(newX>=0&&newY>=0&&newX<N&&newY<M){
                for(int i = y;i<=newY;i++){
                    if(map[newX][i]=='X'){
                        return;
                    }
                }
                x = newX;
                y = newY;
            }
        }
    }

}