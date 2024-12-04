package com.example.testproj1.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproj1.Model.DataModel
import com.example.testproj1.Repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel@Inject constructor(private val dataRepository: DataRepository) : ViewModel(){

    fun getdata():LiveData<List<DataModel>>
    {
        return dataRepository.getdata()
    }
    fun insertdata(dataModel: DataModel)
    {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.insertdata(dataModel)
        }
    }
}