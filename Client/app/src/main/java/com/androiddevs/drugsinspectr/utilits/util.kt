package com.androiddevs.drugsinspectr.utilits

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androiddevs.drugsinspectr.db.entities.DrugItem
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement

fun toJson(item: DrugItem): String{
    return Gson().toJson(item)
}

fun fromJson(item: String): List<DrugItem>{
    val dd = JsonArray()
    dd.add(item)
    val list : MutableList<DrugItem> = mutableListOf()
    dd.forEach {
        list.add(Gson().fromJson(it, DrugItem::class.java))
    }
    return list
}