package com.androiddevs.drugsinspectr

import com.androiddevs.drugsinspectr.db.DrugDatabase
import com.androiddevs.drugsinspectr.db.entities.DrugItem

class DrugRepository(
    private val db: DrugDatabase
) {

    suspend fun insert(item: DrugItem) = db.getDrugsDao().insert(item)

    suspend fun delete(item: DrugItem) = db.getDrugsDao().delete(item)

    fun getAllDrugList() = db.getDrugsDao().gatAllTaskList()

    suspend fun deleteById(id: Int) = db.getDrugsDao().deleteById(id)

}