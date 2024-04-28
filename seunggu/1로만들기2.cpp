#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 1000001

using namespace std;

pair<int, vector<int>> dp[MAX];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;

    dp[1].first = 0;
    dp[1].second = {1};

    for(int i = 2; i <= N; i++) {
        int temp;
        dp[i].first = dp[i-1].first + 1;
        temp = i-1;
        if(i%3 == 0 && dp[i/3].first + 1 < dp[i].first) {
            dp[i].first = dp[i/3].first + 1;
            temp = i/3;
        }
        if(i%2 == 0 && dp[i/2].first + 1 < dp[i].first) {
            dp[i].first = dp[i/2].first + 1;
            temp = i/2;
        }
        dp[i].second.push_back(i);
        dp[i].second.insert(dp[i].second.begin(), dp[temp].second.begin(), dp[temp].second.end());
    }
    cout << dp[N].first << "\n";
    sort(dp[N].second.begin(), dp[N].second.end(), greater<>());
    for(auto &i : dp[N].second) cout << i << " ";
}