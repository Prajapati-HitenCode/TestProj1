package com.example.testproj1.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("persondata")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "Hiten",
    val age:Int= 21
)
