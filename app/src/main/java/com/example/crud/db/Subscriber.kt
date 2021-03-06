package com.example.crud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//its our dataModel
@Entity(tableName = "subscriber_data_table")
data class Subscriber(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subscriber_id")
    val id:Int,
    @ColumnInfo(name="subscribe_name")
    val name:String,
    @ColumnInfo(name="subscriber_email")
    val email:String
)