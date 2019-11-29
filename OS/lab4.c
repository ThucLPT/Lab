#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>

sem_t semaphore;
int in = 0, out = 0, array[10] = { 0 };

void *producer(void* producerId) {
	int id = (long) producerId;
	while (1) {
		sem_wait(&semaphore);
		if (in > 9) {
			printf("The buffer is full for producer %d to produce\n", id);
			sem_post(&semaphore);
			pthread_exit(NULL);
		}
		int newVal = rand();
		array[in] = newVal;
		printf("Producer %d produce value %d at index %d\n", id, newVal, in);
		in++;
		sem_post(&semaphore);
	}
}

void *consumer(void* consumerId) {
	int id = (long) consumerId;
	while (1) {
		sem_wait(&semaphore);
		if (out > 9) {
			printf("The buffer is empty for consumer %d to consume\n", id);
			sem_post(&semaphore);
			pthread_exit(NULL);
		}
		if (out == in) {
			sem_post(&semaphore);
			continue;
		}
		int takenValue = array[out];
		printf("Consumer %d take value %d at index %d\n", id, takenValue, out);
		out++;
		sem_post(&semaphore);
	}
}

int main() {
	srand(time(NULL));
	sem_init(&semaphore, 0, 1);
	pthread_t t1, t2, t3, t4;
	pthread_create(&t1, NULL, producer, (void *) 1);
	pthread_create(&t2, NULL, producer, (void *) 2);
	pthread_join(t1, NULL);
	pthread_join(t2, NULL);
	pthread_create(&t3, NULL, consumer, (void *) 1);
	pthread_create(&t4, NULL, consumer, (void *) 2);
	pthread_join(t3, NULL);
	pthread_join(t4, NULL);
	sem_destroy(&semaphore);
	return 0;
}
