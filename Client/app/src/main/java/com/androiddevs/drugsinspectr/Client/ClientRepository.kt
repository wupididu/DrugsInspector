package com.androiddevs.drugsinspectr.Client

import androidx.lifecycle.LiveData
import com.androiddevs.drugsinspectr.db.entities.DrugItem
import com.androiddevs.drugsinspectr.utilits.fromJson
import com.androiddevs.drugsinspectr.utilits.toJson
import com.google.gson.Gson
import java.nio.charset.Charset

class ClientRepository(
    private val client: Client
) {

    fun insert(item: DrugItem) {
        Thread(Runnable {
            kotlin.run {
                val message = "insert ${toJson(item)}"
                client.openConnection()
                client.sendData(message.toByteArray(Charset.defaultCharset()))
                client.closeConnection()
            }

        }).start()

    }

    fun deleteById(id: Int) {
        Thread(Runnable {
            kotlin.run {
                val message = "delete $id"
                client.openConnection()
                client.sendData(message.toByteArray(Charset.defaultCharset()))
                client.closeConnection()
            }
        })

    }

    fun delete(item: DrugItem){
        Thread(Runnable {
            kotlin.run {
                val message = "delete ${toJson(item)}"
                client.openConnection()
                client.sendData(message.toByteArray(Charset.defaultCharset()))
                client.closeConnection()
            }

        }).start()
    }

    fun getAllDrugsList(): List<DrugItem> {
        client.openConnection()
        client.sendData("getAll".toByteArray(Charset.defaultCharset()))
        client.closeConnection()
        val list = client.getData().toString()
        return fromJson(list)
    }

}