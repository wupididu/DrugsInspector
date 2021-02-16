package com.androiddevs.drugsinspectr.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androiddevs.drugsinspectr.db.entities.DrugItem

@Database(
    entities = [DrugItem::class],
    version = 1
)
abstract class DrugDatabase: RoomDatabase() {
    abstract fun getDrugsDao(): DrugsDao

    companion object{
        @Volatile
        private var instance: DrugDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context)
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                DrugDatabase::class.java, "DrugsDB.db").build()
    }

}