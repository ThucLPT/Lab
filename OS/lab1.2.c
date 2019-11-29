#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool prime[10000 + 5] = { 0 };

void init() {
	prime[1] = 1;
	int i = 0;
	for (i = 2; i < 10000; i++) {
		if (prime[i] == 0) {
			int next = i * 2;
			while (next < 10000) {
				prime[next] = 1;
				next += i;
			}
		}
	}
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
	init();
	int i;
	for (i = 1; i < argc; i++) {
		if (!isIntNum(argv[i])) {
			printf("%s is not an integer number\n", argv[i]);
			continue;
		}
		int num = atoi(argv[i]);
		if (num >= 10000) {
			printf("%d is too large\n", num);
			continue;
		}
		if (num < 1) {
			printf("invalid input\n");
			continue;
		}
		if (!prime[num])
			printf("%d is a prime\n", num);
		else
			printf("%d is not a prime\n", num);
	}
	return 0;
}
