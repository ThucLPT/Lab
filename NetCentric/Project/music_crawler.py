import bs4
import codecs
import json
import re
import requests

url = input('URL: ')
song_list = []

src = requests.get(url).text
soup = bs4.BeautifulSoup(src, 'lxml')
ul = soup.find('ul', class_='list_show_chart').find_all('a', class_='name_song')

for li in ul:
    src = requests.get(li['href']).text
    soup = bs4.BeautifulSoup(src, 'lxml')

    xml_url = re.search(r'player.peConfig.xmlURL = "(.+)";', src).group(1)
    xml_src = requests.get(xml_url).text
    xml_soup = bs4.BeautifulSoup(xml_src, 'xml')

    Id = xml_soup.find('key').text.strip()
    title = xml_soup.find('title').text.strip()
    stream = xml_soup.find('location').text.strip()

    info = {
        'id': Id,
        'title': title,
        'stream': stream
    }

    if url.split('/')[3] == 'bai-hat':
        thumbnail = xml_soup.find('coverimage').text.strip()
        singer = xml_soup.find('creator').text.strip()
        lyric = xml_soup.find('lyric').text.strip()

        info['thumbnail'] = thumbnail
        info['singer'] = singer
        info['lyric'] = lyric

    if url.split('/')[3] == 'video':
        thumbnail = xml_soup.find('image').text.strip()
        singer = xml_soup.find('singer').text.strip()

        info['thumbnail'] = thumbnail
        info['singer'] = singer

    song_list.append(info)

with codecs.open('music_info.json', 'w', 'utf-8') as f:
    json.dump(song_list, f, ensure_ascii=False, indent=2)