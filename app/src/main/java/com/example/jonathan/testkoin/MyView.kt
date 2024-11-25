package com.example.jonathan.testkoin

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

private const val TAG = "TK: MyView"

@Composable
fun MainScreen() {
    Log.d(TAG, "MainScreen")

    // Inject ViewModel
    //val myViewModel: MyViewModel = koinViewModel()
    val myViewModel = MyViewModel(
        repository = Repository()
    )

    // Use ViewModel's data
    val data = myViewModel.getData()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = data,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Handle button click */ }) {
                Text("Click Me")
            }
        }
    }
}
