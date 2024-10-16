class Solution {

    static int[][] map;
    static boolean[][]visited;
    static int[] dx = {0,0,2,-2};
    static int[] dy = {2,-2,0,0};

    public int solution(String dirs) {
        int answer = 0;

        map = new int[21][21];
        visited = new boolean[21][21];

        int nowX = 10;
        int nowY = 10;
        for(int i=0; i<dirs.length();i++){
            char dir = dirs.charAt(i);

            int newX = nowX;
            int newY = nowY;

            if(dir=='U'){
                newX = nowX+dx[0];
                newY = nowY+dy[0];
            } else if(dir=='D'){
                newX = nowX+dx[1];
                newY = nowY+dy[1];
            } else if(dir=='R'){
                newX = nowX+dx[2];
                newY = nowY+dy[2];
            } else {
                newX = nowX+dx[3];
                newY = nowY+dy[3];
            }

            if(newX>=0&&newY>=0&&newX<=20&&newY<=20){

                if(!visited[(newX+nowX)/2][(newY+nowY)/2]){
                    answer++;
                }

                visited[(newX+nowX)/2][(newY+nowY)/2]=true;

                nowX = newX;
                nowY = newY;
            }



        }
        return answer;
    }
}