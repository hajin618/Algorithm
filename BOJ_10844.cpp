#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<algorithm>
#include<string.h>
#include<string>
#include<stdlib.h>
#include<vector>
#include<math.h>
#include<stack>
#include<map>
#include<queue>
#include<deque>

using namespace std;

long long int dp[101][10];

int main(void) {
	int n;
	cin >> n;
	
	for (int i = 1; i < 10; i++) {
		dp[1][i] = 1;
	}

    for (int i = 2; i <= n; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0)
                dp[i][0] = dp[i - 1][j + 1];
            else if (j == 9)
                dp[i][9] = dp[i - 1][j - 1];
            else
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];

            dp[i][j] %= 1000000000;
        }
    }

    int ans = 0;
    for (int i = 0; i < 10; i++) {
        ans = (ans + dp[n][i]) % 1000000000;
    }
    cout << ans;
	return 0;
}