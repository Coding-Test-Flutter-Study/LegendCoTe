#include <iostream>
#include <algorithm>

#define MAX 501

using namespace std;

int dp[MAX][MAX];

int main() {
    int N;
    cin >> N;
    for(int i = 1; i <= N; i++) {
        for(int j = 0; j < i; j++) {
            cin >> dp[i][j];
        }
    }

    for(int i = 2; i <= N; i++) {
        for(int j = 0; j < i; j++) {
            if(j == 0) {
                dp[i][j] += dp[i-1][j];
            } else if(j == N-1) {
                dp[i][j] += dp[i-1][j-1];
            } else {
                dp[i][j] += max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
    }

    cout << *max_element(dp[N], dp[N] + N);
}