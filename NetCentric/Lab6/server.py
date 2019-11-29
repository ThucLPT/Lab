import socket
import os
import re
 
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = 'localhost'
port = 9999
s.bind((host, port))
s.listen(1)
 
html = 'HTTP/1.1 200 OK\r\nContent-Length: {0}\r\nContent-Type: text/html\r\n\n{1}'
html_size = os.stat('index.html').st_size
f = open('index.html').read()
 
pic = 'HTTP/1.1 200 OK\r\nContent-Length: {0}\r\nContent-Type: image/png\r\n\n{1}'
pic_size = os.stat('hcmiu_logo.png').st_size
i = open('hcmiu_logo.png', 'rb').read()
 
while 1:
    client, addr = s.accept()
    data = client.recv(1024)
    if len(re.findall(r'GET', data.decode())):
        client.send(html.format(html_size, f).encode())
        client.send(pic.format(pic_size, i).encode())