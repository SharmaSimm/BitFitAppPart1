package com.example.bitfitapppart1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface MenstrualCycleDao {

    // Insert a new menstrual cycle entry
    @Insert
    suspend fun insertCycle(cycle: MenstrualCycleEntry)

    // Get all menstrual cycle entries as LiveData
    @Query("SELECT * FROM menstrual_cycles ORDER BY cycleDate DESC")
    fun getAllCycles(): LiveData<List<MenstrualCycleEntry>>

    // Delete a specific menstrual cycle entry
    @Delete
    suspend fun deleteCycle(cycle: MenstrualCycleEntry)

    // Delete all menstrual cycle entries
    @Query("DELETE FROM menstrual_cycles")
    suspend fun deleteAllCycles()
}
