import java.util.*;

class Solution {

    static Stack<Integer> bucket = new Stack<>();
    static int ans = 0;


    public int solution(int[][] board, int[] moves) {


        for(int j=0; j<moves.length;j++){
            int lineNum = moves[j]-1;
            int now =0;

            for(int i=0; i<board.length;i++){
                if(board[i][lineNum]!=0){
                    now = board[i][lineNum];
                    board[i][lineNum]=0;
                    break;
                }
            }

            if(now!=0){
                add(now);
            }

        }

        return ans;
    }

    static void add(int now){

        if(bucket.isEmpty()){
            bucket.push(now);
        } else {
            if(bucket.peek()==now){
                bucket.pop();
                ans +=2;
            } else {
                bucket.push(now);
            }
        }
    }
}