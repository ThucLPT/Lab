import requests
import bs4

intab = 'abcdefghijklmnopqrstuvwxyz'
outtab = intab[2:] + intab[:2]
trantab = str.maketrans(intab, outtab)

src = requests.get('http://www.pythonchallenge.com/pc/def/map.html').text
soup = bs4.BeautifulSoup(src, 'lxml')
font = soup.find('font', color='#f000f0').text

print(font.translate(trantab))
print('map'.translate(trantab))