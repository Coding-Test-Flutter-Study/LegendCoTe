class Solution {
    static int[] nowLeftHand,nowRightHand;

    public String solution(int[] numbers, String hand) {

        String ans="";
        nowLeftHand = new int[]{0,3};
        nowRightHand = new int[]{2,3};

        for(int i=0; i<numbers.length;i++){
            int I = numbers[i];

            if(I==1||I==4||I==7){
                ans+="L";
                nowLeftHand = new int[]{0,(I-1)/3};
            } else if(I==3||I==6||I==9){
                ans+="R";
                nowRightHand = new int[]{2,(I/3)-1};
            } else {
                if(I==0){
                    ans+=distance(new int[]{1,3},hand);
                } else {
                    ans+=distance(new int[]{1,(I-2)/3},hand);
                }
            }
        }

        return ans;
    }

    static String distance(int[] I, String hand){

        int disL = Math.abs(I[0]-nowLeftHand[0])+ Math.abs(I[1]-nowLeftHand[1]);
        int disR = Math.abs(I[0]-nowRightHand[0])+ Math.abs(I[1]-nowRightHand[1]);

        if(disL==disR){
            if(hand.equals("right")){
                nowRightHand = I;
                return "R";
            } else {
                nowLeftHand = I;
                return "L";
            }
        } else if(disL>disR){
            nowRightHand = I;
            return "R";
        } else {
            nowLeftHand = I;
            return "L";
        }
    }
}