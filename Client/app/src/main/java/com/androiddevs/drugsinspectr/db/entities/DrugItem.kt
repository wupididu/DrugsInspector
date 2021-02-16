package com.androiddevs.drugsinspectr.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "drags_item")
class DrugItem(
    @ColumnInfo(name = "drags_title")
    var title: String,
    @ColumnInfo(name = "drags_description")
    var description: String,
    @ColumnInfo(name = "drags_amount")
    var amount: Int,
    @ColumnInfo(name = "drags_dosage")
    var dosage: Float,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
){
}