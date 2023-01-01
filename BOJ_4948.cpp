#include <iostream>
#include <vector>

using namespace std;

bool arr[246920];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;

	arr[1] = true;

	for (int i = 2; i * i <= 246920; i++) {
		if (!arr[i]) {
			for (int j = 2; j * i <= 246920; j++) {
				arr[i * j] = true;
			}
		}
	}

	while (true) {
		cin >> n;
		
		if (n == 0)
			break;
		
		int cnt = 0;
		
		for (int i = n + 1; i <= 2 * n; i++) {
			if (!arr[i])
				cnt++;
		}

		cout << cnt << "\n";
	}

	return 0;
}