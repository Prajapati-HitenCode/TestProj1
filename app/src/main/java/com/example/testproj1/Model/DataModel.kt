package com.example.testproj1.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("persondata")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age:Int
)
