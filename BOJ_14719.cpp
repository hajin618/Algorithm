#include <iostream>
#include <vector>

using namespace std;

vector<int> v;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int h, w, a;
	int ans = 0;
	int left_max, right_max;

	cin >> h >> w;

	for (int i = 0; i < w; i++) {
		cin >> a;
		v.push_back(a);
	}
	
	for (int i = 1; i < w - 1; i++) {
		left_max = 0;
		right_max = 0;
		
		// 왼쪽 중 최대
		for (int j = 0; j < i; j++) {
			left_max = max(left_max, v[j]);
		}
		
		// 오른쪽 중 최대
		for (int j = i + 1; j < w; j++) {
			right_max = max(right_max, v[j]);
		}

		ans += max(0, min(left_max, right_max) - v[i]);
	}

	cout << ans;

	return 0;
}