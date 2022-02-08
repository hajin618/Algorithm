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

vector < pair<int, int>> v;

bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second == b.second)
		return a.first < b.first;
	else
		return a.second < b.second;
}

int main(void) {
	int n;
	int a, b;
	int cnt = 1;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		v.push_back(make_pair(a, b));
	}
	sort(v.begin(), v.end(), compare);

	int endpoint = v[0].second;
	for (int i = 1; i < n; i++) {
		if (v[i].first < endpoint)
			continue;
		else {
			endpoint = v[i].second;
			cnt++;
		}
	}
	cout << cnt;

	return 0;
}