class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];


        if(n>s){
            return new int[]{-1};
        }

        int i=0;
        while(true){
            int num = s/n;
            answer[i] =num;
            s-=num;
            if(s==0){
                break;
            }
            i++;
            n--;
        }
        return answer;
    }
}