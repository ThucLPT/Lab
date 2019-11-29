#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <stdbool.h>
#include <string.h>
#include <unistd.h>

typedef struct philosopher {
	sem_t *plate, *fork, *room;
	int index, total;
} philo;

void init(philo *data, int index, int total, sem_t *plate, sem_t *fork, sem_t *room) {
	data->plate = plate;
	data->fork = fork;
	data->room = room;
	data->index = index;
	data->total = total;
}

void* eat(void* philosopher) {
	philo* plsp = (philo*) philosopher;
	int index = plsp->index;
	int total = plsp->total;
	while (1) {
		sem_wait(plsp->room);
		sem_wait(&plsp->fork[index]);
		sem_wait(&plsp->fork[(index + 1) % total]);
		sem_wait(plsp->plate);
		printf("Philosopher %d has 2 forks and start eating\n", index);
		sleep(5);
		sem_post(plsp->plate);
		sem_post(&plsp->fork[(index + 1) % total]);
		sem_post(&plsp->fork[index]);
		sem_post(plsp->room);
		sleep(1);
	}
}

int main(int argc, char* argv[]) {
	int n = atoi(argv[1]);
	sem_t room, plate, fork[n];
	pthread_t t[n];
	sem_init(&plate, 0, n / 2);
	sem_init(&room, 0, n - 1);
	for (int i = 0; i < n + 1; i++) {
		sem_init(&fork[i], 0, 1);
	}
	philo philosopher[n];
	for (int i = 0; i < n; i++) {
		init(&philosopher[i], i, n, &plate, &room, fork);
	}
	for (int i = 0; i < n; i++) {
		pthread_create(&t[i], NULL, eat, (void *) &philosopher[i]);
	}
	for (int i = 0; i < n; i++) {
		pthread_join(t[i], NULL);
	}
	return 0;
}
