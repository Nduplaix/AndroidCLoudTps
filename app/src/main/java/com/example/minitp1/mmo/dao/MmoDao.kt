package com.example.minitp1.mmo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.minitp1.mmo.model.MmoRoom

@Dao
interface MmoDao {


    @Query("SELECT * FROM chuck_norris_quote")
    fun selectAll() : LiveData<List<MmoRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisRoom: MmoRoom)


    @Query("DELETE FROM chuck_norris_quote")
    fun deleteAll()
}
