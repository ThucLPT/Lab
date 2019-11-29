import socket
import threading
import time

shutdown = False


def receive(name, sock):
    while not shutdown:
        try:
            while 1:
                data, addr = sock.recvfrom(1024)
                print(data.decode())
        except:
            pass

        
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
host = socket.gethostname()
port = 9999
server = (host, port)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.bind(server)

for i in range(5):
    threading.Thread(target=receive, args=('RecvThread', s)).start()
name = input('Name: ')
msg = input(name + ' -> ')

while msg != 'q':
    if msg != '':
        s.sendto((name + ': ' + msg).encode(), server)
    msg = input(name + ' -> ')
    time.sleep(0.1)

shutdown = True
s.close()