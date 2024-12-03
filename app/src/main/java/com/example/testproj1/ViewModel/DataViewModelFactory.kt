@file:Suppress("UNCHECKED_CAST")

package com.example.testproj1.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testproj1.Repository.DataRepository

class DataViewModelFactory(private val dataRepository: DataRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(dataRepository) as T
    }

}