#include <iostream>

#define MAX 100001

using namespace std;

int dp[MAX];

int main() {
    int n;
    cin >> n;

    dp[1] = -1;
    dp[2] = 1;
    dp[3] = -1;
    dp[4] = 2;
    dp[5] = 1;

    for(int i = 6; i <= n; i++) {
        if(dp[i-2] == -1 && dp[i-5] != -1) {
            dp[i] = dp[i-5] + 1;
        } else if(dp[i-2] != -1 && dp[i-5] == -1) {
            dp[i] = dp[i-2] + 1;
        } else if(dp[i-2] != -1 && dp[i-5] != -1) {
            dp[i] = min(dp[i-2], dp[i-5]) + 1;
        } else if(dp[i-2] == -1 && dp[i-5] == -1) {
            dp[i] = -1;
        }
    }

    cout << dp[n];
}