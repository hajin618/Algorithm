//11048

#include<iostream>

using namespace std;

int dp[1001][1001];
int candy[1001][1001];
int n, m;

void move() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]) + candy[i][j];
		}
	}
}

int main(void) {
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> candy[i][j];
		}
	}
	move();
	cout << dp[n][m];

	return 0;
}