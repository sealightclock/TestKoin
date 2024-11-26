package com.example.jonathan.testkoin

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import org.koin.core.qualifier.named

private const val TAG = "TK: MyView"

@Composable
fun MainScreen() {
    Log.d(TAG, "MainScreen")

    // State to track the current ViewModel
    var useFirstViewModel by remember { mutableStateOf(true) }

    // Dynamically inject the appropriate ViewModel
    val firstViewModel: FirstViewModel = koinViewModel(named("FirstViewModel"))
    val secondViewModel: SecondViewModel = koinViewModel(named("SecondViewModel"))

    // Use ViewModel data:
    val data = if (useFirstViewModel) {
        firstViewModel.getData()
    } else {
        secondViewModel.getData()
    }

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
            Button(onClick = { useFirstViewModel = !useFirstViewModel }) {
                Text("Switch ViewModel")
            }
        }
    }
}
