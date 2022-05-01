#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<algorithm>
#include<string.h>
#include<stdlib.h>
#include<vector>
#include<math.h>
#include<stack>
#include<map>
#include<queue>
#include<deque>

using namespace std;

int arr[100001];

int main(void) {
	int t;
	int a, b;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int n;
		int ans = 1;
		cin >> n;
		for (int j = 0; j < n; j++) {
			cin >> a >> b;
			arr[a] = b;
		}

		int max = arr[1];

		for (int k = 2; k <= n; k++) {
			if (max > arr[k]) {
				max = arr[k];
				ans++;
			}
		}
		cout << ans << "\n";
		
	}
	return 0;
}