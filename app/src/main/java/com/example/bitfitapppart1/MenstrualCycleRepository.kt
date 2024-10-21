package com.example.bitfitapppart1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bitfitapppart1.MenstrualCycleEntry


class MenstrualCycleRepository(private val menstrualCycleDao: MenstrualCycleDao) {

    // Returns LiveData of all menstrual cycles
    fun getAllCycles(): LiveData<List<MenstrualCycleEntry>> {
        return menstrualCycleDao.getAllCycles()  // Ensure this returns LiveData
    }

    suspend fun insertCycle(cycle: MenstrualCycleEntry) {
        menstrualCycleDao.insertCycle(cycle)
    }

    suspend fun deleteAllCycles() {
        menstrualCycleDao.deleteAllCycles()
    }
}
