package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var state by remember {
                mutableStateOf("")
            }
            val stateList = remember {
                mutableStateListOf<String>()
            }
            Column {
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    items(stateList.size) {
                        Text(text = stateList[it])
                    }
                }

                TextData(state, {
                    state = it
                }, {

                    stateList.add(state)
                    state = ""
                })
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextData(value: String, onValueChange: (String) -> Unit, onClick: () -> Unit) {
    TextField(modifier = Modifier.fillMaxWidth(), value = value, onValueChange = {
        onValueChange(it)
    }, trailingIcon = {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.clickable {
                onClick()
            })
    })


}