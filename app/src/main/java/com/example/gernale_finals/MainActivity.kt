package com.example.gernale_finals
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextField
import com.example.gernale_finals.ui.theme.Gernale_FINALSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gernale_FINALSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingComposable(listOf("Text Composable", "Image Composable", "Row Composable", "Column Composable"))
                }
            }
        }
    }
}

@Composable
fun GreetingComposable(columnTexts: List<String>, modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        columnTexts.forEach { text ->
            // Each column contains a Text composable and a TextField composable
            Column(Modifier.weight(1f)) {
                var userInput by remember { mutableStateOf("") }

                Text(
                    text = text,
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 40.dp)
                )

                TextField(
                    value = userInput,
                    onValueChange = { userInput = it },
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)
                )

                Text(
                    text = "CLICK $userInput",
                    fontSize = 10.sp,
                    color = Color.Blue,  // Set the text color here
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 30.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Gernale_FINALSTheme {
        GreetingComposable(listOf("1", "2", "3", "4"))
    }
}