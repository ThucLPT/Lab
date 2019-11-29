import socket
import time

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
host = ''
port = 9999
s.bind((host, port))

clients = []
quitting = False
print('Server started. Socket bind to port %s' % (port))

while not quitting:
    try:
        data, addr = s.recvfrom(1024)
        if 'Quit' in data.decode():
            quitting = True
        if addr not in clients:
            clients.append(addr)
        for client in clients:
            if client != addr:
                s.sendto(data, client)
        print(time.ctime(time.time()) + addr.decode() + '::' + data.decode())
    except:
        pass
s.close()