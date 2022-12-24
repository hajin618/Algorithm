#include <iostream>
#include <vector>

using namespace std;

int arr[100003];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	int left = 0;
	int right = n - 1;
	
	int res = abs(arr[left] + arr[right]);
	int resA = arr[left];
	int resB = arr[right];

	while (left < right) {
		int tmp = arr[left] + arr[right];

		if (abs(tmp) < res) {
			res = abs(tmp);
			resA = arr[left];
			resB = arr[right];
		}

		if (tmp < 0) {
			left++;
		}
		else {
			right--;
		}
	}

	cout << resA << " " << resB;

	return 0;
}