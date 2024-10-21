package com.example.bitfitapppart1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateEntryScreen(viewModel: MenstrualCycleViewModel, onEntryCreated: () -> Unit) {
    var cycleDate by remember { mutableStateOf("") }
    var cycleLength by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Add Menstrual Cycle Entry", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = cycleDate,
            onValueChange = { cycleDate = it },
            label = { Text("Cycle Start Date") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = cycleLength,
            onValueChange = { cycleLength = it },
            label = { Text("Cycle Length (days)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (cycleDate.isNotEmpty() && cycleLength.isNotEmpty()) {
                    try {
                        val length = cycleLength.toInt()
                        viewModel.insert(MenstrualCycleEntry(cycleDate, length.toString(), notes))
                        onEntryCreated()  // Notify that an entry was created
                    } catch (e: NumberFormatException) {
                        // Handle the error
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Entry")
        }
    }
}

fun MenstrualCycleEntry(cycleDate: String, date: String, duration: String): MenstrualCycleEntry {

    return MenstrualCycleEntry(date, duration, cycleDate)
}
