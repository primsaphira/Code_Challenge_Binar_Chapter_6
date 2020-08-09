package com.binar.myproject.codechallengebinar_chapter5.room

import androidx.room.*

@Dao
interface PlayerDAO {
    @Query("SELECT * FROM Players")
    fun getAllPlayers(): List<Players>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayers(players: Players):Long
    @Update
    fun updatePlayers(players: Players):Int
    @Delete
    fun deletePlayers(players: Players:Int
}