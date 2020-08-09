package com.binar.myproject.codechallengebinar_chapter5.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class],version = 1)
abstract class PlayerDatabase: RoomDatabase() {
    abstract fun playerDao(): PlayerDAO

    companion object{
        private var INSTANCE: PlayerDatabase? = null

        fun getInstance(context: Context): PlayerDatabase? {
            if(INSTANCE == null){
                synchronized(PlayerDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        PlayerDatabase::class.java,"Players.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}