h = int(input('Height: '))
w = int(input('Width: '))
print('*' * w)
for i in range(h - 2):
    print('' + '  ' * (w - 2) + '*')
print('*' * w)