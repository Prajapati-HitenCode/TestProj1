package com.example.testproj1.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.testproj1.Database.Dao.DataDAO
import com.example.testproj1.Model.DataModel


@Database(entities = [DataModel::class], version = 1)
abstract class Database1 : RoomDatabase() {
    abstract fun datadao(): DataDAO

    companion object{
        private var Instance:Database1?=null
        fun getdatabase(context: Context): Database1{
            if (Instance==null)
            {
                synchronized(this)
                {
                    Instance= databaseBuilder(context,Database1::class.java,"database1").build()
                }
            }
            return Instance!!
        }
    }
}