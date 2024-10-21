package com.example.bitfitapppart1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun EntryListScreen(viewModel: MenstrualCycleViewModel = viewModel()) {
    // Observe LiveData directly from the ViewModel
    val entries: List<MenstrualCycleEntry> by viewModel.allCycles.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Menstrual Cycle Entries", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn to display the list of entries
        LazyColumn {
            items(entries) { entry ->
                EntryItem(entry)
            }
        }
    }
}

@Composable
fun EntryItem(entry: MenstrualCycleEntry) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = "Date: ${entry.cycleDate}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Length: ${entry.cycleLength} days", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Notes: ${entry.notes}", style = MaterialTheme.typography.bodyMedium)
    }
}
