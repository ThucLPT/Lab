import zipfile
import re

z = zipfile.ZipFile('channel.zip')
num = '90052'
cmt_list = []
while 1:
    content = z.read(num + '.txt').decode()
    cmt = z.getinfo(num + '.txt').comment.decode()
    cmt_list.append(cmt)
    if 'Next' not in content:
        break
    num = ''.join(re.findall(r'\d', content))
print(''.join(cmt_list))