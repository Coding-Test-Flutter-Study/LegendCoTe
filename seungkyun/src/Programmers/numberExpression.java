class Solution {
    static int ans =0;
    public int solution(int n) {


        slidingWindow(n);

        return ans;
    }

    static void slidingWindow(int n){

        int left = 0;
        int right = 0;
        int sum = 0;

        while(left<=n){

            if(sum<n){
                right++;
                sum+=right;
            } else if (sum>n) {
                sum-=left;
                left++;
            } else {
                ans++;
                right++;
                sum+=right;
            }
        }


    }
}