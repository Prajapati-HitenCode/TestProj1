package com.example.testproj1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testproj1.Model.DataModel
import com.example.testproj1.ViewModel.DataViewModel

@Composable
fun Homepage(modifier: Modifier,dataViewModel: DataViewModel) {

    val datalist by dataViewModel.getdata().observeAsState(emptyList())

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Center items vertically
    ) {
        // Button to add new data
        Button(
            onClick = {
                dataViewModel.insertdata(DataModel(0, "Hiten", 21))
            },
            modifier = Modifier.padding(bottom = 16.dp) // Add space below the button
        ) {
            Text("Add New Data")
        }

        // Display data or a message if no data is available
        if (datalist.isEmpty()) {
            Text("No data available.")
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Fill the available width
                    .padding(16.dp) // Add padding around the LazyColumn
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth() // Fill the available width
                        .wrapContentSize(Alignment.Center) // Center the LazyColumn horizontally
                ) {
                    items(datalist) { item ->
                        Text("${item.name} and ${item.age}")
                    }
                }
            }
        }
    }
}