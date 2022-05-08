#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<algorithm>
#include<string.h>
#include<stdlib.h>
#include<vector>
#include<ctype.h>
#include<math.h>
#include<stack>

using namespace std;

char arr[65][65];

bool making(int n, int startCol, int startRow) {
	int numOne = arr[startCol][startRow];

	for (int i = startCol; i < n + startCol; i++) {
		for (int j = startRow; j < n + startRow; j++) {
			if (numOne != arr[i][j])
				return false;
		}
	}
	return true;

}

void counting(int n, int startCol, int startRow) {
	
	if (!making(n, startCol, startRow)) {
		printf("(");
		counting(n / 2, startCol, startRow);
		counting(n / 2, startCol, startRow + n / 2);
		counting(n / 2, startCol + n / 2, startRow);
		counting(n / 2, startCol + n / 2, startRow + n / 2);
		printf(")");
	}
	else {
		if (arr[startCol][startRow] == '0')
			printf("0");
		else
			printf("1");
	}
	
	return;
}

int main(void) {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}
	counting(n, 0, 0);

	return 0;
}