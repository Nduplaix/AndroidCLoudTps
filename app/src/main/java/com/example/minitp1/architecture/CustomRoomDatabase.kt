package com.example.minitp1.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.minitp1.mmo.dao.MmoDao
import com.example.minitp1.mmo.model.MmoRoom

@Database(
    entities = [
        MmoRoom::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mmoDao() : MmoDao
}
