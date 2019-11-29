import requests
import re
 
src = requests.get('http://www.pythonchallenge.com/pc/def/ocr.html').text
cmt = re.findall(r'<!--(.+?)-->', src, re.DOTALL)[1]
chars = re.findall(r'[a-z]', cmt)
print(''.join(chars))