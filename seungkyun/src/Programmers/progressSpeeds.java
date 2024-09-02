import java.util.*;

class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public int[] solution(int[] progresses, int[] speeds) {


        for(int i=0;i<speeds.length;i++){
            queue.offer(new int[]{progresses[i],speeds[i]});
        }

        while(!queue.isEmpty()){

            int total =0;

            for(int i=0; i<queue.size();i++){
                int[] poll = queue.poll();
                queue.offer(new int[]{poll[0]+poll[1],poll[1]});
            }


            boolean ok = true;

            while(ok){
                if(!queue.isEmpty()){
                    if(queue.peek()[0]>=100){

                        queue.poll();
                        total++;
                    } else {
                        ok= false;
                    }
                } else {
                    ok =false;
                }

            }
            if(total!=0){
                arrayList.add(total);

            }

        }
        int[] answer = new int[arrayList.size()];
        for(int i=0; i<answer.length;i++){
            answer[i]=arrayList.get(i);
        }

        return answer;
    }
}