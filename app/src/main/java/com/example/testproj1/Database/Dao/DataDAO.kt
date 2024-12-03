package com.example.testproj1.Database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testproj1.Model.DataModel


@Dao()
interface DataDAO {

    @Query("Select * From persondata")
    fun getdata(): LiveData<List<DataModel>>

    @Insert
    suspend fun adddata(dataModel: DataModel)
}