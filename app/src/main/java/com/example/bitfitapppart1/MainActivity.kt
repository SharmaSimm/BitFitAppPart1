import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bitfitapppart1.ui.theme.BitFitAppPart1Theme
import android.os.Bundle
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.bitfitapppart1.CreateEntryScreen
import com.example.bitfitapppart1.MenstrualCycleViewModel
import com.example.bitfitapppart1.MenstrualCycleViewModelFactory
import com.example.bitfitapppart1.YourApplication

class MainActivity : ComponentActivity() {

    private val menstrualCycleViewModel: MenstrualCycleViewModel by viewModels {
        MenstrualCycleViewModelFactory((application as YourApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BitFitAppPart1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MainScreen(viewModel: MenstrualCycleViewModel) {
    var showCreateEntry by remember { mutableStateOf(false) }

    if (showCreateEntry) {
        CreateEntryScreen(viewModel) {
            showCreateEntry = false  // Hide the entry screen after creation
        }
    } else {
        // Your existing UI or navigation logic
        Button(onClick = { showCreateEntry = true }) {
            Text("Add New Entry")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BitFitAppPart1Theme {
        Greeting("Android")
    }
}
