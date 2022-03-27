//2156
#include<iostream>

using namespace std;

int dp[10001];
int wine[10001];
int n;

void func() {
	dp[1] = wine[1];
	dp[2] = dp[1] + wine[2];

	for (int i = 3; i <= n; i++) {
		dp[i] = max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]);
		dp[i] = max(dp[i - 1], dp[i]);
	}
}
int main(void) {
	
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> wine[i];
	}
	func();
	cout << dp[n];

	return 0;
}