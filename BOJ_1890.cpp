//1890
#include<iostream>

using namespace std;

int arr[110][110];
long long int dp[110][110];

void jump(int n) {
	dp[0][0] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == n - 1 && j == n - 1)
				return;
			dp[i + arr[i][j]][j] += dp[i][j];
			dp[i][j + arr[i][j]] += dp[i][j];
		}
	}
}
int main(void) {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}
	jump(n);
	cout << dp[n - 1][n - 1];

	return 0;
}