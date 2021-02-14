import jpysocket
import codecs

soc = jpysocket.jpysocket()
host = ""
port = 1999
soc.bind(('', port))  # Bind to the port
soc.listen(5)
try:
    while True:
        conn, addr = soc.accept()  # Establish connection with client.
        print("Got connection from", addr)
        msg = conn.recv(1024)
        msg = codecs.decode(msg, 'utf-8')
        print(msg)
        if (msg == "Hello"):
            conn.send(jpysocket.jpyencode("facepalm chel ty v mute"))
            print("norm chel")
        else:
            conn.send(jpysocket.jpyencode("ladno)"))
            print("stupid fuck")
except KeyboardInterrupt:
    exit(0)
