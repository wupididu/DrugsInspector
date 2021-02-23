import jpysocket
import codecs
import json


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
        jsonDATA = json.loads(msg)
        print(jsonDATA["drags_title"])
        print(jsonDATA["drags_description"])
        print(jsonDATA["drags_amount"])
        print(jsonDATA["drags_dosage"])

except KeyboardInterrupt:
    exit(0)
