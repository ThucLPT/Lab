import requests
import bs4

url = 'https://vnexpress.net/tin-tuc/khoa-hoc/san-pham-cong-nghe/robot-lai-may-bay-co-the-thay-the-phi-cong-3500354.html'
src = requests.get(url).text
soup = bs4.BeautifulSoup(src, 'lxml')
p = soup.find_all('p', class_ = 'Normal')
for i in p:
    print(i.text)