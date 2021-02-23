import jpysocket
import codecs
import json


class Drug(object):
    __title = str()
    __description = str()
    __amount = int()
    __dose = float()

    def fromDict(self, jdata):
        self.__title = jdata["drags_title"]
        self.__description = jdata["drags_description"]
        self.__amount = jdata["drags_amount"]
        self.__dose = jdata["drags_dosage"]

    def getTitle(self):
        return self.__title

    def getDescription(self):
        return self.__description

    def getAmount(self):
        return self.__amount

    def getDose(self):
        return self.__dose

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
        drug = Drug()
        print(drug.getTitle())
        print(drug.getDescription())
        print(drug.getAmount())
        print(drug.getDose())
except KeyboardInterrupt:
    exit(0)
