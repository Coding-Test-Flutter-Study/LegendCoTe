import java.util.PriorityQueue;
import java.util.Iterator;


class Solution {

    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    static int answer;
    static boolean ok;

    public int solution(int[] scoville, int K) {

        for(int i=0; i<scoville.length;i++){
            priorityQueue.offer(scoville[i]);
        }

        ok = true;

        while(ok){

            Iterator<Integer> iterator = priorityQueue.iterator();

            while(iterator.hasNext()){

                int n = iterator.next();
                if(n<K&&priorityQueue.size()>=2){
                    mix();
                    ok = true;
                    answer++;
                    break;
                } else if(n<K&&priorityQueue.size()<2){
                    return -1;
                } else {
                    ok = false;
                }
            }

        }

        return answer;
    }

    static void mix(){

        int a = priorityQueue.poll();
        int b = priorityQueue.poll();

        priorityQueue.offer(a+b*2);

    }
}