package dev.gressier.roomsample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.gressier.roomsample.ui.state.SampleScreenViewModel

@Composable
fun SampleScreen(viewModel: SampleScreenViewModel) {
    val entities by viewModel.entities.collectAsStateWithLifecycle(initialValue = emptyList())

    Column {
        Button(onClick = { viewModel.insertEntity() }) {
            Text("Insert MyEntity")
        }
        LazyColumn {
            items(entities) { entity ->
                Text("Entity ID: ${entity.id}")
            }
        }
    }
}