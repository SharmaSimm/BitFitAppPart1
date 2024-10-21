package com.example.bitfitapppart1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MenstrualCycleViewModel(private val repository: MenstrualCycleRepository) : ViewModel() {

    // All cycles are now LiveData directly from the repository
    val allCycles: LiveData<List<MenstrualCycleEntry>> = repository.getAllCycles()

    // Insert a new cycle and let the repository handle the updating of LiveData
    fun insert(cycle: MenstrualCycleEntry) = viewModelScope.launch {
        repository.insertCycle(cycle)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAllCycles()
    }

    operator fun invoke(): MenstrualCycleViewModel {

        return TODO("Provide the return value")
    }
}

// ViewModel Factory
class MenstrualCycleViewModelFactory(private val repository: MenstrualCycleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MenstrualCycleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MenstrualCycleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
