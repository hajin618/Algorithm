// LIS : 가장 긴 증가하는 부분 수열

// 1. DP 이용 : O(n^2)
// 2. 이분탐색 이용 : O(nlogn)

/*

1. DP 이용 - dp 배열에는 arr[i]를 마지막 원소로 가지는 최대 증가수열의 길이 저장

for (int i = 0; i < n; i++) {
	dp[i] = 1;
	for (int j = 0; j < i; j++) {
		if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
			dp[i] = dp[j] + 1;
		}
	}
	ans = max(ans, dp[i]);
}
cout << ans;

*/

/*

2. 이분탐색 이용 - 처음부터 n까지 차례로 탐색, LIS 배열을 유지하기 위한 최적의 위치에 수를 삽입
					벡터의 마지막 값보다 탐색 값이 크면 벡터에 push_back, 작다면 lower_bound 이용 최적의 자리에 값 교체
					**유지되는 LIS 배열은 실제 LIS 수열과 다르다. 크기 구할 때만 사용**
					
*/

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
#include<string>

using namespace std;

int arr[1000001];
vector<int> v;

int main(void) {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	v.push_back(arr[0]);

	for (int i = 1; i < n; i++) {
		if (v.back() < arr[i])
			v.push_back(arr[i]);
		else {
			auto it = lower_bound(v.begin(), v.end(), arr[i]);
			*it = arr[i];
		}
	}

	cout << v.size();

	return 0;
}