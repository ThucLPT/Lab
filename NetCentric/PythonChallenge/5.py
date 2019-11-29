import requests
import bs4
import pickle

html = requests.get('http://www.pythonchallenge.com/pc/def/peak.html').text
soup = bs4.BeautifulSoup(html, 'lxml')
peakhell = soup.find('peakhell').attrs['src']
url = 'http://www.pythonchallenge.com/pc/def/' + peakhell
src = requests.get(url).content
data = pickle.loads(src)
for line in data:
    print(''.join([k * v for k, v in line]))