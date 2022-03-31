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

vector<pair<int, int>> v;
vector<int> s2;
vector<int> ans;

int main(void) {
	
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back(make_pair(a, b));
	}
	sort(v.begin(), v.end());
	for (int i = 0; i < n; i++) {
		
		s2.push_back(v[i].second);
	}

	ans.push_back(s2[0]);

	
	for (int i = 1; i < n; i++) {
		if (ans.back() < s2[i])
			ans.push_back(s2[i]);
		else {
			auto it = lower_bound(ans.begin(), ans.end(), s2[i]);
			*it = s2[i];
		}
	}

	cout << n - ans.size();
	return 0;
}