package com.example.testproj1.Repository

import androidx.lifecycle.LiveData
import com.example.testproj1.Database.Dao.DataDAO
import com.example.testproj1.Model.DataModel
import javax.inject.Inject

class DataRepository@Inject constructor(private val dataDAO: DataDAO) {


    fun getdata(): LiveData<List<DataModel>>
    {
        return dataDAO.getdata()
    }

    suspend fun insertdata(dataModel: DataModel)
    {
        dataDAO.adddata(dataModel)
    }
 }