#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;
	int width, max_width, min_width, height, max_height, min_height;
	int dir;

	cin >> t;

	for (int i = 0; i < t; i++) {
		string s;
		width = 0;
		max_width = 0;
		min_width = 0;
		height = 0;
		max_height = 0;
		min_height = 0;
		dir = 0;	// 0 : x축 +
					// 1 : y축 -
					// 2 : x축 -
					// 3 : y축 +

		cin >> s;
		
		for (int j = 0; j < s.size(); j++) {
			if (s[j] == 'R') {
				dir += 1;
			}
			else if (s[j] == 'L') {
				dir -= 1;
			}
			else {
				if (dir < 0) {
					while (dir < 0) {
						dir += 4;
					}
				}
				else if (dir >= 4) {
					while (dir >= 4) {
						dir -= 4;
					}
				}

				if (s[j] == 'F') {
					if (dir == 0) {
						width += 1;
					}
					else if (dir == 1) {
						height -= 1;
					}
					else if (dir == 2) {
						width -= 1;
					}
					else if (dir == 3) {
						height += 1;
					}
				}
				else if (s[j] == 'B') {
					if (dir == 0) {
						width -= 1;
					}
					else if (dir == 1) {
						height += 1;
					}
					else if (dir == 2) {
						width += 1;
					}
					else if (dir == 3) {
						height -= 1;
					}
				}
				if (width > max_width)
					max_width = width;
				if (width < min_width)
					min_width = width;
				if (height > max_height)
					max_height = height;
				if (height < min_height)
					min_height = height;
			}
		}

		cout << (max_width - min_width) * (max_height - min_height) << "\n";

	}

	return 0;
}