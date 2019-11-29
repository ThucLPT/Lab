import random
num = random.randint(1, 100)
if num % 2 == 0:
    print('Random number: %d - Even' % (num))
else:
    print('Random number: %d - Odd' % (num))