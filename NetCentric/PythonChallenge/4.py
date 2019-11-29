import requests
import bs4
import re

src = requests.get('http://www.pythonchallenge.com/pc/def/linkedlist.php').text
soup = bs4.BeautifulSoup(src, 'lxml')
a = soup.find('a')
href = 'http://www.pythonchallenge.com/pc/def/' + a.attrs['href']
text = requests.get(href).text
num = ''.join(re.findall(r'\d', text))
while 1:
    url = 'http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=' + num
    src = requests.get(url).text
    print(src)
    if 'next' not in src:
        break
    num = ''.join(re.findall(r'\d', src))
num = int(num) / 2
while 1:
    url = 'http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=' + str(num)
    src = requests.get(url).text
    print(src)
    if 'next' not in src:
        break
    num = re.search(r'and the next nothing is (\d+)', src).group(1)