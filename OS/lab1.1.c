#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

void toBinary(int x, char *ans) {
	int len = 0;
	while (x) {
		ans[len] = '0' + x % 2;
		x /= 2;
		len++;
	}

	int i;
	for (i = 0; i < len / 2; i++) {
		char temp = ans[i];
		ans[i] = ans[len - 1 - i];
		ans[len - 1 - i] = temp;
	}
	ans[len] = '\0';
}

bool isIntNum(char *num) {
	int i;
	for (i = 0; i < strlen(num); i++) {
		if (num[i] < '0' || num[i] > '9')
			return false;
	}
	return true;
}

int main(int argc, char *argv[]) {
	char ans[1000];
	int i = 0;
	for (i = 1; i < argc; i++) {
		if (!isIntNum(argv[i])) {
			printf("%s is not an integer number\n", argv[i]);
			continue;
		}
		int num = atoi(argv[i]);
		toBinary(num, ans);
		printf("%d is %s in binary\n", num, ans);
	}
	return 0;
}
