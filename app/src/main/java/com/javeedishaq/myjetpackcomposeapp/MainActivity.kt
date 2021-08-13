package com.javeedishaq.myjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javeedishaq.myjetpackcomposeapp.ui.theme.MyJetPackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "JetPack", "Javeed", "Developer")) {
    val counterState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
    Column(modifier = Modifier.weight(1f)) {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Blue)
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount -> counterState.value = newCount })

    }
}
}

@Composable
fun Counter (count: Int, updateCount: (Int) -> Unit){
    Button(
        onClick = { updateCount(count+1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.Red
        )
        ) {
        Text("I have clicked $count times")
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
MyJetPackComposeAppTheme {
    androidx.compose.material.Surface(color = Color.Yellow) {
         content()
    }

}
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp{"Hello from preview of the app"}
}