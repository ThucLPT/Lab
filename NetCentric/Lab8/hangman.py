import random
import re

rand_line = random.choice(open('words.txt').readlines())
word = re.search(r'(.+)(\t)(.+)', rand_line).group(1)
desc = re.search(r'(.+)(\t)(.+)', rand_line).group(3)
print('Description: ' + desc)

score = 0
guesses = ''
turns = len(word.replace(' ', ''))

while turns > 0:
    fail = 0
    for char in word:
        if char == ' ':
            print(' ', end=' ')
        else:
            if char.lower() in guesses:
                print(char, end=' ')
            else:
                print('_', end=' ')
                fail += 1
    print('\nScore: ' + str(score))
    if fail == 0:
        print('You won')
        break
    while 1:
        guess = input('Guess a character: ')
        if guess in guesses:
            print('Already guessed')
        else:
            break
    guesses += guess
    if guess not in word.lower():
        turns -= 1
        print('Wrong guess. You have ' + str(turns) + ' more guess')
        if turns == 0:
            print('You lose')
    else:
        score = score + word.lower().count(guess) * 100