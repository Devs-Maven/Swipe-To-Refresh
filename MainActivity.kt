package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun MyApp(){

    val context = LocalContext.current

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = false),
        indicator = {state, trigger ->
          SwipeRefreshIndicator(
              state = state,
              refreshTriggerDistance = trigger,
              scale = true,
              backgroundColor = MaterialTheme.colors.primary,
          )
        },
        onRefresh = {
                    Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()
        },
    ){

        LazyColumn(
            state = rememberLazyListState(),
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                count = 50,
                itemContent = { value ->
                    ListItem(
                        icon = { Icon(Icons.Default.List,"")},
                        text = { Text("Text $value")},
                        secondaryText = { Text("This is just an example.")},
                        overlineText = { Text("OverLine Text example")}
                    )
                }
            )
        }


    }

}

