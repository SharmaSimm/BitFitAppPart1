package com.example.bitfitapppart1

//This database will manage the menstrual cycle entries

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenstrualCycleEntry::class], version = 1)
abstract class MenstrualCycleDatabase : RoomDatabase() {

    abstract fun menstrualCycleDAO(): MenstrualCycleDAO

    companion object {
        @Volatile
        private var INSTANCE: MenstrualCycleDatabase? = null

        fun getDatabase(context: Context): MenstrualCycleDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MenstrualCycleDatabase::class.java,
                    "menstrual_cycle_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}