package com.androiddevs.drugsinspectr.Client

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.*
import java.net.Socket

class Client {
    val HOST = "192.168.0.220"
    val PORT = 1999

    var socket: Socket? = null
    lateinit var reader: DataInputStream


    fun openConnection(){
        closeConnection()
        try {
            socket = Socket(HOST,PORT)
        }catch (e: IOException){
            Log.d("Client", e.toString())
        }
    }

    fun closeConnection() {
        if(socket?.isClosed != true){
            try {
                socket?.close()
            }catch (e: IOException){
                Log.d("Client", e.toString())
            }
        }
    }

    fun sendData(data: ByteArray){
        if(socket?.isClosed == true){
            Log.d("Client", "Сокет закрыт или не создан")
        }

        try {
            socket?.getOutputStream()?.write(data)
            socket?.getOutputStream()?.flush()
        }catch (e: IOException){
            Log.d("Client", e.toString())
        }
    }

    fun getData(): String?{
        if (socket?.isClosed == true){
            Log.d("Client", "Сокет закрыт или не создан")
        }

        return try {
            reader = DataInputStream(socket?.getInputStream())
            reader.readUTF().toString()
        }catch (e: IOException){
            Log.d("Client", e.toString())
            null
        }finally {
            reader.close()
        }
    }
}