import requests
import re

src = requests.get('http://www.pythonchallenge.com/pc/def/equality.html').text
cmt = re.findall(r'<!--(.+?)-->', src, re.DOTALL)[0]
small = re.findall(r'[a-z]+[A-Z]{3}([a-z])[A-Z]{3}[a-z]+', cmt)
print(''.join(small))