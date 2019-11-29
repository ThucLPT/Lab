#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <stdbool.h>
#include <string.h>

void rev(char* arr) {
	int len = strlen(arr);
	for (int i = 0; i < len / 2; i++) {
		char temp = arr[i];
		arr[i] = arr[len - 1 - i];
		arr[len - 1 - i] = temp;
	}
}

void *toBin(void* number_ptr) {
	char* number = number_ptr;
	int count = 0;
	char result[100];
	int copy_num = atoi(number);
	int temp = copy_num;
	while (copy_num) {
		result[count++] = copy_num % 2 + 48;
		copy_num /= 2;
	}
	result[count] = '\0';
	rev(result);
	printf("%d is %s in binary\n", temp, result);
	return NULL;
}

int main(int argc, char* argv[]) {
	pthread_t thread[100];
	for (int i = 1; i < argc; i++) {
		pthread_create(&thread[i], NULL, toBin, (void *) argv[i]);
	}
	for (int i = 1; i < argc; i++) {
		pthread_join(thread[i], NULL);
	}
	return 0;
}
