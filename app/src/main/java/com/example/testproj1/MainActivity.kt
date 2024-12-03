package com.example.testproj1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.testproj1.Database.Database1
import com.example.testproj1.ViewModel.DataViewModelFactory
import com.example.testproj1.Repository.DataRepository
import com.example.testproj1.ViewModel.DataViewModel
import com.example.testproj1.ui.theme.TestProj1Theme

class MainActivity : ComponentActivity() {
    lateinit var dataViewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestProj1Theme {
                val dao= Database1.getdatabase(applicationContext).datadao()
                val dataRepository=DataRepository(dao)
                dataViewModel=ViewModelProvider(this, DataViewModelFactory(dataRepository)).get(DataViewModel::class)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Homepage(modifier = Modifier.padding(innerPadding),dataViewModel)
                }
            }
        }
    }
}

