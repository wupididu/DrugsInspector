package com.androiddevs.drugsinspectr.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.drugsinspectr.db.entities.DrugItem


@Dao
interface DrugsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: DrugItem)

    @Delete()
    suspend fun delete(note: DrugItem)

    @Query("SELECT * FROM drags_item ORDER BY id DESC")
    fun gatAllTaskList(): LiveData<List<DrugItem>>

    @Query("DElETE FROM drags_item WHERE id = :id")
    suspend fun deleteById(id: Int)

}