package com.example.bitfitapppart1


import android.app.Application

class YourApplication : Application() {
    val database by lazy { MenstrualCycleDatabase.getDatabase(this) }
    val repository by lazy { MenstrualCycleRepository(database.menstrualCycleDAO()) }
}

