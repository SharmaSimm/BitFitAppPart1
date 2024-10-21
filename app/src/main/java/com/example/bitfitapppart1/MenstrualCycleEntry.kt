package com.example.bitfitapppart1

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "menstrual_cycle")

data class MenstrualCycleEntry(
//    @PrimaryKey(autoGenerate = true) val id: String = 0,
    val cycleDate: String,      // Start date of the cycle
    val cycleLength: Int,     // Duration in days
    val notes: String?     // Optional notes
)

