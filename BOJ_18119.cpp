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

int arr[10000] = { 0, };
int n = 0, m = 0;
int remember = 0;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);

	cin >> n >> m;
	
	for (int i = 0; i < 26; i++)
		remember |= (1 << i);

	string temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		for (int j = 0; j < temp.size(); j++) 
			arr[i] |= (1 << (temp[j] - 'a'));
		
	}

	int a;
	char b;
	while (m--) {
		int result = 0;
		cin >> a >> b;

		remember ^= (1 << (b - 'a'));

		for (int i = 0; i < n; i++)
			if ( (arr[i] & remember) == arr[i])
				result++;
		cout << result << "\n";

	}

	return 0;
}