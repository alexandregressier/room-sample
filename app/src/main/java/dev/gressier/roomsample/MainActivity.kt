package dev.gressier.roomsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.gressier.roomsample.data.local.AppDatabase
import dev.gressier.roomsample.ui.SampleScreen
import dev.gressier.roomsample.ui.state.SampleScreenViewModel
import dev.gressier.roomsample.ui.theme.RoomSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myEntityDao = AppDatabase.getDatabase(applicationContext).myEntityDao()
        val viewModel = SampleScreenViewModel(myEntityDao)

        setContent {
            RoomSampleTheme {
               SampleScreen(viewModel = viewModel)
            }
        }
    }
}
